package ar.fiuba.tdd.tp1.serialization.json;

import ar.fiuba.tdd.tp1.model.Cell;
import ar.fiuba.tdd.tp1.model.CellAlphabetical;
import ar.fiuba.tdd.tp1.model.CellNumerical;
import ar.fiuba.tdd.tp1.serialization.interfaces.CellSerializer;

public class CellJsonSerializer implements CellSerializer {
    private CellJson cellJson;

    public CellJsonSerializer(CellJson cellJson) {
        this.cellJson = cellJson;
    }

    public Cell deserialize() {
        if (this.cellJson.isNumeric()) {
            return new CellNumerical(Integer.valueOf(this.cellJson.getValue()), this.cellJson.getId());
        } else {
            return new CellAlphabetical(this.cellJson.getValue(), this.cellJson.getId());
        }
    }
}
