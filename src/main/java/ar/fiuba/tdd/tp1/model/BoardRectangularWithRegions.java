package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.Cell;
import ar.fiuba.tdd.tp1.model.interfaces.Move;
import ar.fiuba.tdd.tp1.model.interfaces.Region;

import java.util.List;
import java.util.Map;

public class BoardRectangularWithRegions implements Board {
    private int rowQuantity;
    private int columnQuantity;
    private List<Cell> cellsList;
    private Map<String, Region> regionMap;

    public BoardRectangularWithRegions(int rowQuantityValue, int columnQuantityValue, List<Cell> cellsListValue, Map<String, Region>
            regionMapValue) {
        this.rowQuantity = rowQuantityValue;
        this.columnQuantity = rowQuantityValue;
        //TODO(Ivan) Ver si está bien "pasarle" los objetos así, o si necesita hacer copias de las listas, mapas y sus elementos.
        this.cellsList = cellsListValue;
        this.regionMap = regionMapValue;
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
