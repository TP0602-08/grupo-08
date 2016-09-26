package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.serialization.GameXmlSerializer;
import ar.fiuba.tdd.tp1.serialization.xml.GameXml;
import ar.fiuba.tdd.tp1.serialization.xml.RulebookXml;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GameXmlSerializationTest {
    private static final String GAMEXML = "src/test/resources/XmlGameTest.xml";
    private static final String NAME = "Test";
    private static final int RULEBOOKSIZE = 2;
    private static final int REGIONSSIZE = 1;
    private static final int CELLSSIZE = 16;

    private static Unmarshaller unmarshaller;
    private static File xml;

    @BeforeClass
    public static void setUpBeforeClass() {
        xml = new File(GAMEXML);
        try {
            JAXBContext jaxb = JAXBContext.newInstance(GameXml.class);
            unmarshaller = jaxb.createUnmarshaller();
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void canReadFile() {
        assertTrue(xml.exists());
    }

    @Test
    public void canReadUnmarshallGame() {
        try {
            GameXml game = (GameXml)unmarshaller.unmarshal(xml);
            assertTrue(true);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readName() {
        try {
            GameXml game = (GameXml)unmarshaller.unmarshal(xml);
            assertEquals(game.getName(), NAME);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readRulebook() {
        try {
            GameXml game = (GameXml)unmarshaller.unmarshal(xml);
            assertEquals(game.getRulebook().getRules().size(), RULEBOOKSIZE);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readBoardRegions() {
        try {
            GameXml game = (GameXml)unmarshaller.unmarshal(xml);
            assertEquals(game.getBoard().getRegions().size(), REGIONSSIZE);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readBoardCells() {
        try {
            GameXml game = (GameXml)unmarshaller.unmarshal(xml);
            assertEquals(game.getBoard().getCells().size(), CELLSSIZE);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void mockedUpDeserializedGameShouldntThrowException() {
        try {
            Game deserializedGame = new GameXmlSerializer(GAMEXML).deserialize();
            assertTrue(true);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}
