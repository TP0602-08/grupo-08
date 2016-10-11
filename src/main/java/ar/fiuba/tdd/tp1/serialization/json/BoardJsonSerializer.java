package ar.fiuba.tdd.tp1.serialization.json;

import ar.fiuba.tdd.tp1.model.BoardRectangularWithRegions;
import ar.fiuba.tdd.tp1.model.Cell;
import ar.fiuba.tdd.tp1.model.Region;
import ar.fiuba.tdd.tp1.serialization.interfaces.BoardSerializer;

public class BoardJsonSerializer implements BoardSerializer {
    private BoardJson boardJson;

    public BoardJsonSerializer(BoardJson boardJson) {
        this.boardJson = boardJson;
    }

    private void deserializeCells(BoardRectangularWithRegions board) {
        for (CellJson cell : this.boardJson.getCells()) {
            Cell deserializedCell = new CellJsonSerializer(cell).deserialize();
            board.setCellByCoordinates(cell.getRow(), cell.getColumn(), deserializedCell);
        }
    }

    private void deserializerRegions(BoardRectangularWithRegions board) {
        for (RegionJson region : this.boardJson.getRegions()) {
            Region deserializedRegion = new RegionJsonSerializer(region).deserialize();
            board.setRegion(region.getId(), deserializedRegion);
        }
    }

    public BoardRectangularWithRegions deserialize() {
        BoardRectangularWithRegions board = new BoardRectangularWithRegions(this.boardJson.getRows(), this.boardJson.getColumns());
        deserializeCells(board);
        deserializerRegions(board);
        board.finalizeBoardLoadUp();
        return board;
    }
}
