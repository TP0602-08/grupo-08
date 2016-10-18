package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

import java.util.ArrayList;
import java.util.List;

/*
* Rule that checks that the sum of the inputs of a specific region matches the required sum total
* */
public class RuleTotalSumEquals extends Rule implements VisitorOfCell {
    private static final String name = "TotalSumEquals";
    private String regionId;
    private int sum;
    private Integer visitingCellValue;
    private int nonEmptyCells;

    //This constructor with is for creating an instance that'll act as a prototype for creating new instances with method
    // "createNewInstance".
    public RuleTotalSumEquals(Board boardValue) {
        super(boardValue);
        this.regionId = null;
        this.sum = 0;
        this.valid = false;
    }

    //Regular constructor.
    public RuleTotalSumEquals(Board boardValue, String regionIdValue, int sumValue) {
        super(boardValue);
        this.regionId = regionIdValue;
        this.sum = sumValue;
        this.valid = false;
    }

    //Constructor with list of Objects as parameters.
    @Deprecated
    public RuleTotalSumEquals(Board boardValue, List<Object> parametersList) {
        super(boardValue);
        this.regionId = (String) parametersList.get(0);
        this.sum = (int) parametersList.get(1);
        this.valid = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean validate(Move move) {
        this.nonEmptyCells = 0;
        List<Integer> cellIdsList = board.getCellIdsListFromRegionId(regionId);
        if (isDeleteMove(move) || cellIdsList.indexOf(move.getcellId()) < 0) {
            return false;
        }
        Integer newCellId = move.getcellId();
        Cell newCell = move.getNewCell();
        visitingCellValue = null;
        Integer accumulator = 0;
        for (Integer cellId : cellIdsList) {
            Cell cell = board.getCellFromCellId(cellId);
            cell.accept(this);
            if ((visitingCellValue != null) && !(cellId.equals(newCellId))) {
                accumulator += visitingCellValue;
                this.nonEmptyCells++;
            }
            visitingCellValue = null;
        }
        accumulator += (int)newCell.getDatum();
        this.nonEmptyCells++;
        finalizeValidate(accumulator, move);
        return true;
    }

    private void finalizeValidate(Integer accumulator, Move move) {
        this.valid = true;
        List<Integer> cellIdsList = board.getCellIdsListFromRegionId(regionId);
        if (this.nonEmptyCells == cellIdsList.size() && accumulator != this.sum) {
            List<Integer> listOfConflictingCellIds = new ArrayList<Integer>(cellIdsList);
            Integer newCellId = move.getcellId();
            listOfConflictingCellIds.remove(newCellId);
            ViolationOfRule violationOfRule = new ViolationOfRule("La suma no es igual a " + sum + ".", listOfConflictingCellIds);
            move.addViolationOfRule(violationOfRule);
            this.valid = false;
        }
    }

    @Override
    public RuleTotalSumEquals createNewInstance(List<Object> parametersList) {
        String newRegionId = (String) parametersList.get(0);
        int newSum = Integer.parseInt(parametersList.get(1).toString());
        RuleTotalSumEquals newInstance = new RuleTotalSumEquals(this.board, newRegionId, newSum);
        return newInstance;
    }

    @Override
    public void visit(CellAlphabetical cell) {
        visitingCellValue = null;
    }

    @Override
    public void visit(CellNumerical cell) {
        if (cell.empty) {
            visitingCellValue = null;
        } else {
            visitingCellValue = cell.getDatum();
        }
    }

    public String getRegionId() {
        return this.regionId;
    }

    public int getSum() {
        return this.sum;
    }
}
