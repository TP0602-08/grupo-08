package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.BoardRectangularWithRegions;

public interface EndGameCondition {
    Boolean validate(BoardRectangularWithRegions board);
}
