package ar.fiuba.tdd.tp1.model;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private Integer cellId; //The Id that the board uses to identify the cell.
    private Cell newCell; //A new cell of the correct type, created with the datum from the user input.
    private List<ViolationOfRule> listOfViolationsOfRules; //A list of the rule violations that this cell causes (it is populated by the
    // rules when the game validates the move.

    public Move(Integer cellIdValue, Cell newCellValue) {
        this.cellId = cellIdValue;
        this.newCell = newCellValue;
        this.listOfViolationsOfRules = new ArrayList<ViolationOfRule>();
    }

    public Integer getcellId() {
        return this.cellId;
    }

    public Cell getNewCell() {
        return newCell;
    }

    public List<ViolationOfRule> getListOfViolationsOfRules() {
        return listOfViolationsOfRules;
    }

    public boolean isValid() {
        return listOfViolationsOfRules.isEmpty();
    }

    public void addViolationOfRule(ViolationOfRule violationOfRule) {
        listOfViolationsOfRules.add(violationOfRule);
    }
}
