package ar.fiuba.tdd.tp1.controller;

import java.util.Observable;

public class UndoButtonHandler extends Observable {

    public UndoButtonHandler() {

    }

    public void handleUndo() {
        setChanged();
        notifyObservers(this);
    }

}
