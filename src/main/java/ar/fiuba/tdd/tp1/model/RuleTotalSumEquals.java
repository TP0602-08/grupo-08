package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

import java.util.ArrayList;
import java.util.List;

public class RuleTotalSumEquals extends Rule implements VisitorOfCell {
    private static final String name = "TotalSumEquals";
    private String regionId;
    private int sum;
    private Integer visitingCellValue;

    //This constructor with is for creating an instance that'll act as a prototype for creating new instances with method
    // "createNewInstance".
    public RuleTotalSumEquals(Board boardValue) {
        super(boardValue);
        this.regionId = null;
        this.sum = 0;
    }

    //Regular constructor.
    public RuleTotalSumEquals(Board boardValue, String regionIdValue, int sumValue) {
        super(boardValue);
        this.regionId = regionIdValue;
        this.sum = sumValue;
    }

    //Constructor with list of Objects as parameters.
    @Deprecated
    public RuleTotalSumEquals(Board boardValue, List<Object> parametersList) {
        super(boardValue);
        this.regionId = (String) parametersList.get(0);
        this.sum = (int) parametersList.get(1);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void validate(Move move) {
        if (isDeleteMove(move)) {
            return;
        }
        Integer newCellId = move.getcellId();
        List<Integer> cellIdsList = board.getCellIdsListFromRegionId(regionId);
        visitingCellValue = null;
        Integer accumulator = 0;
        for (Integer cellId : cellIdsList) {
            Cell cell = board.getCellFromCellId(cellId);
            cell.accept(this);
            if ((visitingCellValue != null) && !(cellId.equals(newCellId))) {
                accumulator += visitingCellValue;
            }
            visitingCellValue = null;
        }
        finalizeValidate(accumulator, move);
    }

    private void finalizeValidate(Integer accumulator, Move move) {
        if (accumulator > this.sum) {
            List<Integer> cellIdsList = board.getCellIdsListFromRegionId(regionId);
            List<Integer> listOfConflictingCellIds = new ArrayList<Integer>(cellIdsList);
            Integer newCellId = move.getcellId();
            listOfConflictingCellIds.remove(newCellId);
            ViolationOfRule violationOfRule = new ViolationOfRule("La suma excede el valor " + sum + ".", listOfConflictingCellIds);
            move.addViolationOfRule(violationOfRule);
        }
    }

    @Override
    public RuleTotalSumEquals createNewInstance(List<Object> parametersList) {
        String newRegionId = (String) parametersList.get(0);
        int newSum = (int) parametersList.get(1);
        RuleTotalSumEquals newInstance = new RuleTotalSumEquals(this.board, newRegionId, newSum);
        return newInstance;
    }

    private boolean isDeleteMove(Move move) {
        return move.getNewCell().empty;
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
