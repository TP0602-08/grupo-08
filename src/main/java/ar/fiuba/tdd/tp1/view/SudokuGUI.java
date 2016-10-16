package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.Cell;
import ar.fiuba.tdd.tp1.model.CellInfo;
import ar.fiuba.tdd.tp1.model.Game;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import javax.swing.*;

public class SudokuGUI extends GameGUI {

    private int subGrids;
    private List<CellInfo> cellInfoList;

    public SudokuGUI(int numberOfRows, int numberOfColumns, List<Integer> validInputs, List<CellInfo> cellInfoList, UserInputHandler
            userInputHandler) {
        super();
        this.cellInfoList = cellInfoList;
        this.userInputHandler = userInputHandler;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.subGrids = numberOfColumns;
        this.validInputs = validInputs;
        this.drawBorder();
    }

    public void drawGUI() {
        int columnsPerSubGrid = (int) Math.sqrt(this.numberOfColumns);
        this.setLayout(new GridLayout(0, this.numberOfColumns / columnsPerSubGrid ));
        createSubGrids();
        fillBoard(columnsPerSubGrid);
    }

    private void fillBoard(int columnsPerSubGrid) {
        int firstCellNumber = 0;
        int firstGridNumber = 0;
        int totalAmountOfCells = this.numberOfRows * this.numberOfColumns;

        while (firstCellNumber < totalAmountOfCells) {
            fillSubgrids(columnsPerSubGrid,firstCellNumber,firstGridNumber);
            firstCellNumber = firstCellNumber + numberOfColumns * columnsPerSubGrid;
            firstGridNumber = firstGridNumber + columnsPerSubGrid;
        }

    }

    private void fillSubgrids(int columnsPerSubGrid, int firstCellNumber, int firstGridNumber) {
        int cellNumber = firstCellNumber;
        int gridNumber = firstGridNumber;
        int maxGridNumber = firstGridNumber + 3;
        int cellsAdded = 0;
        SubGrid grid;
        CellInfo cellInfo;

        while (cellsAdded < (numberOfColumns * columnsPerSubGrid)) {
            grid = getSubgridByNumber(gridNumber);
            for (int i = 0; i < columnsPerSubGrid ; i++) {
                cellInfo = this.cellInfoList.get(cellNumber);
                grid.add(new SudokuCellView(cellInfo,this.validInputs,this.userInputHandler));
                cellsAdded++;
                cellNumber++;
            }
            gridNumber++;
            if (gridNumber == maxGridNumber) {
                gridNumber = firstGridNumber;
            }
        }
    }


    private void createSubGrids() {
        for (int gridNumber = 0; gridNumber < this.subGrids ; gridNumber++) {
            this.add(new SubGrid(this.numberOfColumns));
        }
    }

    private SubGrid getSubgridByNumber(int number) {
        Component panel = this.getComponent(number);
        return ((SubGrid) panel);
    }

    @Override
    public void updateCell(int cellId, int value) {
        SudokuCellView cell = null;
        for (Component subgrid : this.getComponents()) {
            cell = ((SubGrid)subgrid).find(cellId);
            if (cell != null) {
                cell.changeDisplayValue(value);
                break;
            }
        }
    }
}
