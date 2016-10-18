package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

import java.util.Observable;

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
