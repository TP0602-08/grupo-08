package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

import java.util.ArrayList;
import java.util.List;

public class RuleBlackCellsMustTouchOtherRegions extends Rule implements VisitorOfCell {
    private static final String name = "RuleBlackCellsMustTouchOtherRegions";
    private static final String BLACK = "black";

    private String regionId;
    private List<Integer> cellsIdsList;
    private Object visitingCellValue;

    public RuleBlackCellsMustTouchOtherRegions(Board boardValue) {
        super(boardValue);
        this.valid = false;
        this.cellsIdsList = new ArrayList<>();
    }

    public RuleBlackCellsMustTouchOtherRegions(Board boardValue, String regionId) {
        super(boardValue);
        this.regionId = regionId;
        this.cellsIdsList = board.getCellIdsListFromRegionId(this.regionId);
        this.valid = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void visit(CellAlphabetical cellAlphabetical) {
        if (cellAlphabetical.isEmpty()) {
            visitingCellValue = null;
        } else {
            visitingCellValue = cellAlphabetical.getDatum();
        }
    }

    @Override
    public void visit(CellNumerical cellNumerical) {
        visitingCellValue = null;
    }

    @Override
    public boolean validate(Move move) {
        Cell newCell = move.getNewCell();
        Boolean blackCellsInvalid = false;
        if (isDeleteMove(move) || cellsIdsList.indexOf(move.getcellId()) < 0) {
            return false;
        }
        for (Integer cellId : this.cellsIdsList) {
            Cell cell = board.getCellFromCellId(cellId);
            cell.accept(this);
            if ((visitingCellValue != null) && !(cellId.equals(move.getcellId())) && newCell.getDatum().equals(BLACK)) {
                blackCellsInvalid = blackCellsInvalid || doesBlackCellTouchOtherRegionsBlackCells(
                        board.getCellFromCellId(
                                move.getcellId()
                        )
                );
            }
        }
        finalizeValidate(move, blackCellsInvalid);
        return true;
    }

    private void finalizeValidate(Move move, Boolean invalidRegion) {
        this.valid = true;
        if (invalidRegion) {
            move.addViolationOfRule(new ViolationOfRule("Las celdas negras de la region estan continuas a celdas negras de otra region",
                    this.cellsIdsList));
            this.valid = false;
        }
    }

    private Boolean doesBlackCellTouchOtherRegionsBlackCells(Cell newCell) {
        int[] differentials = new int[] {-1, 1};
        for (int differential : differentials) {
            CellAlphabetical neighborCell = (CellAlphabetical) ((BoardRectangularWithRegions)board).getCellByCoordinates(
                    newCell.getRow() + differential, newCell.getColumn());

            if (neighborCell != null && neighborCell.getDatum().equals(BLACK)
                    && !cellsIdsList.contains(Integer.valueOf(neighborCell.getName()))) {
                return true;
            }

            neighborCell = (CellAlphabetical) ((BoardRectangularWithRegions)board).getCellByCoordinates(
                    newCell.getRow(), newCell.getColumn() + differential);

            if (neighborCell != null && neighborCell.getDatum().equals(BLACK)
                    && !cellsIdsList.contains(Integer.valueOf(neighborCell.getName()))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Rule createNewInstance(List<Object> parametersList) {
        return new RuleBlackCellsMustTouchOtherRegions(this.board, parametersList.get(0).toString());
    }
}
