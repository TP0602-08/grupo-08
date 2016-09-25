package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.Move;

public interface Rule {
    public String getName();

    public boolean isValid(Move move);
}
