package ar.fiuba.tdd.tp1.model;
/* This class gives us the value of the position of a cell in the form board (x, y)
   The get (x) method gives us the x position of the coordinate
   The get (y) method gives us the position and the coordinate
   The getValue method returns the value of the cell
   The compare method is used to compare two values of type BoardValue
*/
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
