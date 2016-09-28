package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.Move;
import ar.fiuba.tdd.tp1.model.Region;

public interface Board {
    void apply(Move move);
    Region getRegion(String regionId);
}
