package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Move;
import ar.fiuba.tdd.tp1.model.interfaces.Rule;

import java.util.List;

public class Rulebook {
    private List<Rule> rulesList;

    public Rulebook(List<Rule> rulesListValue) {
        //TODO(Ivan) Ver si está bien "pasarle" los objetos así, o si necesita hacer copias de las listas, mapas y sus elementos.
        this.rulesList = rulesListValue;
    }

    public boolean isAValidMove(Move move) {
        //TODO(Ivan)
        return false;
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
