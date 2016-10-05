package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;

import java.util.List;

public abstract class Rule {
    protected Board board;

    //This constructor with is for creating an instance that'll act as a prototype for creating new instances with method
    // "createNewInstance".
    public Rule(Board boardValue) {
        this.board = boardValue;
    }

    public abstract String getName();

    public abstract boolean validate(Move move);

    public abstract Rule createNewInstance(List<Object> parametersList);
}
