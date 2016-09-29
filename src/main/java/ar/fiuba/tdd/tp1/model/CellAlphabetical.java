package ar.fiuba.tdd.tp1.model;

public class CellAlphabetical extends Cell {
    private String datum;

    public String getDatum() {
        return this.datum;
    }

    public CellAlphabetical(String datumValue, String nameValue) {
        this.name = nameValue;
        this.datum = datumValue;
    }

    public void setDatum(String datumValue) {
        this.datum = datumValue;
    }
}
