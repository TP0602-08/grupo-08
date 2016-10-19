package ar.fiuba.tdd.tp1.view;

import javax.swing.*;

public class CellView extends JButton {

    public void changeDisplayValue(int value) {
        if (value != 0) {
            this.setText(Integer.toString(value));
        } else {
            this.setText("");
        }
    }
}
