package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

import java.util.Observable;

/**
 * It is representing an abstract interface cell
 Within the model, a cell represents a box on the board and its contents.
 Each cell is self-defined itself by which will be part of its attributes:
 -The position it takes on the board (row number, column number).
 -His content
 -If it is editable or not (ie, if its content can be changed).
 -A name recognition.
 - And implementation of the method accept (Visitor design pattern) of states that
 form give the value of the cell to a visitor class.
 */

public abstract class Cell {
    public boolean editable;
    public boolean empty;
    protected String name;
    protected int[] position = new int[] {-1, -1};

    public int getRow() {
        return this.position[0];
    }

    public int getColumn() {
        return this.position[1];
    }

    public void setRow(int row) {
        this.position[0] = row;
    }

    public void setColumn(int column) {
        this.position[1] = column;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String nameValue) {
        this.name = nameValue;
    }

    public abstract Object getDatum();

    public abstract Boolean isEmpty();

    public abstract String datumToString();

    //Allows to do double dispatch with different kinds of cells.
    public abstract void accept(VisitorOfCell visitor);
}
