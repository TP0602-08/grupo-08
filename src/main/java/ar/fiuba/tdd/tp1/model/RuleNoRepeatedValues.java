package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Rule;

public class RuleNoRepeatedValues implements Rule {
    private static final String name = "NoRepeatedValues";

    @Override
    public boolean isValid(Move move) {
        //TODO(Ivan)
        return false;
    }

    public String getName() {
        return this.name;
    }
}
