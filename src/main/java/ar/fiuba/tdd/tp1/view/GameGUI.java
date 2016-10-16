package ar.fiuba.tdd.tp1.view;


import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.Game;

import java.awt.*;
import java.util.List;
import javax.swing.*;

abstract class GameGUI extends JPanel {

    protected Game gameModel;
    protected int numberOfRows;
    protected int numberOfColumns;
    protected List<Integer> validInputs;
    protected UserInputHandler userInputHandler;


    public abstract void drawGUI();

    protected void drawBorder() {
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
    }

    public abstract void updateCell(int cellId, int value);
}
