package ar.fiuba.tdd.tp1.serialization.json;

import com.google.gson.Gson;

import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.model.Rulebook;
import ar.fiuba.tdd.tp1.model.RulebookCatalog;
import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.EndGameCondition;
import ar.fiuba.tdd.tp1.serialization.interfaces.GameSerializer;

import java.io.IOException;

public class GameJsonSerializer implements GameSerializer {
    private GameJson gameJson;

    public GameJsonSerializer(String path) throws IOException {
        Gson gson = new Gson();
        this.gameJson = gson.fromJson(Json.getJsonString(path), GameJson.class);
    }

    public GameJson getGameJson() {
        return this.gameJson;
    }

    public Game deserialize() {
        Board board = new BoardJsonSerializer(this.gameJson.getBoard()).deserialize();
        Rulebook rulebook = new RulebookJsonSerializer(this.gameJson.getRulebook(), new RulebookCatalog(board)).deserialize();
        EndGameCondition endGameCondition = new EndGameConditionJsonSerializer(this.gameJson.getEndGameCondition()).deserialize();
        return new Game(rulebook, board, endGameCondition);
    }
}
