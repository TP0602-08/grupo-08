package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.CellBuilder;

public class CellNumericalBuilder implements CellBuilder {
    private CellNumerical cell;

    public CellNumericalBuilder() {
        this.cell = new CellNumerical();
    }

    @Override
    public Cell getCell() {
        return this.cell;
    }

    @Override
    public void setEditable(Boolean isEditable) {
        this.cell.editable = isEditable;
    }

    @Override
    public void setId(String id) {
        this.cell.setName(id);
    }

    @Override
    public void setColumn(int column) {
        this.cell.setColumn(column);
    }

    @Override
    public void setValue(Object value) {
        this.cell.setDatum(Integer.valueOf(value.toString()));
    }

    @Override
    public void setRow(int row) {
        this.cell.setRow(row);
    }

}
