package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.EndGameCondition;
import ar.fiuba.tdd.tp1.model.interfaces.EndGameConditionFactory;

import java.util.HashMap;
import java.util.Map;

public class EndGameConditionCatalog {
    private Map<String, EndGameConditionFactory> catalog;

    public EndGameConditionCatalog() {
        this.catalog = new HashMap<>();
        this.catalog.put("EndGameAllCellsFilled", new EndGameConditionFactory() {
            public EndGameCondition createEndGameCondition() {
                return new EndGameAllCellsFilled();
            }
        });
    }

    public EndGameCondition createEndGameCondition(String name) {
        return this.catalog.get(name).createEndGameCondition();
    }
}
