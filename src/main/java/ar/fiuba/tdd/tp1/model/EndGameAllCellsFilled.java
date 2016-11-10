package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.EndGameCondition;

public class EndGameAllCellsFilled implements EndGameCondition {

    public Boolean validate(Board board) {
        for (Cell cell : board.getCells()) {
            if (cell.editable && cell.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
