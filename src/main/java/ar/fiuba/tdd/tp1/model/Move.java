package ar.fiuba.tdd.tp1.model;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private int row;
    private int column;
    private Cell newCell;
    private List<ViolationOfRule> listOfViolationsOfRules;

    public Move(Cell newCellValue) {
        this.listOfViolationsOfRules = new ArrayList<ViolationOfRule>();
        this.newCell = newCellValue;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Cell getNewCell() {
        return newCell;
    }

    public List<ViolationOfRule> getListOfViolationsOfRules() {
        return listOfViolationsOfRules;
    }
}
