package ar.fiuba.tdd.tp1.model;

import java.util.List;
//Represents a group of cells in the board which can have any shape.
//Rules are applies on the corresponding cells by means of a reference to a region.
//Each regions has an id to identify it. This id is a string.

public class Region {
    private String param;

    private List<String> cellNamesList;

    public Region(List<String> cellsIdListValue) {
        this.cellNamesList = cellsIdListValue;
    }

    public Region(List<String> cellsIdListValue, String param) {
        this.param = param;
        this.cellNamesList = cellsIdListValue;
    }

    public List<String> getCellNamesList() {
        return cellNamesList;
    }

    public String getParam() {
        return this.param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
