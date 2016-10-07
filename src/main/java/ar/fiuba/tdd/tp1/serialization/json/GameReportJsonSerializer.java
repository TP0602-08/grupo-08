package ar.fiuba.tdd.tp1.serialization.json;


import com.google.gson.Gson;

import ar.fiuba.tdd.tp1.model.BoardReport;
import ar.fiuba.tdd.tp1.model.GameReport;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;


public class GameReportJsonSerializer {
    private GameReport gameReport;
    private BoardReport boardReport;

    public GameReportJsonSerializer(GameReport gameReport, BoardReport boardReport) {
        this.gameReport = gameReport;
        this.boardReport = boardReport;
    }

    public GameReport getGameReport() {
        return this.gameReport;
    }

    public BoardReport getBoardReport() {
        return this.boardReport;
    }

    public void serialize(String outputFilePath) {
        String gameReportJson;
        Gson gson = new Gson();
        gameReportJson = gson.toJson(this);


        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outputFilePath), StandardCharsets.UTF_8);
            writer.write(gameReportJson);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
