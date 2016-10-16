package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.EndGameCondition;
import ar.fiuba.tdd.tp1.view.InputGameButton;

import java.util.*;

public class Game {
    private Rulebook rulebook;
    private Board board;
    private List<Move> moves;
    private List<MoveHistory> moveHistory = new ArrayList<>();
    private EndGameCondition endGameCondition;

    //Both the Rulebook and the Board must be already initialized.
    public Game(Rulebook rulebookValue, Board boardValue) {
        this.rulebook = rulebookValue;
        this.board = boardValue;
        this.endGameCondition = new EndGameAllCellsFilled(); // by default, let's consider the condition that all cells are filled
    }

    public Game(Rulebook rulebookValue, Board boardValue, EndGameCondition endGameCondition) {
        this.rulebook = rulebookValue;
        this.board = boardValue;
        this.endGameCondition = endGameCondition;
    }

    //Receives a new user move and checks if it is valid. If it is valid, then it applies it to the board
    public void process(Move move) {
        if (board.getCellFromCellId(move.getcellId()).editable) {
            rulebook.validate(move);
            if (move.isValid()) {
                board.apply(move);
            }
        } else {
            List<Integer> listOfConflictingCellIds = new ArrayList<Integer>();
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
                board.apply(move);
            }
            this.moveHistory.add(new MoveHistory(move, move.isValid()));
        }
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

    //Returns a list of the allowed user inputs for this game.
    public List<Integer> getValidInputs() {
        return new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public List<MoveHistory> getMoveHistory() {
        return this.moveHistory;
    }

    public BoardReport getBoardReport() {
        boolean status = this.moveHistory.get(this.moveHistory.size() - 1).wasValid();

        Map<Integer, Integer> boardValuesMap = this.board.getBoardValues();
        List<BoardValue> boardValuesList = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : boardValuesMap.entrySet()) {
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
            editable = board.getCellFromCellId(cellId).isEmpty();
            cellInfoList.add(new CellInfo(cellId, value, editable));
        }
        return cellInfoList;
    }

    public Boolean isGameWon() {
        Boolean rulesValid = true;
        for (Rule rule : this.rulebook.getRulesList()) {
            rulesValid = rulesValid && rule.isValid();
        }
        return rulesValid && this.endGameCondition.validate((BoardRectangularWithRegions)this.board);
    }
}
