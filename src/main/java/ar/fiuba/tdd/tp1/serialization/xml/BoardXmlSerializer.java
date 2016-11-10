package ar.fiuba.tdd.tp1.serialization.xml;

import ar.fiuba.tdd.tp1.model.Board;
import ar.fiuba.tdd.tp1.serialization.interfaces.BoardSerializer;

public class BoardXmlSerializer implements BoardSerializer {
    private BoardXml boardXml;

    public BoardXmlSerializer(BoardXml boardXml) {
        this.boardXml = boardXml;
    }

    public Board deserialize() {
        Board board = new Board(boardXml.getRows(), boardXml.getColumns());
        deserializeRegions(board);
        deserializeCells(board);
        board.finalizeBoardLoadUp();
        return board;
    }

    private void deserializeCells(Board board) {
        for (CellXml cellXml : this.boardXml.getCells()) {
            board.setCellByCoordinates(cellXml.getRow(), cellXml.getColumn(), new CellXmlSerializer(cellXml).deserialize());
        }
    }

    private void deserializeRegions(Board board) {
        for (RegionXml region : this.boardXml.getRegions()) {
            board.setRegion(region.getId(), new RegionXmlSerializer(region).deserialize());
        }
    }
}
