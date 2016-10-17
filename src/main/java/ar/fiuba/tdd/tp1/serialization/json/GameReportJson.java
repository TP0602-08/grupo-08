package ar.fiuba.tdd.tp1.serialization.json;

import ar.fiuba.tdd.tp1.model.BoardReport;
import ar.fiuba.tdd.tp1.model.GameReport;
import ar.fiuba.tdd.tp1.model.interfaces.Board;

public class GameReportJson {

    private GameReport gameReport;
    private BoardReport boardReport;

    public GameReportJson() {
        this.gameReport = null;
        this.boardReport = null;
    }

    public void setGameReport(GameReport gameReport) {
        this.gameReport = gameReport;
    }

    public void setBoardReport(BoardReport boardReport) {
        this.boardReport = boardReport;
    }

    public GameReport getGameReport() {
        return this.gameReport;
    }

    public BoardReport getBoardReport() {
        return this.boardReport;
    }

}
