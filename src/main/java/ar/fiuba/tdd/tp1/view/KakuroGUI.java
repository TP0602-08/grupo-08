package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.awt.*;
import java.util.List;

class KakuroGUI extends GameGUI {

    private List<CellInfo> cellInfoList;

    KakuroGUI(int numberOfRows, int numberOfColumns, List<Integer> validInputs, List<CellInfo> cellInfoList, UserInputHandler
            userInputHandler) {
        this.cellInfoList = cellInfoList;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.validInputs = validInputs;
        this.userInputHandler = userInputHandler;
        this.drawBorder();
    }

    @Override
    public void drawGUI() {
        this.setLayout(new GridLayout(0,this.numberOfColumns));
        for (CellInfo cellInfo : this.cellInfoList) {
            this.add(new KakuroCellView(cellInfo,validInputs,userInputHandler));
        }
    }

    @Override
    public void updateCell(int cellId, int value) {
        Component cell = this.getComponent(cellId - 1);
        ((KakuroCellView) cell).changeDisplayValue(value);
    }


}






