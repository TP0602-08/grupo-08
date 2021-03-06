package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.CellBuilder;

public class CellAlphabeticalBuilder implements CellBuilder {
    private CellAlphabetical cell;

    public CellAlphabeticalBuilder() {
        this.cell = new CellAlphabetical();
    }

    @Override
    public void setValue(Object value) {
        this.cell.setDatum(value.toString());
    }

    @Override
    public void setId(String id) {
        this.cell.setName(id);
    }

    @Override
    public void setEditable(Boolean isEditable) {
        this.cell.editable = isEditable;
    }

    @Override
    public void setRow(int row) {
        this.cell.setRow(row);
    }

    @Override
    public void setColumn(int column) {
        this.cell.setColumn(column);
    }

    @Override
    public Cell getCell() {
        return this.cell;
    }
}
