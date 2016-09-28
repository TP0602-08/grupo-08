package ar.fiuba.tdd.tp1.serialization;

import ar.fiuba.tdd.tp1.model.CellAlphabetical;
import ar.fiuba.tdd.tp1.model.CellNumerical;
import ar.fiuba.tdd.tp1.model.interfaces.Cell;
import ar.fiuba.tdd.tp1.serialization.interfaces.CellSerializer;
import ar.fiuba.tdd.tp1.serialization.xml.CellAlphabeticalXml;
import ar.fiuba.tdd.tp1.serialization.xml.CellNumericalXml;
import ar.fiuba.tdd.tp1.serialization.xml.CellXml;

public class CellXmlSerializer implements CellSerializer {
    private CellXml cellXml;

    public CellXmlSerializer(CellXml cellXml) {
        this.cellXml = cellXml;
    }

    public Cell deserialize() {
        if (this.cellXml.getClass() == CellNumericalXml.class) {
            return new CellNumerical(((CellNumericalXml)this.cellXml).getValue(), ((CellNumericalXml)this.cellXml).getId());
        } else {
            return new CellAlphabetical(((CellAlphabeticalXml)this.cellXml).getValue(), ((CellAlphabeticalXml)this.cellXml).getId());
        }
    }
}
