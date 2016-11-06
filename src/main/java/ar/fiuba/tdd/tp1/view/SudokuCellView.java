package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.CellController;
import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.Cell;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.CompoundBorder;

class SudokuCellView extends CellView {

    private int id;

    public SudokuCellView(CellInfo cell, List<String> validInputs, UserInputHandler userInputHandler) {
        super();
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(50,50));
        this.id = cell.getId();

        if (cell.isEditable()) {
            CellController cellController = new CellController(cell.getId(),validInputs,userInputHandler,true);
            this.addMouseListener(cellController);
        } else {
            this.setText(cell.getValue());
            this.setEnabled(false);
        }

    }

    public int getId() {
        return this.id;
    }

}
