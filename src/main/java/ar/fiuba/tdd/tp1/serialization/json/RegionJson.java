package ar.fiuba.tdd.tp1.serialization.json;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RegionJson {
    private String id;
    private int[] cells;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getCells() {
        return Arrays.stream(cells).boxed().collect(Collectors.toList());
    }

    public void setCells(List<Integer> cells) {
        this.cells = cells.stream().mapToInt(i -> i).toArray();
    }
}
