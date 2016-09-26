package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.Move;

import java.util.List;

public interface Rule {
    public String getName();

    public boolean isValid(Move move);

    public Rule createNewInstance(List<Object> parametersList);
}
