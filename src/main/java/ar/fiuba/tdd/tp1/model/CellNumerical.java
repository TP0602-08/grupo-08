package ar.fiuba.tdd.tp1.model;

public class CellNumerical extends Cell {
    private Integer datum;

    public CellNumerical(Integer datumValue, String nameValue) {
        this.datum = datumValue;
        this.name = nameValue;
    }

    public Integer getDatum() {
        return this.datum;
    }

    public String datumToString() {
        return this.datum.toString();
    }

    public void setDatum(Integer datumValue) {
        this.datum = datumValue;
    }
}
