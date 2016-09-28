package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

public class CellAlphabetical extends Cell {
    private String datum;

    public CellAlphabetical(String datumValue, String nameValue) {
        this.datum = datumValue;
        this.name = nameValue;
    }

    public String getDatum() {
        return this.datum;
    }

    public void setDatum(String datumValue) {
        this.datum = datumValue;
    }
}
