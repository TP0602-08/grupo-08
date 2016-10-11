package ar.fiuba.tdd.tp1.serialization.json;

import java.util.List;

public class BoardJson extends BoardConfigurable {
    private List<CellJson> cells;
    private List<RegionJson> regions;

    public List<CellJson> getCells() {
        return this.cells;
    }

    public List<RegionJson> getRegions() {
        return this.regions;
    }

    public void setCells(List<CellJson> cells) {
        this.cells = cells;
    }

    public void setRegions(List<RegionJson> regions) {
        this.regions = regions;
    }
}
