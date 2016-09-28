package ar.fiuba.tdd.tp1.model;

public class CellNumerical extends Cell {
    private int datum;

    public CellNumerical(int datumValue, String nameValue) {
        this.datum = datumValue;
        this.name = nameValue;
    }

    public Integer getDatum() {
        return this.datum;
    }

    public void setDatum(int datumValue) {
        this.datum = datumValue;
    }
}
