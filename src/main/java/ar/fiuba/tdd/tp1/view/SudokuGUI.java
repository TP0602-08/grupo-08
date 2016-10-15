package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.Cell;
import ar.fiuba.tdd.tp1.model.CellInfo;
import ar.fiuba.tdd.tp1.model.Game;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SudokuGUI extends GameGUI {

    private int subRegions;
    private List<CellInfo> cellInfoList;

    public SudokuGUI(int numberOfRows, int numberOfColumns, List<Integer> validInputs, List<CellInfo> cellInfoList, UserInputHandler
            userInputHandler) {
        super();
        this.cellInfoList = cellInfoList;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.subRegions = numberOfColumns;
        this.validInputs = validInputs;
        this.drawBorder();
    }

    public void drawGUI() {
        //int subGridColumns = (int) Math.sqrt(subRegions);
        this.setLayout(new GridLayout(0,9));
        for (CellInfo cellInfo : this.cellInfoList) {
            this.add(new SudokuCellView(cellInfo));
        }
    }

    @Override
    public void updateCell(int cellId, int value) {

    }

}
