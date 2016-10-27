package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class BoardRectangularWithRegions implements Board {
    private int rowQuantity;
    private int columnQuantity;
    private Map<Integer, Cell> cellsMap; //The Integer that identifies each cell is the number of cell in the board, starting from one,
    // counting left to right and downwards.
    private Map<String, Integer> cellNamesMap; //The String that identifies each cell in the board can be anything. It's purpose is to
    // facilitate the manual input on the game XML file.
    private Map<String, Region> regionsMap; //The String that identifies each region can be anything. It's purpose is to facilitate the
    // manual input on the game XML file.

    public BoardRectangularWithRegions(int rowQuantityValue, int columnQuantityValue) {
        this.rowQuantity = rowQuantityValue;
        this.columnQuantity = columnQuantityValue;
        this.cellsMap = new HashMap<Integer, Cell>(rowQuantityValue * rowQuantityValue);
        this.cellNamesMap = new HashMap<String, Integer>(rowQuantityValue * rowQuantityValue);
        this.regionsMap = new HashMap<String, Region>();
    }

    //Effectively changes the contents of the cell, the move at this points is certain to be valid.
    @Override
    public void apply(Move move) {
        Integer cellId = move.getcellId();
        Cell oldCell = cellsMap.get(cellId);
        Cell newCell = move.getNewCell();
        newCell.setName(oldCell.getName());
        cellsMap.put(cellId, newCell);
    }

    @Override
    public List<Integer> getCellIdsListFromRegionId(String regionId) {
        Region region = regionsMap.get(regionId);
        List<Integer> listOfCellIds = region.getCellNamesList().stream().map(Integer::parseInt).collect(Collectors.toList());
        return listOfCellIds;
    }

    @Override
    public Cell getCellFromCellId(Integer cellId) {
        return cellsMap.get(cellId);
    }

    public List<Cell> getCellsListFromRegionId(String regionId) {
        List<Integer> listOfCellIds = getCellIdsListFromRegionId(regionId);
        List<Cell> listOfCells = new ArrayList<Cell>();
        for (Integer cellId : listOfCellIds) {
            listOfCells.add(cellsMap.get(cellId));
        }
        return listOfCells;
    }

    public int getRowQuantity() {
        return rowQuantity;
    }

    public int getColumnQuantity() {
        return columnQuantity;
    }

    //Translates row and column coordinates into the cellId used by te cellsMap.
    public Integer computeCellId(int row, int column) {
        int position = 1 + (row * columnQuantity) + column;
        return position;
    }

    public Cell getCellByCoordinates(int row, int column) {
        Integer cellId = computeCellId(row, column);
        return cellsMap.get(cellId);
    }

    public Cell getCellById(Integer cellId) {
        Cell cell = cellsMap.get(cellId);
        return cell;
    }

    public Cell getCellByName(String cellName) {
        Integer cellId = cellNamesMap.get(cellName);
        Cell cell = cellsMap.get(cellId);
        return cell;
    }

    public void setCellByCoordinates(int row, int column, Cell cellValue) {
        Integer cellId = computeCellId(row, column);
        cellsMap.put(cellId, cellValue);
        cellNamesMap.put(cellValue.getName(), cellId);
    }

    public void setCellById(Integer cellId, Cell cellValue) {
        cellsMap.put(cellId, cellValue);
        cellNamesMap.put(cellValue.getName(), cellId);
    }

    public void setCellByName(Cell cellValue) {
        String cellsName = cellValue.getName();
        Integer cellId = cellNamesMap.get(cellsName);
        cellsMap.put(cellId, cellValue);
        cellNamesMap.put(cellsName, cellId);
    }

    public boolean cellIsSetByCoordinates(int row, int column) {
        Integer cellId = computeCellId(row, column);
        return cellsMap.containsKey(cellId);
    }

    public boolean cellIsSetById(Integer cellId) {
        return cellsMap.containsKey(cellId);
    }

    public boolean cellIsSetByName(String cellName) {
        Integer cellId = cellNamesMap.get(cellName);
        return cellsMap.containsKey(cellId);
    }

    public boolean regionIsDefined(String regionId) {
        return regionsMap.containsKey(regionId);
    }

    public void setRegion(String regionId, Region regionValue) {
        regionsMap.put(regionId, regionValue);
    }

    public Region getRegion(String regionId) {
        return regionsMap.get(regionId);
    }

    public Map<String, Region> getRegionsMap() {
        return regionsMap;
    }

    public List<Cell> getCellsListFromRegion(String regionId) {
        List<Cell> cellsList = new ArrayList<Cell>();
        Region region = regionsMap.get(regionId);
        for (String cellNameIterator : region.getCellNamesList()) {
            cellsList.add(cellsMap.get(this.cellNamesMap.get(cellNameIterator)));
        }
        return cellsList;
    }

    public int getNumberOfRegions() {
        return regionsMap.size();
    }

    public int getNumberOfCells() {
        return cellsMap.size();
    }

    public Map<Integer,String> getBoardValues() {
        Map<Integer,String> mapValues = new HashMap<>();

        for (Integer key: cellsMap.keySet()) {
            if ( ! cellsMap.get(key).getDatum().equals(0)) {
                mapValues.put(key, cellsMap.get(key).datumToString());
            }
        }
        return mapValues;
    }

    public List<Cell> getCells() {
        return cellsMap.values().stream().collect(Collectors.toList());
    }

    //Completes the board with all non editable cells (which don't appear in the XML file) and sets the state of the cells which start
    // with an empty value.
    public void finalizeBoardLoadUp() {
        changeZeroCellsToEmpty();
        addNonPlayableCells();
    }

    //Cells that start with an empty value are set to "empty".
    private void changeZeroCellsToEmpty() {
        for (int iterator = 1; iterator <= (rowQuantity * columnQuantity); ++iterator) {
            if (cellsMap.containsKey(iterator)) {
                cellsMap.get(iterator).empty = true;
            }
        }
    }

    //Cells that aren't editable are added to the cellsMap.
    private void addNonPlayableCells() {
        for (int iterator = 1; iterator <= (rowQuantity * columnQuantity); ++iterator) {
            if (!cellsMap.containsKey(iterator)) {
                CellNumerical cell = new CellNumerical(0, "NONPLAYABLE" + iterator);
                cell.editable = false;
                cellsMap.put(iterator, cell);
            }
        }
    }
}
