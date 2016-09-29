package ar.fiuba.tdd.tp1.serialization;

import ar.fiuba.tdd.tp1.model.BoardRectangularWithRegions;
import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.serialization.interfaces.BoardSerializer;
import ar.fiuba.tdd.tp1.serialization.xml.BoardXml;
import ar.fiuba.tdd.tp1.serialization.xml.CellXml;
import ar.fiuba.tdd.tp1.serialization.xml.RegionXml;

public class BoardXmlSerializer implements BoardSerializer {
    private BoardXml boardXml;

    public BoardXmlSerializer(BoardXml boardXml) {
        this.boardXml = boardXml;
    }

    public BoardRectangularWithRegions deserialize() {
        BoardRectangularWithRegions board = new BoardRectangularWithRegions(boardXml.getRows(), boardXml.getColumns());
        deserializeRegions(board);
        deserializeCells(board);
        board.finalizeBoardLoadUp();
        return board;
    }

    private void deserializeCells(BoardRectangularWithRegions board) {
        for (CellXml cellXml : this.boardXml.getCells()) {
            board.setCellByCoordinates(cellXml.getRow(), cellXml.getColumn(), new CellXmlSerializer(cellXml).deserialize());
        }
    }

    private void deserializeRegions(BoardRectangularWithRegions board) {
        for (RegionXml region : this.boardXml.getRegions()) {
            board.setRegion(region.getId(), new RegionXmlSerializer(region).deserialize());
        }
    }
}
