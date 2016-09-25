package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Cell;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

public class CellNumerical implements Cell {
    private int datum;

    public CellNumerical(int datumValue) {
        this.datum = datumValue;
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
}
