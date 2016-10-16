package ar.fiuba.tdd.tp1.serialization.json;

import ar.fiuba.tdd.tp1.model.EndGameConditionCatalog;
import ar.fiuba.tdd.tp1.model.interfaces.EndGameCondition;

public class EndGameConditionJsonSerializer {
    private String endGameConditionJson;

    public EndGameConditionJsonSerializer(String endGameCondition) {
        this.endGameConditionJson = endGameCondition;
    }

    public EndGameCondition deserialize() {
        EndGameConditionCatalog catalog = new EndGameConditionCatalog();
        return catalog.createEndGameCondition(this.endGameConditionJson);
    }
}
