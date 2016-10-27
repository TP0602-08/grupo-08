package ar.fiuba.tdd.tp1.serialization.json;

import ar.fiuba.tdd.tp1.model.BoardReport;
import ar.fiuba.tdd.tp1.model.GameReport;

public class GameReportJson {

    private GameReport gameReport;
    private BoardReport board;

    public GameReportJson() {
        this.gameReport = null;
        this.board = null;
    }

    public void setGameReport(GameReport gameReport) {
        this.gameReport = gameReport;
    }

    public void setBoard(BoardReport board) {
        this.board = board;
    }

    public GameReport getGameReport() {
        return this.gameReport;
    }

    public BoardReport getBoard() {
        return this.board;
    }

}
