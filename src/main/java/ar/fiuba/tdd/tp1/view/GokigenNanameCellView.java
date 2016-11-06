package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.CellController;
import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.awt.*;
import java.util.List;

public class GokigenNanameCellView extends CellView {
    public GokigenNanameCellView(CellInfo cell, List<String> validInputs, UserInputHandler userInputHandler) {
        super();
        this.setPreferredSize(new Dimension(60,60));
        this.setBackground(Color.WHITE);
        CellController cellController = new CellController(cell.getId(),validInputs,userInputHandler,true);
        this.addMouseListener(cellController);
    }
}
