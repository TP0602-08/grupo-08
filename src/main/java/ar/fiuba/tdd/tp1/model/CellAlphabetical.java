package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Cell;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

public class CellAlphabetical implements Cell {
    private String datum;
    private String name;

    public CellAlphabetical(String datumValue, String nameValue) {
        this.datum = datumValue;
        this.name = nameValue;
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

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String nameValue) {
        this.name = nameValue;
    }


}
