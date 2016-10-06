package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.model.MoveHistory;
import ar.fiuba.tdd.tp1.serialization.xml.GameMixedSerializer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ActividadEntregaUnoTest { private static final String GAMEXML = "src/main/resources/inshinoheya.xml";
    private static final String MOVESJSON = "src/main/resources/plays.json";
    private static Game game;

    @Before
    public void setUp() {
        game = new GameMixedSerializer(GAMEXML, MOVESJSON).deserialize();
        assertNotEquals(game, null);
    }

    @Test
    public void processDeserializedMovesSameNumberThanTrackedMoves() {
        game.process();
        assertEquals(game.getMoveHistory().size(), game.getMoves().size());
    }

    @Test
    public void deserializedMovesHaveCorrectValidation() {
        game = new GameMixedSerializer(GAMEXML, MOVESJSON).deserialize();
        game.process();
        List<MoveHistory> moveHistory = game.getMoveHistory();
        assertTrue(moveHistory.get(0).wasValid());
        assertTrue(moveHistory.get(1).wasValid());
        assertTrue(moveHistory.get(2).wasValid());
        assertFalse(moveHistory.get(3).wasValid());
    }
}
