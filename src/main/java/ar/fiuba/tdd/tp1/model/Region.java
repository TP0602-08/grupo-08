package ar.fiuba.tdd.tp1.model;

import java.util.List;

public class Region {
    private String param;

    private List<String> cellNamesList;

    public Region(List<String> cellsIdListValue) {
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
