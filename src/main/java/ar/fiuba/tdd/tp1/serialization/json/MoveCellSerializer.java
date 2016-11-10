package ar.fiuba.tdd.tp1.serialization.json;

import ar.fiuba.tdd.tp1.model.Board;
import ar.fiuba.tdd.tp1.model.Cell;
import ar.fiuba.tdd.tp1.model.CellAlphabetical;
import ar.fiuba.tdd.tp1.model.CellNumerical;

public final class MoveCellSerializer {
    private MoveCellSerializer() {

    }

    public static Cell deserializeCell(Board board, MoveJson move) {
        Cell cell = board.getCellByCoordinates(move.getPosition()[0] - 1, move.getPosition()[1] - 1);
        if (move.getValue().matches("^-?\\d+$")) {
            return new CellNumerical(Integer.parseInt(move.getValue()), cell.getName());
        } else {
            return new CellAlphabetical(move.getValue(), cell.getName());
        }
    }
}
