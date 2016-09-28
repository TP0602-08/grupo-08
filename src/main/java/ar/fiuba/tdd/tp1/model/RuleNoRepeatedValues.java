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
    }

    //Regular constructor.
    public RuleNoRepeatedValues(Board boardValue, String regionIdValue) {
        super(boardValue);
        this.regionId = regionIdValue;
        visitingCellValue = null;
    }

    //Constructor with list of Objects as parameters.
    @Deprecated
    public RuleNoRepeatedValues(Board boardValue, List<Object> parametersList) {
        super(boardValue);
        this.regionId = (String) parametersList.get(0);
        visitingCellValue = null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void validate(Move move) {
        /*if (move.getNewCell().getDatum() == null) {
            return;
        }*/
        Integer newCellId = move.getcellId();
        Cell newCell = move.getNewCell();
        List<Integer> cellIdsList = board.getCellIdsListFromRegionId(regionId);
        visitingCellValue = null;
        List<Integer> listOfConflictingCellIds = new ArrayList<Integer>();
        for (Integer cellId : cellIdsList) {
            Cell cell = board.getCellFromCellId(cellId);
            cell.accept(this);
            if ((visitingCellValue != null) && !(cellId.equals(newCellId)) && visitingCellValue.equals(newCell.getDatum())) {
                listOfConflictingCellIds.add(cellId);
            }
            visitingCellValue = null;
        }
        if (listOfConflictingCellIds.isEmpty() == false) {
            ViolationOfRule violationOfRule = new ViolationOfRule("Valor repetido.", listOfConflictingCellIds);
            move.addViolationOfRule(violationOfRule);
        }
    }

    @Override
    public RuleNoRepeatedValues createNewInstance(List<Object> parametersList) {
        String newRegionId = (String) parametersList.get(0);
        RuleNoRepeatedValues newInstance = new RuleNoRepeatedValues(this.board, newRegionId);
        return newInstance;
    }

    @Override
    public void visit(CellAlphabetical cell) {
        //Todo(Ivan) If cell has value copy the value, otherwise put null;
        visitingCellValue = cell.getDatum();
    }

    @Override
    public void visit(CellNumerical cell) {
        //Todo(Ivan) If cell has value copy the value, otherwise put null;
        visitingCellValue = cell.getDatum();
    }

    //TODO(Ivan) Este método tal vez hay que volarlo.
    public String getRegionId() {
        return this.regionId;
    }
}
