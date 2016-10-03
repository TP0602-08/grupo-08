package ar.fiuba.tdd.tp1.serialization.xml;

import ar.fiuba.tdd.tp1.model.BoardRectangularWithRegions;
import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.model.Move;
import ar.fiuba.tdd.tp1.serialization.interfaces.GameSerializer;
import ar.fiuba.tdd.tp1.serialization.json.MovesJsonSerializer;

import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBException;

public class GameMixedSerializer implements GameSerializer {
    private GameXmlSerializer gameXmlSerializer;
    private String movesPath;

    public GameMixedSerializer(String gamePath, String movesPath) {
        this.gameXmlSerializer = new GameXmlSerializer(gamePath);
        this.movesPath = movesPath;
    }

    public Game deserialize() {
        try {
            Game game = this.gameXmlSerializer.deserialize();
            List<Move> moves = new MovesJsonSerializer(this.movesPath, (BoardRectangularWithRegions)game.getBoard()).deserialize();
            game.setMoves(moves);
            return game;
        } catch (JAXBException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
}
