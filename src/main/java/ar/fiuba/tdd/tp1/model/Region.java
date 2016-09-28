package ar.fiuba.tdd.tp1.model;

import java.util.List;

public class Region {
    private List<String> cellNamesList;

    public Region(List<String> cellsIdListValue) {
        this.cellNamesList = cellsIdListValue;
    }

    public List<String> getCellNamesList() {
        return cellNamesList;
    }
}
