package ar.fiuba.tdd.tp1.view;


import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;
import ar.fiuba.tdd.tp1.model.Game;

import java.awt.*;
import java.util.List;
import javax.swing.*;

abstract class GameGUI extends JPanel {

    protected int numberOfRows;
    protected int numberOfColumns;
    protected List<String> validInputs;
    protected UserInputHandler userInputHandler;
    protected List<CellInfo>  cellInfoList;

    protected GameGUI(int numberOfRows, int numberOfColumns, List<String> validInputs, List<CellInfo> cellInfoList, UserInputHandler
            userInputHandler) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.validInputs = validInputs;
        this.cellInfoList = cellInfoList;
        this.userInputHandler = userInputHandler;
        this.setLayout((new GridLayout(0,this.numberOfColumns)));
        this.drawBorder();
    }


    public void drawGUI() {
        for (CellInfo cellInfo : this.cellInfoList) {
            this.add(createNewCellView(cellInfo));
        }
    }

    protected abstract CellView createNewCellView(CellInfo cellInfo);

    private void drawBorder() {
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
    }

    public void updateCell(int cellId, String value) {
        Component cell = this.getComponent(cellId - 1);
        ((CellView) cell).changeDisplayValue(value);
    }
}
