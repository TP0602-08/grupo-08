package ar.fiuba.tdd.tp1.serialization.json;

public abstract class BoardConfigurable {
    protected int rows;
    protected int columns;

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }
}
