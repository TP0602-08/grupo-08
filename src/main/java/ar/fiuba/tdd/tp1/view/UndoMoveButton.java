package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.UndoButtonController;
import ar.fiuba.tdd.tp1.controller.UndoButtonHandler;

import javax.swing.*;

public class UndoMoveButton extends JButton {

    public UndoMoveButton(UndoButtonHandler undoButtonHandler) {
        super("undo");
        this.addMouseListener(new UndoButtonController(undoButtonHandler));
    }

}
