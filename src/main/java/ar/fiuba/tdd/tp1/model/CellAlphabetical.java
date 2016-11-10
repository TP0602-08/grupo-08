package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;
/*This class implements the cell interface. It represents an alphabetic cell which will
receive a string as a parameter that represents the cell ID (datanum) and a name (nameValue)
It has the same cell methods
IsEmpty: Returns true if the cell has a null object (it is empty)
Accept: Use the board's Visit method
DataToString: Also returns the value of the cell in string
GetDatum: Returns the value of the cell in string
In addition to the setDatum methods that allow us to set the value of the cell*/
public class CellAlphabetical extends Cell {
    private String datum;

    // This is needed for CellBuilder
    public CellAlphabetical() {

    }

    public CellAlphabetical(String datumValue, String nameValue) {
        this.name = nameValue;
        this.datum = datumValue;
        this.editable = true;
        this.empty = (datumValue == null);
    }

    public CellAlphabetical(String datumValue, String nameValue, Boolean isEditable) {
        this.name = nameValue;
        this.datum = datumValue;
        this.editable = isEditable;
        this.empty = (datumValue == null);
    }


    public void setDatum(String datumValue) {
        this.datum = datumValue;
    }

    public Boolean isEmpty() {
        return this.datum == null;
    }

    public void accept(VisitorOfCell visitor) {
        visitor.visit(this);
    }

    public String datumToString() {
        return this.datum;
    }

    public String getDatum() {
        return this.datum;
    }

}
