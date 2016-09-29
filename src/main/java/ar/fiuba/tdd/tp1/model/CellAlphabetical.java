package ar.fiuba.tdd.tp1.model;

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

    public String getDatum() {
        return this.datum;
    }

}
