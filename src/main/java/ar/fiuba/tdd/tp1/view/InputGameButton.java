package ar.fiuba.tdd.tp1.view;


import ar.fiuba.tdd.tp1.controller.GameButtonController;

import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

public class InputGameButton extends JButton {

    public InputGameButton(String text, GameButtonController controller) {
        super(text);
        controller.setInputGameButton(this);
        this.addMouseListener(controller);

    }
}
