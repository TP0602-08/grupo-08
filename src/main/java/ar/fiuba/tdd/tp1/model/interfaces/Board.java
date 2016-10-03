package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.Cell;
import ar.fiuba.tdd.tp1.model.Move;
import ar.fiuba.tdd.tp1.model.Region;

import java.util.List;

public interface Board {
    void apply(Move move);

    Region getRegion(String regionId);

    List<Integer> getCellIdsListFromRegionId(String regionId);

    Cell getCellFromCellId(Integer cellId);

    int getRowQuantity();

    int getColumnQuantity();
}
