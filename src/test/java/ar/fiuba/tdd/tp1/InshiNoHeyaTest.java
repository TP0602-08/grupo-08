package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.serialization.json.GameJsonSerializer;
import org.junit.Before;

import java.io.IOException;

public class InshiNoHeyaTest {
    private static final String INSHINOHEYAJSON = "src/main/resources/inshinoheya.json";
    private static Game game;

    @Before
    public void setUp() throws IOException {
        game = new GameJsonSerializer(INSHINOHEYAJSON).deserialize();
    }
}
