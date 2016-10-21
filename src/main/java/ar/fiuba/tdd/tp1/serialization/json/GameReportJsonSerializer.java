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
        String serializedGameReport;
        Gson gson = new Gson();

        GameReportJson gameReportJson = new GameReportJson();
        gameReportJson.setGameReport(this.gameReport);
        gameReportJson.setBoardReport(this.boardReport);

        serializedGameReport = gson.toJson(gameReportJson);


        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outputFilePath), StandardCharsets.UTF_8);
            writer.write(serializedGameReport);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameReportJson deserialize(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, GameReportJson.class);
    }

}
