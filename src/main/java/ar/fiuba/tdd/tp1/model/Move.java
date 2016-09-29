package ar.fiuba.tdd.tp1.model;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private Integer cellId;
    private Cell newCell;
    private List<ViolationOfRule> listOfViolationsOfRules;

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
