package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.CellController;
import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class KakuroCellView extends CellView{

    public KakuroCellView(CellInfo cell, List<String> validInputs, UserInputHandler userInputHandler) {
        super();
        if (cell.isEditable()) {
            CellController cellController = new CellController(cell.getId(),validInputs,userInputHandler);
            this.setBackground(Color.WHITE);
            this.addMouseListener(cellController);
        } else {
            this.setBackground(Color.BLACK);
            if (!cell.getValue().equals("0")) {
                this.setText(cell.getValue());
            }
            this.setEnabled(false);
        }
    }

}