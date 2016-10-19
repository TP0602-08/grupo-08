package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.awt.*;
import java.util.List;

public class GokigenNanameGUI extends GameGUI {

    boolean addedCells;

    public GokigenNanameGUI(int numberOfRows, int numberOfColumns, List<String> validInputs, List<CellInfo> cellInfoList, UserInputHandler
            userInputHandler) {
        super(numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
        this.addedCells = false;
    }

    @Override
    public void drawGUI() {
        for (CellInfo cellInfo : this.cellInfoList) {
            this.add(new GokigenNanameCellView(cellInfo,validInputs,userInputHandler));
        }
        this.addedCells = true;
    }
}
