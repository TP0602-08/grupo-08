package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

import java.util.ArrayList;
import java.util.List;

public class RuleNoRepeatedValues extends Rule implements VisitorOfCell {
    private static final String name = "NoRepeatedValues";
    private String regionId;
    private Object visitingCellValue;

    //This constructor with is for creating an instance that'll act as a prototype for creating new instances with method
    // "createNewInstance".
    public RuleNoRepeatedValues(Board boardValue) {
        super(boardValue);
        this.regionId = null;
        visitingCellValue = null;
        this.valid = false;
    }

    //Regular constructor.
    public RuleNoRepeatedValues(Board boardValue, String regionIdValue) {
        super(boardValue);
        this.regionId = regionIdValue;
        visitingCellValue = null;
        this.valid = false;
    }

    //Constructor with list of Objects as parameters.
    @Deprecated
    public RuleNoRepeatedValues(Board boardValue, List<Object> parametersList) {
        super(boardValue);
        this.regionId = (String) parametersList.get(0);
        visitingCellValue = null;
        this.valid = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean validate(Move move) {
        Integer newCellId = move.getcellId();
        Cell newCell = move.getNewCell();
        List<Integer> cellIdsList = board.getCellIdsListFromRegionId(regionId);
        List<Integer> listOfConflictingCellIds = new ArrayList<Integer>();
        if (isDeleteMove(move) || cellIdsList.indexOf(move.getcellId()) < 0) {
            finalizeValidate(listOfConflictingCellIds, move);
            return false;
        }
        visitingCellValue = null;
        for (Integer cellId : cellIdsList) {
            Cell cell = board.getCellFromCellId(cellId);
            cell.accept(this);
            if ((visitingCellValue != null) && !(cellId.equals(newCellId)) && visitingCellValue.equals(newCell.getDatum())) {
                listOfConflictingCellIds.add(cellId);
            }
            visitingCellValue = null;
        }
        finalizeValidate(listOfConflictingCellIds, move);
        return true;
    }

    private void finalizeValidate(List<Integer> listOfConflictingCellIds, Move move) {
        if (!listOfConflictingCellIds.isEmpty()) {
            ViolationOfRule violationOfRule = new ViolationOfRule("Valor repetido.", listOfConflictingCellIds);
            move.addViolationOfRule(violationOfRule);
            this.valid = false;
        } else {
            this.valid = true;
        }
    }

    private boolean isDeleteMove(Move move) {
        return move.getNewCell().isEmpty();
    }


    @Override
    public RuleNoRepeatedValues createNewInstance(List<Object> parametersList) {
        String newRegionId = (String) parametersList.get(0);
        RuleNoRepeatedValues newInstance = new RuleNoRepeatedValues(this.board, newRegionId);
        return newInstance;
    }

    @Override
    public void visit(CellAlphabetical cell) {
        if (cell.isEmpty()) {
            visitingCellValue = null;
        } else {
            visitingCellValue = cell.getDatum();
        }
    }

    @Override
    public void visit(CellNumerical cell) {
        if (cell.isEmpty()) {
            visitingCellValue = null;
        } else {
            visitingCellValue = cell.getDatum();
        }
    }

    public Object getVisitingCellValue() {
        return this.visitingCellValue;
    }

    public String getRegionId() {
        return this.regionId;
    }
}
