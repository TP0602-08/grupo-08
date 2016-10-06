package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;

import java.util.*;

public class Game {
    private Rulebook rulebook;
    private Board board;
    private List<Move> moves;
    private List<MoveHistory> moveHistory = new ArrayList<>();

    //Both the Rulebook and the Board must be already initialized.
    public Game(Rulebook rulebookValue, Board boardValue) {
        this.rulebook = rulebookValue;
        this.board = boardValue;
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

    //TODO: Ver si esto está bien.
    public Board getBoard() {
        return this.board;
    }

    //TODO: Veri si esto está bien
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    //TODO: Esto lo agrego porque actualmente moves no se usa para nada, y sino findBugs tira error
    public List<Move> getMoves() {
        return this.moves;
    }

}
