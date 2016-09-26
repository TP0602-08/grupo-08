package ar.fiuba.tdd.tp1.serialization;

import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.model.RuleTotalSumEquals;
import ar.fiuba.tdd.tp1.model.Rulebook;
import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.Rule;
import ar.fiuba.tdd.tp1.serialization.xml.GameXml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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

    // TODO: deserializar Rulebook
    private void mapGameXmlToGame(GameXml gameXml) {
        Board board = new BoardXmlSerializer(gameXml.getBoard()).deserialize();
        this.deserializedGame = new Game(mockUpDeserializeRulebook(board), board);
    }

    // TODO: deserializar Rulebook
    private Rulebook mockUpDeserializeRulebook(Board board) {
        List<Rule> rules = new ArrayList<>();
        rules.add(new RuleTotalSumEquals(board));
        return new Rulebook(rules);
    }
}
