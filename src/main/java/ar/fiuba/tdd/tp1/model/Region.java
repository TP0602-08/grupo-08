package ar.fiuba.tdd.tp1.model;

import java.util.List;

public class Region {
    private List<String> cellsIdList;

    public Region(List<String> cellsIdListValue) {
        this.cellsIdList = cellsIdListValue;
    }

    public List<String> getCellsIdList() {
        return cellsIdList;
    }
}
