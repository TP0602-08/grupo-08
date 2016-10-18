package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.Cell;

public interface CellBuilder {
    void setValue(Object value);

    void setId(String id);

    void setEditable(Boolean isEditable);

    void setRow(int row);

    void setColumn(int column);

    Cell getCell();
}
