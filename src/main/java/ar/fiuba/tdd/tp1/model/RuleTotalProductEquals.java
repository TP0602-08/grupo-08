package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

import java.util.ArrayList;
import java.util.List;

public class RuleTotalProductEquals extends Rule implements VisitorOfCell {
    private Integer visitingCellValue;
    private int product;
    private String name;
    private int filledCells;
    private String regionId;

    public RuleTotalProductEquals(Board board, String regionIdValue, int product) {
        super(board);
        this.regionId = regionIdValue;
        this.name = "TotalProductEquals";
        this.product = product;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean validate(Move move) {
        this.filledCells = 0;
        List<Integer> cellIds = this.board.getCellIdsListFromRegionId(regionId);
        if (isDeleteMove(move) || cellIds.indexOf(move.getcellId()) < 0) {
            return false;
        }
        Integer newId = move.getcellId();
        Cell newCell = move.getNewCell();
        int accumulator = 0;
        for (Integer cellId : cellIds) {
            Cell cell = board.getCellFromCellId(cellId);
            cell.accept(this);
            if ((visitingCellValue != null) && !(cellId.equals(newId))) {
                accumulator *= visitingCellValue;
                this.filledCells++;
            }
            visitingCellValue = null;
        }
        finalizeValidate(accumulator, (int)newCell.getDatum(), move);
        return true;
    }

    private void finalizeValidate(Integer accumulator, int newValue, Move move) {
        accumulator *= newValue;
        this.filledCells++;
        List<Integer> cellIds = board.getCellIdsListFromRegionId(regionId);
        if (this.filledCells == cellIds.size() && accumulator != this.product) {
            List<Integer> conflictingCellIds = new ArrayList<Integer>(cellIds);
            conflictingCellIds.remove(move.getcellId());
            move.addViolationOfRule(new ViolationOfRule("El producto no es igual a " + product + ".", conflictingCellIds));
        }
    }

    @Override
    public Rule createNewInstance(List<Object> parametersList) {
        return new RuleTotalProductEquals(this.board, (String)parametersList.get(0), (int)parametersList.get(1));
    }

    @Override
    public void visit(CellAlphabetical cellAlphabetical) {
        visitingCellValue = null;
    }

    @Override
    public void visit(CellNumerical cellNumerical) {
        if (cellNumerical.isEmpty()) {
            visitingCellValue = null;
        } else {
            visitingCellValue = cellNumerical.getDatum();
        }
    }

    public String getRegionId() {
        return this.regionId;
    }

    public int getProduct() {
        return this.product;
    }

    private boolean isDeleteMove(Move move) {
        return move.getNewCell().isEmpty();
    }
}
