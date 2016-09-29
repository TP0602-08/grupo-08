package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.CellController;

import java.awt.*;
import javax.swing.*;

public class SudokuCellView extends JButton {

    public SudokuCellView(String value, boolean editable) {
        super();
        this.setBackground(Color.WHITE);
        if (editable) {
            this.addMouseListener(new CellController());
        } else {
            this.setText(value);
            this.setEnabled(false);
        }
    }
}
