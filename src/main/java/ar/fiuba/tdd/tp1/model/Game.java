package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;

public class Game {
    private Rulebook rulebook;
    private Board board;

    //Both the Rulebook and the Board must be already initialized.
    public Game(Rulebook rulebookValue, Board boardValue) {
        //TODO(Ivan) Ver si está bien "pasarle" los objetos así, o si necesita hacer copias de las listas, mapas y sus elementos.
        this.rulebook = rulebookValue;
        this.board = boardValue;
    }

    //Receives a new user move and checks if it is valid. If it is valid, then it applies it to the board
    public void process(Move move) {
        //TODO(Ivan) Probably better to just call getViolations and check if the list is empty, but Rulebook should have this two methods...
        if (rulebook.isAValidMove(move)) {
            board.apply(move);
        } else {
            rulebook.getViolations(move);
        }
    }
}
