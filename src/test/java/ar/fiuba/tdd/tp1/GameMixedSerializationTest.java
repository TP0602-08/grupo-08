package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.serialization.xml.GameMixedSerializer;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class GameMixedSerializationTest {
    private static final String GAMEXML = "src/main/resources/inshinoheya.xml";
    private static final String MOVESJSON = "src/main/resources/plays.json";

    @Test
    public void deserializeGameFromDifferentConfigurationFiles() {
        Game game = new GameMixedSerializer(GAMEXML, MOVESJSON).deserialize();
        assertNotEquals(game, null);
    }
}
