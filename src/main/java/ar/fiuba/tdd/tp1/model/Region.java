package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Cell;

import java.util.List;

public class Region {
    private String id;
    private List<Cell> cellsList;

    public Region(String idValue, List<Cell> cellsListValue) {
        this.id = idValue;
        this.cellsList = cellsListValue;
    }

    public String getId() {
        return this.id;
    }

    public List<Cell> getCellsList() {
        return cellsList;
    }
}
