package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.CellController;
import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.awt.*;
import java.util.List;

public class NorinoriCellView extends CellView {
    public NorinoriCellView(CellInfo cell, List<String> validInputs, UserInputHandler userInputHandler) {
        super();
        this.setPreferredSize(new Dimension(40,40));
        this.setBackground(Color.WHITE);
        CellController cellController = new CellController(cell.getId(),validInputs,userInputHandler,false);
        this.addMouseListener(cellController);
    }

    @Override
    public void changeDisplayValue(String value) {
        if (value.equalsIgnoreCase("black")) {
            this.setBackground(Color.BLACK);
        } else {
            this.setBackground(Color.WHITE);
        }
    }
}
