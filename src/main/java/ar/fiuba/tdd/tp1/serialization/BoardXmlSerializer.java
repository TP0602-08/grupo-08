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
        return board;
    }

    private void deserializeCells(BoardRectangularWithRegions board) {
        for (CellXml cellXml : this.boardXml.getCells()) {
            board.setCell(cellXml.getId(), new CellXmlSerializer(cellXml).deserialize());
        }
    }

    private void deserializeRegions(BoardRectangularWithRegions board) {
        for (RegionXml region : this.boardXml.getRegions()) {
            board.setRegion("", new RegionXmlSerializer(region).deserialize());
        }
    }
}
