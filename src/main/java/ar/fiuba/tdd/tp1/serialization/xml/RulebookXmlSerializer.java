package ar.fiuba.tdd.tp1.serialization.xml;

import ar.fiuba.tdd.tp1.model.*;
import ar.fiuba.tdd.tp1.model.Rule;
import ar.fiuba.tdd.tp1.model.interfaces.Board;
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
        if (this.gameName.equals("Kakuro") || this.gameName.equals("Inshinoheya")) {
            return deserializerKakuroOrInshi(this.gameName);
        } else if (this.gameName.equals("Sudoku")) {
            return deserializeSudoku();
        }
        return null;
    }

    private Rulebook deserializerKakuroOrInshi(String gameName) {
        Map<String, Region> regions = ((BoardRectangularWithRegions)this.board).getRegionsMap();
        for (Map.Entry<String, Region> region : regions.entrySet()) {
            if (gameName.equals("Inshinoheya")) {
                if (region.getValue().getParam() != null) {
                    rules.add(new RuleTotalProductEquals(this.board, region.getKey(), Integer.parseInt(region.getValue().getParam())));
                }
            } else {
                rules.add(new RuleTotalSumEquals(this.board, region.getKey(), Integer.parseInt(region.getValue().getParam())));
            }
            rules.add(new RuleNoRepeatedValues(this.board, region.getKey()));
        }
        return new Rulebook(rules);
    }

    private Rulebook deserializerKakuro() {
        for (Map.Entry<String, Region> kakuroRegion : ((BoardRectangularWithRegions)this.board).getRegionsMap().entrySet()) {
            rules.add(new RuleTotalSumEquals(this.board, kakuroRegion.getKey(), Integer.parseInt(kakuroRegion.getValue().getParam())));
            rules.add(new RuleNoRepeatedValues(this.board, kakuroRegion.getKey()));
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
