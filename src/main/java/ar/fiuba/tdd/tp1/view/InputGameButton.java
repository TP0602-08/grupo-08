package ar.fiuba.tdd.tp1.view;


import ar.fiuba.tdd.tp1.controller.InputButtonController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InputGameButton extends JButton {

    InputGameButton(String text, InputButtonController controller) {
        super(text);
        controller.setInputGameButton(this);
        this.addMouseListener(controller);

    }

    public String getValue() {
        return this.getText();
    }

}
