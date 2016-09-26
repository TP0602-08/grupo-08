package ar.fiuba.tdd.tp1.serialization;

import ar.fiuba.tdd.tp1.model.CellAlphabetical;
import ar.fiuba.tdd.tp1.model.CellNumerical;
import ar.fiuba.tdd.tp1.model.interfaces.Cell;
import ar.fiuba.tdd.tp1.serialization.interfaces.CellSerializer;
import ar.fiuba.tdd.tp1.serialization.xml.CellXml;

public class CellXmlSerializer implements CellSerializer {
    private CellXml cellXml;

    public CellXmlSerializer(CellXml cellXml) {
        this.cellXml = cellXml;
    }

    public Cell deserialize() {
        if (this.cellXml.getValue().matches("^-?\\d+$")) {
            return new CellNumerical(Integer.parseInt(this.cellXml.getValue()));
        } else {
            return new CellAlphabetical(this.cellXml.getValue());
        }
    }
}
