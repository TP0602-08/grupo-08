package ar.fiuba.tdd.tp1.controller;

import ar.fiuba.tdd.tp1.view.InputGameButton;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

public class GameButtonController extends MouseInputAdapter {

    private InputGameButton inputGameButton;

    public void setInputGameButton(InputGameButton button) {
        this.inputGameButton = button;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        System.out.println("button pressed: " + this.inputGameButton.getText());
    }
}


