package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.CellController;
import ar.fiuba.tdd.tp1.controller.DeleteButtonController;
import ar.fiuba.tdd.tp1.controller.GameButtonController;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;


public class SudokuCellView extends JButton {

    public SudokuCellView(String value, boolean editable) {
        super(value);
        this.setBackground(Color.WHITE);
        if (editable) {
            this.addMouseListener(new CellController());
        } else {
            this.setEnabled(false);
        }
    }
}
