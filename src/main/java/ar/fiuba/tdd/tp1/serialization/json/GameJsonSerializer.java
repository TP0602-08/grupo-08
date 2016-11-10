package ar.fiuba.tdd.tp1.serialization.json;

import com.google.gson.Gson;

import ar.fiuba.tdd.tp1.model.*;
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
        List<EndGameCondition> endGameConditions = new EndGameConditionJsonSerializer(this.gameJson.getEndGameConditions()).deserialize();
        List<String> validInputs = this.gameJson.getValidInputs();
        if (this.movesPath == null) {
            Game game = new Game(rulebook,board,endGameConditions);
            game.setValidInputs(validInputs);
            return game;
        } else {
            try {
                Game game = new Game(rulebook, board, endGameConditions);
                List<Move> moves = new MovesJsonSerializer(this.movesPath, (Board) game.getBoard()).deserialize();
                game.setMoves(moves);
                game.setValidInputs(validInputs);
                return game;
            } catch (IOException ex) {
                return null;
            }
        }


    }
}
