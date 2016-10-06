package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

import java.util.Observable;

public abstract class Cell extends Observable {
    public boolean editable;
    public boolean empty;
    protected String name;

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
