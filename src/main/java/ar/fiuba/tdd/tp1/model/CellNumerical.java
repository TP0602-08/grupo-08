package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Cell;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

public class CellNumerical implements Cell {
    private int datum;
    private String name;

    public CellNumerical(int datumValue, String nameValue) {
        this.datum = datumValue;
        this.name = nameValue;
    }

    @Override
    public void accept(VisitorOfCell visitor) {
        visitor.visit(this);
    }

    public int getDatum() {
        return this.datum;
    }

    public void setDatum(int datumValue) {
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
