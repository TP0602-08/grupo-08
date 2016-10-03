package ar.fiuba.tdd.tp1.serialization.xml;

import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.model.Rulebook;
import ar.fiuba.tdd.tp1.model.interfaces.Board;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class GameXmlSerializer {
    private String path;
    private Game deserializedGame;
    private Unmarshaller unmarshaller;

    public GameXmlSerializer(String xmlPath) {
        this.path = xmlPath;
    }

    public Game deserialize() throws JAXBException {
        if (deserializedGame == null) {
            File xml = new File(this.path);
            setUnmarshaller();
            mapGameXmlToGame((GameXml) unmarshaller.unmarshal(xml));
        }
        return this.deserializedGame;
    }

    private void setUnmarshaller() throws JAXBException {
        JAXBContext jaxb = JAXBContext.newInstance(GameXml.class);
        unmarshaller = jaxb.createUnmarshaller();
    }

    private void mapGameXmlToGame(GameXml gameXml) {
        Board board = new BoardXmlSerializer(gameXml.getBoard()).deserialize();
        Rulebook rulebook = new RulebookXmlSerializer(board, gameXml.getName()).deserialize();
        this.deserializedGame = new Game(rulebook, board);
    }
}
