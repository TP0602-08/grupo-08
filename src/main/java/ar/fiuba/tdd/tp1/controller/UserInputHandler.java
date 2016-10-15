package ar.fiuba.tdd.tp1.controller;



import java.util.List;
import java.util.Observable;

public class UserInputHandler extends Observable {

    private Integer cellId;
    private Integer value;

    public UserInputHandler() {
        this.cellId = null;
        this.value = null;
    }

    public void handleInput(int cellId, int value) {
        this.cellId = cellId;
        this.value = value;
        setChanged();
        notifyObservers(this);
    }

    public Integer getCellId() {
        return this.cellId;
    }

    public Integer getValue() {
        return this.value;
    }




}
