package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.BoardRectangularWithRegions;
/*This interface represents the end of game conditions. The Validate method when returning a value
True, will validate the game end condition.
* */
public interface EndGameCondition {
    Boolean validate(BoardRectangularWithRegions board);
}
