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
    private List<Rule> rules;

    public RulebookXmlSerializer(Board board, String name) {
        this.board = board;
        this.gameName = name;
        this.rules = new ArrayList<>();
    }

    public Rulebook deserialize() {
        if (this.gameName.equals("Kakuro")) {
            return deserializerKakuro();
        } else if (this.gameName.equals("Sudoku")) {
            return deserializeSudoku();
        }
        return null;
    }

    private Rulebook deserializerKakuro() {
        for (Map.Entry<String, Region> kakuroRegion : ((BoardRectangularWithRegions)this.board).getRegionsMap().entrySet()) {
            rules.add(new RuleTotalSumEquals(this.board, kakuroRegion.getKey(), Integer.parseInt(kakuroRegion.getValue().getParam())));
        }
        return new Rulebook(rules);
    }

    private Rulebook deserializeSudoku() {
        for (String region : ((BoardRectangularWithRegions)this.board).getRegionsMap().keySet()) {
            rules.add(new RuleNoRepeatedValues(this.board, region));
        }
        return new Rulebook(rules);
    }
}
