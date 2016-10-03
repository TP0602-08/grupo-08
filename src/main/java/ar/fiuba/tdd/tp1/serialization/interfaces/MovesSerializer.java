package ar.fiuba.tdd.tp1.serialization.interfaces;

import ar.fiuba.tdd.tp1.model.Move;

import java.util.List;

public interface MovesSerializer {
    List<Move> deserialize();
}
