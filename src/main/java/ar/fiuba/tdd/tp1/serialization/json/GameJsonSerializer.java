package ar.fiuba.tdd.tp1.serialization.json;

import com.google.gson.Gson;

import ar.fiuba.tdd.tp1.model.*;
import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.EndGameCondition;
import ar.fiuba.tdd.tp1.serialization.interfaces.GameSerializer;

import java.io.IOException;
import java.util.List;

public class GameJsonSerializer implements GameSerializer {
    private GameJson gameJson;
    private String movesPath;

    public GameJsonSerializer(String path) throws IOException {
        Gson gson = new Gson();
        this.gameJson = gson.fromJson(Json.getJsonString(path), GameJson.class);
    }

    public GameJsonSerializer(String gamePath, String movesPath) throws IOException {
        Gson gson = new Gson();
        this.gameJson = gson.fromJson(Json.getJsonString(gamePath), GameJson.class);
        this.movesPath = movesPath;
    }

    public GameJson getGameJson() {
        return this.gameJson;
    }

    public Game deserialize() {
        Board board = new BoardJsonSerializer(this.gameJson.getBoard()).deserialize();
        Rulebook rulebook = new RulebookJsonSerializer(this.gameJson.getRulebook(), new RulebookCatalog(board)).deserialize();
        EndGameCondition endGameCondition = new EndGameConditionJsonSerializer(this.gameJson.getEndGameCondition()).deserialize();
        if (this.movesPath == null) {
            return new Game(rulebook, board, endGameCondition);
        } else {
            try {
                Game game = new Game(rulebook, board, endGameCondition);
                List<Move> moves = new MovesJsonSerializer(this.movesPath, (BoardRectangularWithRegions) game.getBoard()).deserialize();
                game.setMoves(moves);
                return game;
            } catch (IOException ex) {
                return null;
            }
        }

    }
}
