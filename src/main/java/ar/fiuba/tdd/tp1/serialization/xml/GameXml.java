package ar.fiuba.tdd.tp1.serialization.xml;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "game")
public class GameXml {
    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "rulebook", type = RulebookXml.class)
    private RulebookXml rulebook;

    @XmlElement(name = "board", type = BoardXml.class)
    private BoardXml board;

    public String getName() {
        return this.name;
    }

    public RulebookXml getRulebook() {
        return this.rulebook;
    }

    public BoardXml getBoard() {
        return this.board;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRulebook(RulebookXml rulebook) {
        this.rulebook = rulebook;
    }

    public void setBoard(BoardXml board) {
        this.board = board;
    }
}
