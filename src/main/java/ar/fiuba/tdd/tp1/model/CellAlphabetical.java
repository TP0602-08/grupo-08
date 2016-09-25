package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Cell;
import ar.fiuba.tdd.tp1.model.interfaces.Rule;

public class CellAlphabetical implements Cell {
    private String datum;

    public CellAlphabetical(String datumValue) {
        this.datum = datumValue;
    }

    @Override
    public boolean reportToRule(Rule rule) {
        //TODO(Ivan)
        return false;
    }

    public String getDatum() {
        return this.datum;
    }

    public void setDatum(String datumValue) {
        this.datum = datumValue;
    }
}
