package ar.fiuba.tdd.tp1.model;

public class CellInfo {

    private int id;
    private String value;
    private boolean editable;

    CellInfo(int id, String value, boolean editable) {
        this.id = id;
        this.value = value;
        this.editable = editable;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public boolean isEditable() {
        return editable;
    }
}
