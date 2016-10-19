package ar.fiuba.tdd.tp1.controller;



import java.util.List;
import java.util.Observable;

public class UserInputHandler extends Observable {

    private Integer cellId;
    private String value;

    public UserInputHandler() {
        this.cellId = null;
        this.value = null;
    }

    public void handleInput(int cellId, String value) {
        this.cellId = cellId;
        this.value = value;
        setChanged();
        notifyObservers(this);
    }

    public Integer getCellId() {
        return this.cellId;
    }

    public String getValue() {
        return this.value;
    }




}
