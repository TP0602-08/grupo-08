package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

import java.util.*;

public class RuleMustTouchCornerXTimes extends Rule implements VisitorOfCell {
    private static final String name = "NoRepeatedValues";
    private String regionId;
    private Object visitingCellValue;
    private List<Integer> cellsIdsList;
    private Map<Integer, String> howCellsTouchCorner;
    private int timesTouched;
    private int nonEmptyCells;

    public RuleMustTouchCornerXTimes(Board boardValue) {
        super(boardValue);
        this.valid = false;
        this.cellsIdsList = new ArrayList<>();
        this.howCellsTouchCorner = new HashMap<>();
    }

    public RuleMustTouchCornerXTimes(Board boardValue, String regionIdValue, int timesTouched) {
        super(boardValue);
        this.regionId = regionIdValue;
        this.cellsIdsList = board.getCellIdsListFromRegionId(regionId);
        this.howCellsTouchCorner = new HashMap<>();
        buildHowCellsTouchCorner();
        this.timesTouched = timesTouched;
        this.valid = false;
    }

    private void buildHowCellsTouchCorner() {
        // There are only three posibilities as far as the number of cells in this kind of regions is concerned. Either there are 2
        // (in which case, the corner is located in one of the board's borders), or there are 4 (in which case, the corner
        // is internal), or there is only one (the corner is in one of the board's corners)
        Collections.sort(this.cellsIdsList);
        if (this.cellsIdsList.size() == 4) {
            // If there are four, it's simple: the two lowest cell ids belong to the upper-left cell (lowest id) and the upper-right
            // cell (second-lowest id), whereas the other two belong to the bottom row cells (second highest to the lower-left cell
            // and highest id to the lower-right cell).
            // For the upper-left and lower-right cells, the cell value will be touching the corner if it's "\". For the upper-right
            // and lower-left corners, it will be touching it if the value is "/".
            // I store the values that each cell must have to count as touching in this map, according to its id
            this.howCellsTouchCorner.put(this.cellsIdsList.get(0), "\\");
            this.howCellsTouchCorner.put(this.cellsIdsList.get(1), "/");
            this.howCellsTouchCorner.put(this.cellsIdsList.get(2), "/");
            this.howCellsTouchCorner.put(this.cellsIdsList.get(3), "\\");
        } else if (this.cellsIdsList.size() == 2) {
            // If there are two, however, it's more complicated. The "region" can either include 2 "upper" cells (that is, the corner
            // is in the bottom border of the board), 2 "lower" cells (the corner is in the top border), 2 "left" cells (right border)
            // or 2 "right" cells (left border).
            buildHowTwoCellsTouchCorner();
        } else {
            // Here, we only need to know what corner the cell represents
            Cell corner = board.getCellFromCellId(this.cellsIdsList.get(0));
            Boolean isBottomRight = corner.getRow() == board.getRowQuantity() - 1 && corner.getColumn() == board.getColumnQuantity() - 1;
            Boolean isTopLeft = corner.getRow() == 0 && corner.getColumn() == 0;
            if (isTopLeft || isBottomRight) {
                this.howCellsTouchCorner.put(this.cellsIdsList.get(0), "\\");
            } else {
                this.howCellsTouchCorner.put(this.cellsIdsList.get(0), "/");
            }
        }
    }

    private void buildHowTwoCellsTouchCorner() {
        // Given these 4 posibilities, here's how one can find out in which case the region is in:
        // - If both columns are equal to 0, then the corner is in the left border. The upper cell will touch the corner with a "/"
        //   and the lower cell will touch it with a "\"
        // - If both columns are equal to to the board's column quantity, then the corner is in the right border. The upper cell will touch
        //   the corner with a "\" and the lower cell will touch it with a "/"
        // - If both rows are equal to to the board's row quantity, then the corner is in the top border. The left cell will touch
        //   the corner with a "/" and the right cell will touch it with a "\"
        // - If both rows are equal to to the board's row quantity, then the corner is in the bottom border. The left cell will touch
        //   the corner with a "\" and the right cell will touch it with a "/"
        Cell first = board.getCellFromCellId(this.cellsIdsList.get(0));
        Cell second = board.getCellFromCellId(this.cellsIdsList.get(1));
        Boolean isLeftBorder = first.getColumn() == 0 && second.getColumn() == 0;
        Boolean isTopBorder = first.getRow() == 0 && second.getRow() == 0;
        if (isLeftBorder || isTopBorder) {
            this.howCellsTouchCorner.put(this.cellsIdsList.get(0), "/");
            this.howCellsTouchCorner.put(this.cellsIdsList.get(1), "\\");
        } else {
            this.howCellsTouchCorner.put(this.cellsIdsList.get(0), "\\");
            this.howCellsTouchCorner.put(this.cellsIdsList.get(1), "/");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean validate(Move move) {
        Integer newCellId = move.getcellId();
        if (isDeleteMove(move) || this.cellsIdsList.indexOf(move.getcellId()) < 0) {
            return false;
        }
        this.nonEmptyCells = 0;
        Integer accumulatorTimesTouched = 0;
        Cell newCell = move.getNewCell();
        for (Integer cellId : this.cellsIdsList) {
            Cell cell = board.getCellFromCellId(cellId);
            cell.accept(this);
            if ((visitingCellValue != null) && !(cellId.equals(newCellId))) {
                accumulatorTimesTouched += isCornerTouchedByCell(cell);
                this.nonEmptyCells++;
            }
            visitingCellValue = null;
        }
        accumulatorTimesTouched += isCornerTouchedByCell(newCell);
        this.nonEmptyCells++;
        finalizeValidate(accumulatorTimesTouched, move);
        return true;
    }

    private void finalizeValidate(Integer accumulatedTouches, Move move) {
        this.valid = true;
        if (this.nonEmptyCells == this.cellsIdsList.size() && accumulatedTouches != this.timesTouched) {
            move.addViolationOfRule(new ViolationOfRule("La esquina no es tocada " + this.timesTouched + " veces.", this.cellsIdsList));
            this.valid = false;
        } else {
            if (this.timesTouched == 0 && accumulatedTouches != 0) {
                move.addViolationOfRule(new ViolationOfRule("La esquina no es tocada " + this.timesTouched + " veces.", this.cellsIdsList));
                this.valid = false;
            }
        }


    }

    private int isCornerTouchedByCell(Cell cell) {
        String stringValue = cell.getDatum().toString();
        if (this.howCellsTouchCorner.get(Integer.valueOf(cell.getName())).equals(stringValue)) {
            return 1;
        }
        return 0;
    }

    @Override
    public Rule createNewInstance(List<Object> parametersList) {
        String regionId = (String) parametersList.get(0);
        int timesTouched = Integer.parseInt(parametersList.get(1).toString());
        return new RuleMustTouchCornerXTimes(this.board, regionId, timesTouched);
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
        visitingCellValue = null;
    }
}
