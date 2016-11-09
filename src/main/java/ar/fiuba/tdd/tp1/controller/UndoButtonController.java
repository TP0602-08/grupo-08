package ar.fiuba.tdd.tp1.controller;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

public class UndoButtonController extends MouseInputAdapter {

    private UndoButtonHandler undoButtonHandler;

    public UndoButtonController(UndoButtonHandler undoButtonHandler) {
        this.undoButtonHandler = undoButtonHandler;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        this.undoButtonHandler.handleUndo();
    }
}
