package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

import java.util.ArrayList;
import java.util.List;

public class RuleMustHaveTwoContinuousBlackCells extends Rule implements VisitorOfCell {
    private static final String name = "MustHaveTwoBlackCells";
    private static final String BLACK = "black";

    private String regionId;
    private int blackCells;
    private List<Integer> cellsIdsList;
    private Object visitingCellValue;

    public RuleMustHaveTwoContinuousBlackCells(Board boardValue) {
        super(boardValue);
        this.blackCells = 0;
        this.valid = false;
        this.cellsIdsList = new ArrayList<>();
    }

    //Regular constructor.
    public RuleMustHaveTwoContinuousBlackCells(Board boardValue, String regionIdValue) {
        super(boardValue);
        this.blackCells = 0;
        this.regionId = regionIdValue;
        this.cellsIdsList = board.getCellIdsListFromRegionId(regionId);
        this.valid = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean validate(Move move) {
        if (isDeleteMove(move) || cellsIdsList.indexOf(move.getcellId()) < 0) {
            return false;
        }
        this.blackCells = 0;
        Cell newCell = move.getNewCell();
        List<int[]> blackCellsPositions = new ArrayList<>();
        Integer newCellId = move.getcellId();
        for (Integer cellId : this.cellsIdsList) {
            Cell cell = board.getCellFromCellId(cellId);
            cell.accept(this);
            if (!(cellId.equals(newCellId)) && visitingCellValue != null && visitingCellValue.equals(BLACK)) {
                this.blackCells++;
                blackCellsPositions.add(new int[] { cell.getRow(), cell.getColumn() });
            }
        }
        checkNewCell(newCell, blackCellsPositions);
        finalizeValidate(move, blackCellsPositions);
        return true;
    }

    private void checkNewCell(Cell newCell, List<int[]> blackCellsPositions) {
        if (newCell.getDatum().equals(BLACK)) {
            this.blackCells++;
            Cell currentCell = board.getCellFromCellId(Integer.valueOf(newCell.getName()));
            blackCellsPositions.add(new int[] { currentCell.getRow(), currentCell.getColumn() });
        }
    }

    private void finalizeValidate(Move move, List<int[]> blackCellsPositions) {
        this.valid = true;
        if (this.blackCells > 2) {
            move.addViolationOfRule(new ViolationOfRule("Hay mas de 2 celdas en negro en la region", this.cellsIdsList));
            this.valid = false;
        } else if (this.blackCells == 2 && !checkContinuity(blackCellsPositions)) {
            // TODO: Probablemente deba ser otra regla
            move.addViolationOfRule(new ViolationOfRule("Las celdas negras no son continuas", this.cellsIdsList));
            this.valid = false;
        }
    }

    private Boolean checkContinuity(List<int[]> positions) {
        if (positions.size() == 2) {
            int differenceX = positions.get(0)[0] - positions.get(1)[0];
            int differenceY = positions.get(0)[1] - positions.get(1)[1];
            return (Math.abs(differenceX) <= 1 && differenceY == 0 || Math.abs(differenceY) <= 1 && differenceX == 0);
        }
        return false;
    }

    @Override
    public void visit(CellNumerical cellNumerical) {
        visitingCellValue = null;
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
    public Rule createNewInstance(List<Object> parametersList) {
        return new RuleMustHaveTwoContinuousBlackCells(this.board, (String)parametersList.get(0));
    }
}
