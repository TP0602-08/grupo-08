package ar.fiuba.tdd.tp1;

import com.google.gson.Gson;

import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.model.GameReport;
import ar.fiuba.tdd.tp1.model.MoveHistory;
import ar.fiuba.tdd.tp1.serialization.json.GameReportJsonSerializer;
import ar.fiuba.tdd.tp1.serialization.xml.GameMixedSerializer;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static ar.fiuba.tdd.tp1.MoveJsonSerializationTest.readFile;
import static org.junit.Assert.*;

public class ActividadEntregaUnoTest { private static final String GAMEXML = "src/main/resources/inshinoheya.xml";
    private static final String MOVESJSON = "src/main/resources/plays.json";
    private static final String JSONOUTPUT = "src/main/resources/gameOutput.json";
    private static Game game;
    private static GameReportJsonSerializer gameReportJsonSerializer;

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

    @Test
    public void serializedGameValidation() throws IOException {
        game = new GameMixedSerializer(GAMEXML, MOVESJSON).deserialize();
        game.process();
        List<MoveHistory> moveHistory = game.getMoveHistory();
        gameReportJsonSerializer = new GameReportJsonSerializer(new GameReport(moveHistory), game.getBoardReport());
        gameReportJsonSerializer.serialize(JSONOUTPUT);
        String report =  readFile(JSONOUTPUT, StandardCharsets.UTF_8);
        Gson otro = new Gson();
        GameReport testReport = otro.fromJson(report, GameReport.class);
        assertNotNull(testReport);
    }
}
