package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.CellController;
import ar.fiuba.tdd.tp1.model.Cell;

import java.awt.*;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class SudokuCellView extends JButton implements Observer {

    public SudokuCellView(Cell cell) {
        super();
        this.setBackground(Color.WHITE);

        boolean editable = (Integer) cell.getDatum() == 0;
        if (editable) {
            cell.addObserver(this);
            this.addMouseListener(new CellController());
        } else {
            this.setText(cell.datumToString());
            this.setEnabled(false);
        }
    }

    @Override
    public void update(Observable cell, Object datum) {
        System.out.println("se registro un update");
        this.setText(datum.toString());
    }
}
