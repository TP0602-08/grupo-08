package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Rule;

import java.util.List;

public class Rulebook {
    private List<Rule> rulesList;

    public Rulebook(List<Rule> rulesListValue) {
        this.rulesList = rulesListValue;
    }

    public void validate(Move move) {
        for (Rule rule : rulesList) {
            rule.validate(move);
        }
    }
}
