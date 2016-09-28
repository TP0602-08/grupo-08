package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Rule;

import java.util.List;

public class Rulebook {
    private List<Rule> rulesList;

    public Rulebook(List<Rule> rulesListValue) {
        this.rulesList = rulesListValue;
    }

    public boolean isAValidMove(Move move) {
        return getViolations(move).isEmpty();
    }

    public List<ViolationOfRule> getViolations(Move move) {
        //TODO(Ivan)
        return null;
    }

    //TODO(Ivan) Este método tal vez hay que volarlo.
    public List<Rule> getRulesList() {
        return rulesList;
    }
}
