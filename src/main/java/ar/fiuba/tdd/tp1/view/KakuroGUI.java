package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.awt.*;
import java.util.List;

class KakuroGUI extends GameGUI {

    KakuroGUI(int numberOfRows, int numberOfColumns, List<String> validInputs, List<CellInfo> cellInfoList, UserInputHandler
            userInputHandler) {
        super(numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
    }

    @Override
    public void drawGUI() {
        for (CellInfo cellInfo : this.cellInfoList) {
            this.add(new KakuroCellView(cellInfo,validInputs,userInputHandler));
        }
    }
}






