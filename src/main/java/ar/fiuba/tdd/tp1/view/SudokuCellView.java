package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.CellController;
import ar.fiuba.tdd.tp1.model.Cell;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.awt.*;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.CompoundBorder;

class SudokuCellView extends JButton implements Observer {

    public SudokuCellView(CellInfo cell) {
        super();
        this.setBackground(Color.WHITE);
        this.setText(cell.getValue());
    }

    @Override
    public void update(Observable cell, Object datum) {
        this.setText(datum.toString());
    }

    public void changeDisplayValue(int value) {

    }
}
