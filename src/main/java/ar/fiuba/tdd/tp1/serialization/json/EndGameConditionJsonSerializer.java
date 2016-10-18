package ar.fiuba.tdd.tp1.serialization.json;

import ar.fiuba.tdd.tp1.model.EndGameConditionCatalog;
import ar.fiuba.tdd.tp1.model.interfaces.EndGameCondition;

import java.util.List;

public class EndGameConditionJsonSerializer {
    private List<String> endGameConditionJson;

    public EndGameConditionJsonSerializer(List<String> endGameCondition) {
        this.endGameConditionJson = endGameCondition;
    }

    public List<EndGameCondition> deserialize() {
        EndGameConditionCatalog catalog = new EndGameConditionCatalog();
        return catalog.createEndGameConditions(this.endGameConditionJson);
    }
}
