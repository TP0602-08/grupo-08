package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.EndGameCondition;
import ar.fiuba.tdd.tp1.model.interfaces.EndGameConditionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        this.catalog.put("EndGameNoCycles", new EndGameConditionFactory() {
            public EndGameCondition createEndGameCondition() {
                return new EndGameNoCycles();
            }
        });
        this.catalog.put("EndGameAllRegionsFilled", new EndGameConditionFactory() {
            public EndGameCondition createEndGameCondition() {
                return new EndGameAllRegionsFilled();
            }
        });
    }

    public EndGameCondition createEndGameCondition(String name) {
        return this.catalog.get(name).createEndGameCondition();
    }

    public List<EndGameCondition> createEndGameConditions(List<String> names) {
        List<EndGameCondition> endGameConditions = new ArrayList<>();
        for (String name : names) {
            endGameConditions.add(this.catalog.get(name).createEndGameCondition());
        }
        return endGameConditions;
    }
}
