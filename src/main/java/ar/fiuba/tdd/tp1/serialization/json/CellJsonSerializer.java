package ar.fiuba.tdd.tp1.serialization.json;

import ar.fiuba.tdd.tp1.model.*;
import ar.fiuba.tdd.tp1.model.interfaces.CellBuilder;
import ar.fiuba.tdd.tp1.serialization.interfaces.CellSerializer;

public class CellJsonSerializer implements CellSerializer {
    private CellJson cellJson;
    private CellBuilder cellBuilder;

    public CellJsonSerializer(CellJson cellJson) {
        this.cellJson = cellJson;
    }

    public Cell deserialize() {
        if (this.cellJson.isNumeric()) {
            this.cellBuilder = new CellNumericalBuilder();
        } else {
            this.cellBuilder = new CellAlphabeticalBuilder();
        }
        buildCell();
        return this.cellBuilder.getCell();
    }

    private void buildCell() {
        this.cellBuilder.setValue(this.cellJson.getValue());
        this.cellBuilder.setId(this.cellJson.getId());
        this.cellBuilder.setEditable(this.cellJson.isEditable());
        this.cellBuilder.setRow(this.cellJson.getRow());
        this.cellBuilder.setColumn(this.cellJson.getColumn());
    }
}
