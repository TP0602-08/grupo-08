package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.util.List;

class KakuroGUI extends GameGUI {

    public KakuroGUI(String gameName, int numberOfRows, int numberOfColumns,
                     List<String> validInputs, List<CellInfo> cellInfoList, UserInputHandler
            userInputHandler) {
        super(gameName, numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
    }

    @Override
    protected CellView createNewCellView(CellInfo cellInfo) {
        return new KakuroCellView(cellInfo,this.validInputs,this.userInputHandler);
    }
}






