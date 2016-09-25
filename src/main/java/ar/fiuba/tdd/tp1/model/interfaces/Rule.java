package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.Move;

public interface Rule extends VisitorOfCell {
    public String getName();

    public boolean isValid(Move move);
}
