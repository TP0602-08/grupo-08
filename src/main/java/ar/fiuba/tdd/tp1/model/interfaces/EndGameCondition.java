package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.Board;
//This interface defines the conditiones required for the game to be considered won.
//Method "validate" returns true when the game is considered won.

public interface EndGameCondition {
    Boolean validate(Board board);
}
