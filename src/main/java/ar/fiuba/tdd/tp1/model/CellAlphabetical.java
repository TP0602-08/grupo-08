package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Cell;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

public class CellAlphabetical implements Cell {
    private String datum;

    public CellAlphabetical(String datumValue) {
        this.datum = datumValue;
    }

    @Override
    public void accept(VisitorOfCell visitor) {
        visitor.visit(this);
    }

    public String getDatum() {
        return this.datum;
    }

    public void setDatum(String datumValue) {
        this.datum = datumValue;
    }
}
