package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.util.List;

public class NorinoriGUI extends GameGUI {

    @Override
    protected CellView createNewCellView(CellInfo cellInfo) {
        return new NorinoriCellView(cellInfo, this.validInputs, this.userInputHandler);
    }

    public NorinoriGUI(String gameName, int numberOfRows, int numberOfColumns,
                       List<String> validInputs, List<CellInfo> cellInfoList, UserInputHandler
                               userInputHandler) {
        super(gameName, numberOfRows, numberOfColumns, validInputs, cellInfoList, userInputHandler);
    }
}