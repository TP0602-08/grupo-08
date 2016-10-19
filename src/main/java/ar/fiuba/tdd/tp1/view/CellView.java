package ar.fiuba.tdd.tp1.view;

import javax.swing.*;

public class CellView extends JButton {

    public void changeDisplayValue(String value) {
        if (! value.equals("0")) {
            this.setText(value);
        } else {
            this.setText("");
        }
    }
}
