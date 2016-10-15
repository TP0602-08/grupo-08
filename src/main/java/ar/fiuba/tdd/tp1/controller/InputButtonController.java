package ar.fiuba.tdd.tp1.controller;

import ar.fiuba.tdd.tp1.view.GameInputView;
import ar.fiuba.tdd.tp1.view.InputGameButton;

import java.awt.event.MouseEvent;
import java.util.Observable;
import javax.swing.event.MouseInputAdapter;

public class InputButtonController extends MouseInputAdapter {

    private final int cellId;
    private GameInputView gameInputView;
    private InputGameButton inputGameButton;
    private UserInputHandler userInputHandler;

    public InputButtonController(int cellId, UserInputHandler userInputHandler, GameInputView gameInputView) {
        this.cellId = cellId;
        this.gameInputView = gameInputView;
        this.inputGameButton = null;
        this.userInputHandler = userInputHandler;
    }

    public void setInputGameButton(InputGameButton button) {
        this.inputGameButton = button;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        this.userInputHandler.handleInput(this.cellId,this.inputGameButton.getIntValue());
        this.gameInputView.dispose();
    }
}


