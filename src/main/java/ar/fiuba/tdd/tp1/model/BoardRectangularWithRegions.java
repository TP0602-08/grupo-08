package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.Cell;
import ar.fiuba.tdd.tp1.model.interfaces.Move;
import ar.fiuba.tdd.tp1.model.interfaces.Region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardRectangularWithRegions implements Board {
    private int rowQuantity;
    private int columnQuantity;
    private List<Cell> cellsList;
    private Map<String, Region> regionMap;

    public BoardRectangularWithRegions(int rowQuantityValue, int columnQuantityValue) {
        this.rowQuantity = rowQuantityValue;
        this.columnQuantity = rowQuantityValue;

        this.cellsList = new ArrayList<Cell>(rowQuantityValue * rowQuantityValue);
        this.regionMap = new HashMap<String, Region>();
    }

    public int getRowQuantity() {
        return rowQuantity;
    }

    public int getColumnQuantity() {
        return columnQuantity;
    }

    //TODO(Ivan) Este método probablemente hay que volarlo.
    public List<Cell> getCellsList() {
        return cellsList;
    }

    //TODO(Ivan) Este método probablemente hay que volarlo.
    public Map<String, Region> getRegionMap() {
        return regionMap;
    }

    @Override
    public void apply(Move move) {
        //TODO(Ivan)
    }
}
