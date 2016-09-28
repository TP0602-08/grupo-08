package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

public class CellNumerical extends Cell {
    private int datum;

    public CellNumerical(int datumValue, String nameValue) {
        this.datum = datumValue;
        this.name = nameValue;
    }

    public int getDatum() {
        return this.datum;
    }

    public void setDatum(int datumValue) {
        this.datum = datumValue;
    }
}
