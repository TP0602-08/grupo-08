package ar.fiuba.tdd.tp1.serialization.json;

import ar.fiuba.tdd.tp1.model.BoardRectangularWithRegions;
import ar.fiuba.tdd.tp1.model.Cell;
import ar.fiuba.tdd.tp1.model.CellAlphabetical;
import ar.fiuba.tdd.tp1.model.CellNumerical;

public final class MoveCellSerializer {
    private MoveCellSerializer() {

    }

    public static Cell deserializeCell(BoardRectangularWithRegions board, MoveJson move) {
        Cell cell = board.getCellByCoordinates(move.getPosition()[0], move.getPosition()[1]);
        if (move.getValue().matches("^-?\\d+$")) {
            ((CellNumerical)cell).setDatum(Integer.parseInt(move.getValue()));
        } else {
            ((CellAlphabetical)cell).setDatum(move.getValue());
        }
        return cell;
    }
}
