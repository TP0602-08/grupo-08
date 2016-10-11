package ar.fiuba.tdd.tp1.serialization.json;

/*
* Class used to represent a Cell as it comes from the configuration file
* */
public class CellJson {
    private String value;
    private String id;
    private Boolean editable;
    private int[] position = new int[] {-1, -1};

    public String getValue() {
        return this.value;
    }

    public String getId() {
        return this.id;
    }

    public int getRow() {
        return this.position[0];
    }

    public int getColumn() {
        return this.position[1];
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isEditable() {
        return this.editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean isNumeric() {
        return this.value.matches("[0-9]+");
    }
}
