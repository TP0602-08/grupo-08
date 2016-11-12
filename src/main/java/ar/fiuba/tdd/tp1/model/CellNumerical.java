package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;
/*This class implements the cell interface. It represents an numeric cell which will
receive a Integer as a parameter that represents the cell ID (datanum) and a name (nameValue)
It has the same cell methods
IsEmpty: Returns true if the cell has a null object (it is empty)
Accept: Use the board's Visit method
DatumToString: Also returns the value of the cell in string
GetDatum: Returns the value of the cell in string
In addition to the setDatum methods that allow us to set the value of the cell*/
public class CellNumerical extends Cell {
    private Integer datum;

    // This is needed for the CellBuilder
    public CellNumerical() {

    }

    public CellNumerical(Integer datumValue, String nameValue) {
        this.datum = datumValue;
        this.name = nameValue;
        this.editable = true;
        this.empty = (datumValue == 0);
    }

    public CellNumerical(Integer datumValue, String nameValue, Boolean isEditable) {
        this.datum = datumValue;
        this.name = nameValue;
        this.editable = isEditable;
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
    }
}
