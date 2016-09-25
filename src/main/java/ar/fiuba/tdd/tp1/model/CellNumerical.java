package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Cell;
import ar.fiuba.tdd.tp1.model.interfaces.Rule;

public class CellNumerical implements Cell {
    private int datum;

    public CellNumerical(int datumValue) {
        this.datum = datumValue;
    }

    @Override
    public boolean reportToRule(Rule rule) {
        //TODO(Ivan)
        return false;
    }

    public int getDatum() {
        return this.datum;
    }

    public void setDatum(int datumValue) {
        this.datum = datumValue;
    }
}
