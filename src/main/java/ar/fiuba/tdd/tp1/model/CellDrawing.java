package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;


public class CellDrawing extends Cell{

    private String datum;

    // This is needed for the CellBuilder
    public CellDrawing() {

    }
    //Data values should be "/" and "\"
    public CellDrawing(String datumValue, String nameValue) {
        this.datum = datumValue;
        this.name = nameValue;
        this.editable = true;
        this.empty = (datumValue == null);
    }

    public CellDrawing(String datumValue, String nameValue, Boolean isEditable) {
        this.datum = datumValue;
        this.name = nameValue;
        this.editable = isEditable;
        this.empty = (datumValue == null);
    }

    public String getDatum() {
        return this.datum;
    }

    public String datumToString() { return this.datum; }

    public Boolean isEmpty() { return this.datum == null; }

    public void accept(VisitorOfCell visitor) {
        visitor.visit(this);
    }

    public void setDatum(String datumValue) {
        this.datum = datumValue;
        this.empty = (datumValue == null);
    }
}