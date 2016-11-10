package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.EndGameCondition;
import ar.fiuba.tdd.tp1.view.InputGameButton;

import java.util.*;

public class Game {
    private Rulebook rulebook;
    private Board board;
    private List<Move> moves;
    private Stack<Cell> appliedMoves = new Stack<>();
    private List<MoveHistory> moveHistory = new ArrayList<>();
    private List<EndGameCondition> endGameConditions;
    private List<String> validInputs;
    private boolean alphabeticalCell;

    //Both the Rulebook and the Board must be already initialized.
    public Game(Rulebook rulebookValue, Board boardValue) {
        this.rulebook = rulebookValue;
        this.board = boardValue;
        this.endGameConditions = new ArrayList<>(
                Arrays.asList(
                        new EndGameAllCellsFilled()
                )
        ); // by default, let's consider the condition that all cells are filled
    }

    public Game(Rulebook rulebookValue, Board boardValue, List<EndGameCondition> endGameConditions) {
        this.rulebook = rulebookValue;
        this.board = boardValue;
        this.endGameConditions = endGameConditions;
    }

    //Receives a new user move and checks if it is valid. If it is valid, then it applies it to the board
    public void process(Move move) {
        if (board.getCellFromCellId(move.getcellId()).editable) {
            rulebook.validate(move);
            if (move.isValid()) {
                applyMove(move);
            }
        } else {
            List<Integer> listOfConflictingCellIds = new ArrayList<>();
            listOfConflictingCellIds.add(move.getcellId());
            move.addViolationOfRule(new ViolationOfRule("Not and editable cell", listOfConflictingCellIds));
        }
        this.moveHistory.add(new MoveHistory(move, move.isValid()));
    }

    //Receives a list of moves and validates them one by one, if the move is valid applies it to the board
    public void process() {
        this.moveHistory = new ArrayList<>();
        for (Move move : moves) {
            rulebook.validate(move);
            if (move.isValid()) {
                applyMove(move);
            }
            this.moveHistory.add(new MoveHistory(move, move.isValid()));
        }
    }

    private void applyMove(Move move) {
        this.appliedMoves.push(createCell(board.getCellFromCellId(move.getcellId()).datumToString(), move.getcellId()));
        board.apply(move);
    }

    public void undo() {
        if (! this.appliedMoves.isEmpty()) {
            Move undoMove = new Move(Integer.parseInt(this.appliedMoves.peek().getName()),this.appliedMoves.pop());
            this.board.apply(undoMove);
            this.moveHistory.add(new MoveHistory(undoMove, undoMove.isValid()));
        }
    }



    private Cell createCell(String value, int newCellId) {
        if (this.alphabeticalCell) {
            if (value == null || value.equals("0")) {
                value = null;
            }
            return new CellAlphabetical(value, Integer.toString(newCellId),true);
        } else {
            return new CellNumerical(Integer.parseInt(value), Integer.toString(newCellId));
        }
    }

    public int getAppliedMovesCount() {
        return this.appliedMoves.size();
    }

    public int getIdOfLastAppliedMove() {
        return Integer.parseInt(this.appliedMoves.peek().getName());
    }

    public String getStringValueOfLastAppliedMove() {
        return this.appliedMoves.peek().datumToString();
    }

    public List<Integer> getCellsIdInRegion(String regionId) {
        return this.board.getCellIdsListFromRegionId(regionId);
    }


    public Cell getCell(int id) {
        return this.board.getCellFromCellId(id);
    }

    public int getNumberOfRows() {
        return this.board.getRowQuantity();
    }

    public int getNumberOfColumns() {
        return this.board.getColumnQuantity();
    }

    public void setValidInputs(List<String> validInputs) {
        this.validInputs = validInputs;
    }

    //Returns a list of the allowed user inputs for this game.
    public List<String> getValidInputs() {
        return this.validInputs;
    }

    public List<MoveHistory> getMoveHistory() {
        return this.moveHistory;
    }

    public BoardReport getBoardReport() {
        boolean status = this.moveHistory.get(this.moveHistory.size() - 1).wasValid();

        Map<Integer, String> boardValuesMap = this.board.getBoardValues();
        List<BoardValue> boardValuesList = new LinkedList<>();
        for (Map.Entry<Integer, String> entry : boardValuesMap.entrySet()) {
            boardValuesList.add(new BoardValue(entry.getKey(), board.getColumnQuantity(), entry.getValue()));
        }
        return new BoardReport(status, boardValuesList);
    }

    public Board getBoard() {
        return this.board;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Move> getMoves() {
        return this.moves;
    }

    public Rulebook getRulebook() {
        return this.rulebook;
    }

    public List<CellInfo> getCellsInfo() {
        List<CellInfo> cellInfoList = new LinkedList<>();
        String value;
        boolean editable;

        for (int cellId = 1; cellId <= board.getNumberOfCells(); cellId++) {
            value = board.getCellFromCellId(cellId).datumToString();
            editable = board.getCellFromCellId(cellId).editable;
            cellInfoList.add(new CellInfo(cellId, value, editable));
        }
        return cellInfoList;
    }

    public Boolean isGameWon() {
        Boolean rulesValid = true;
        for (Rule rule : this.rulebook.getRulesList()) {
            rulesValid = rulesValid && rule.isValid();
        }
        for (EndGameCondition endGameCondition : this.endGameConditions) {
            rulesValid = rulesValid && endGameCondition.validate((BoardRectangularWithRegions)this.board);
        }
        return rulesValid;
    }

    public void setAlphabeticalCell(boolean value) {
        this.alphabeticalCell = value;
    }
}
