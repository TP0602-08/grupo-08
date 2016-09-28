package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardRectangularWithRegions implements Board {
    private int rowQuantity;
    private int columnQuantity;
    private Map<Integer, Cell> cellsMap; //The Integer that identifies each cell is the number of cell in the board, starting from one,
    // counting left to right and downwards.
    private Map<String, Integer> cellNamesMap; //The String that identifies each cell in the board can be anything.
    // counting left to right and up to down.
    private Map<String, Region> regionsMap; //The String that identifies each region can be anything.

    public BoardRectangularWithRegions(int rowQuantityValue, int columnQuantityValue) {
        this.rowQuantity = rowQuantityValue;
        this.columnQuantity = rowQuantityValue;
        this.cellsMap = new HashMap<Integer, Cell>(rowQuantityValue * rowQuantityValue);
        this.cellNamesMap = new HashMap<String, Integer>(rowQuantityValue * rowQuantityValue);
        this.regionsMap = new HashMap<String, Region>();
    }

    @Override
    public void apply(Move move) {
        //TODO(Ivan)
    }

    public int getRowQuantity() {
        return rowQuantity;
    }

    public int getColumnQuantity() {
        return columnQuantity;
    }

    private Integer computeCellId(int row, int column) {
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
}
