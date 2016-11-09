package ar.fiuba.tdd.tp1.controller;

import java.util.Observable;

public class UndoButtonHandler extends Observable {

    private String undoValue;

    public UndoButtonHandler(String undoValue) {
        this.undoValue = undoValue;
    }

    public void handleUndo() {
        setChanged();
        notifyObservers(this);
    }

    public String getUndoValue() {
        return this.undoValue;
    }
}
