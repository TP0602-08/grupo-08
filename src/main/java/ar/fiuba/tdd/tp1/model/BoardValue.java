package ar.fiuba.tdd.tp1.model;

public class BoardValue {

    private int[] position;
    private String value;

    public BoardValue(int cellId, int numberOfColumns, String value) {
        int row = 1;
        while (cellId > numberOfColumns) {
            cellId = cellId - numberOfColumns;
            row++;
        }
        this.position = new int[2];
        this.position[0] = row;
        this.position[1] = cellId;
        this.value = value;
    }

    public int getX() {
        return this.position[0];
    }

    public int getY() {
        return this.position[1];
    }

    public String getValue() {
        return this.value;
    }

    public boolean compareValue(BoardValue valueToCompare) {
        return ((this.getX() == valueToCompare.getX()) && (this.getY() == valueToCompare.getY()));
    }
}
