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
    private Map<String, Cell> cellsMap; //The String that identifies each cell is the number of cell in the board, starting from one,
    // counting left to right and up to down.
    private Map<String, Region> regionsMap; //The String that identifies each region can be anything.

    public BoardRectangularWithRegions(int rowQuantityValue, int columnQuantityValue) {
        this.rowQuantity = rowQuantityValue;
        this.columnQuantity = rowQuantityValue;

        this.cellsMap = new HashMap<String, Cell>(rowQuantityValue * rowQuantityValue);
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

    //TODO(Ivan) Este método probablemente hay que volarlo.
    public Map<String, Cell> getCellsMap() {
        return cellsMap;
    }

    //TODO(Ivan) Este método probablemente hay que volarlo.
    public Map<String, Region> getRegionsMap() {
        return regionsMap;
    }

    private String computeCellId(int xxCoordinate, int yyCoordinate) {
        int position = 1 + (yyCoordinate) * columnQuantity + xxCoordinate;
        String cellId = Integer.toString(position);
        return cellId;
    }

    public Cell getCell(String cellId) {
        return cellsMap.get(cellId);
    }


    public Cell getCell(int xxCoordinate, int yyCoordinate) {
        String cellId = computeCellId(xxCoordinate, yyCoordinate);
        return cellsMap.get(cellId);
    }

    public void setCell(String cellId, Cell cellValue) {
        cellsMap.put(cellId, cellValue);
    }

    public void setCell(int xxCoordinate, int yyCoordinate, Cell cellValue) {
        String cellId = computeCellId(xxCoordinate, yyCoordinate);
        cellsMap.put(cellId, cellValue);
    }

    public boolean cellIsSet(int xxCoordinate, int yyCoordinate) {
        String cellId = computeCellId(xxCoordinate, yyCoordinate);
        return cellsMap.containsKey(cellId);
    }

    public boolean cellIsSet(String cellId) {
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

    public List<Cell> getCellsListFromRegion(String regionId) {
        List<Cell> cellsList = new ArrayList<Cell>();
        for (String cellIdIterator : regionsMap.get(regionId).getCellsIdList()) {
            cellsList.add(this.cellsMap.get(cellIdIterator));
        }
        return cellsList;
    }
}
