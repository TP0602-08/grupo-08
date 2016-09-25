package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Cell;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private Cell cellToBeChanged;
    private List<ViolationOfRule> listOfViolationsOfRules;

    public Move(Cell cellToBeChangedValue) {
        this.listOfViolationsOfRules = new ArrayList<ViolationOfRule>();
        this.cellToBeChanged = cellToBeChangedValue;
    }

    //TODO(Ivan) Este método probablemente hay que volarlo.
    public Cell getCellToBeChanged() {
        return cellToBeChanged;
    }

    //TODO(Ivan) Este método probablemente hay que volarlo.
    public List<ViolationOfRule> getListOfViolationsOfRules() {
        return listOfViolationsOfRules;
    }
}
