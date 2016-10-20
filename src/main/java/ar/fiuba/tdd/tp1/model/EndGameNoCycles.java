package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.EndGameCondition;

/**
 * Created by marcos on 19/10/16.
 */
public class EndGameNoCycles implements EndGameCondition {

    public Boolean validate(BoardRectangularWithRegions board) {
        for (int i = 1;i == board.getRowQuantity() - 1;i ++ ) {
            for (int j = 1;j == board.getColumnQuantity() - 1;j ++ ) {
                Cell firstCell = board.getCellByCoordinates(i,j);
                Cell secondCell = board.getCellByCoordinates(i,j + 1);
                Cell thirdCell = board.getCellByCoordinates(i + 1 ,j + 1);
                Cell fourthCell = board.getCellByCoordinates(i + 1, j);
                if ((this.isCircuite(firstCell,"/")) && (this.isCircuite(secondCell,"\\")) && (this.isCircuite(thirdCell,"/")
                        && (this.isCircuite(fourthCell, "\\")))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCircuite(Cell cell,String line) {
        return cell.getDatum().equals(line);
    }

}
