package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

public class CellAlphabetical extends Cell {
    private String datum;

    public CellAlphabetical(String datumValue, String nameValue) {
        this.name = nameValue;
        this.datum = datumValue;
        this.editable = true;
        this.empty = (datumValue == null);
    }

    public void setDatum(String datumValue) {
        this.datum = datumValue;
    }

    public Boolean isEmpty() {
        return this.datum == null;
    }

    public void accept(VisitorOfCell visitor) {
        visitor.visit(this);
    }

    public String datumToString() {
        return this.datum;
    }

    public String getDatum() {
        return this.datum;
    }

}
