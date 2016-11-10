package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GokigenNanameGUI extends GameGUI {

    @Override
    protected CellView createNewCellView(CellInfo cellInfo) {
        return new GokigenNanameCellView(cellInfo,validInputs,userInputHandler);
    }

    private void addClues() {
        Map<Integer,String> cluesMap;
    }

    public GokigenNanameGUI(String gameName, int numberOfRows, int numberOfColumns,
                            List<String> validInputs, List<CellInfo> cellInfoList, UserInputHandler
            userInputHandler) {
        super(gameName, numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
    }
}
