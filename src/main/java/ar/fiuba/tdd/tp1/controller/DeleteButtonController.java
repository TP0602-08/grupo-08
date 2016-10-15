package ar.fiuba.tdd.tp1.controller;

import ar.fiuba.tdd.tp1.view.GameInputView;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

public class DeleteButtonController extends MouseInputAdapter{

    private int cellId;
    private UserInputHandler userInputHandler;
    private GameInputView gameInputView;

    public DeleteButtonController(int cellId, UserInputHandler userInputHandler, GameInputView gameInputView) {
        this.cellId = cellId;
        this.userInputHandler = userInputHandler;
        this.gameInputView = gameInputView;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        this.userInputHandler.handleInput(this.cellId,0);
        this.gameInputView.dispose();
    }
}
