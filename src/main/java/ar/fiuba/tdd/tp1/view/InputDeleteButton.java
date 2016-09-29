package ar.fiuba.tdd.tp1.view;


import ar.fiuba.tdd.tp1.controller.DeleteButtonController;

import javax.swing.*;


public class InputDeleteButton extends JButton {

    public InputDeleteButton(String text, DeleteButtonController controller) {
        super(text);
        this.addMouseListener(controller);
    }


}
