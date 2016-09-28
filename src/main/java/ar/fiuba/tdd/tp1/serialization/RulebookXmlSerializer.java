package ar.fiuba.tdd.tp1.serialization;

import ar.fiuba.tdd.tp1.model.*;
import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.Rule;
import ar.fiuba.tdd.tp1.serialization.interfaces.RulebookSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RulebookXmlSerializer implements RulebookSerializer{
    private String gameName;
    private Board board;

    public RulebookXmlSerializer(Board board, String name) {
        this.board = board;
        this.gameName = name;
    }

    public Rulebook deserialize() {
        if (this.gameName.equals("kakuro")) {
            return deserializerKakuro();
        } else if (this.gameName.equals("sudoku")) {
            return deserializeSudoku();
        }
        return null;
    }

    private Rulebook deserializerKakuro() {
        List<Rule> rules = new ArrayList<>();
        for (Map.Entry<String, Region> region : ((BoardRectangularWithRegions)this.board).getRegionsMap().entrySet()) {
            rules.add(new RuleTotalSumEquals(this.board, region.getKey(), Integer.parseInt(region.getValue().getParam())));
        }
        return new Rulebook(rules);
    }

    private Rulebook deserializeSudoku() {
        List<Rule> rules = new ArrayList<>();
        for (Map.Entry<String, Region> region : ((BoardRectangularWithRegions)this.board).getRegionsMap().entrySet()) {
            rules.add(new RuleNoRepeatedValues(this.board, region.getKey()));
        }
        return new Rulebook(rules);
    }
}
