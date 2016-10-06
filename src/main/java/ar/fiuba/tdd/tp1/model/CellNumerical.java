package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

public class CellNumerical extends Cell {
    private Integer datum;

    public CellNumerical(Integer datumValue, String nameValue) {
        this.datum = datumValue;
        this.name = nameValue;
        this.editable = true;
        this.empty = (datumValue == 0);
    }

    public Integer getDatum() {
        return this.datum;
    }

    public String datumToString() {
        return this.datum.toString();
    }

    public Boolean isEmpty() {
        return this.datum == 0;
    }

    public void accept(VisitorOfCell visitor) {
        visitor.visit(this);
    }

    public void setDatum(Integer datumValue) {

        this.datum = datumValue;
        this.empty = (datumValue == 0);
        setChanged();
        notifyObservers(datumValue);
    }
}
