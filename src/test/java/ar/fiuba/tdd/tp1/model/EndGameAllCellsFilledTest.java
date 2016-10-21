package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *This class is a unit test of EndGameAllCellsFilled class to verify the condition to play full board.
 In validateTEST we will simulate a board with all its occupied cells, which should return the value of "true".
 Then we will test other test with free lockers which should return the false value.
*/
public class EndGameAllCellsFilledTest {
    private BoardRectangularWithRegions oneBoard;
    private EndGameAllCellsFilled endGameCondition;
    private CellAlphabetical cell1;
    private CellAlphabetical cell2;
    private CellAlphabetical cell3;
    private CellAlphabetical cell4;
    private CellAlphabetical cell5;
    private CellAlphabetical cell6;
    private CellAlphabetical cell7;
    private CellAlphabetical cell8;
    private CellAlphabetical cell9;

    @Before
   public void setUp() throws Exception {
        int dimRowS = 3;
        int dimCols = 3;
        this.oneBoard = new BoardRectangularWithRegions(dimCols,dimRowS);
                                   //ID                          //dATA  //NAME //isEDITABLE
        this.oneBoard. setCellById(new Integer(1), new CellAlphabetical("1","1",true));
        this.oneBoard. setCellById(new Integer(2), new CellAlphabetical("2","8",true));
        this.oneBoard. setCellById(new Integer(3), new CellAlphabetical("3","16",true));
        this.oneBoard. setCellById(new Integer(4), new CellAlphabetical("4","15",true));
        this.oneBoard. setCellById(new Integer(5), new CellAlphabetical("5","12",true));
        this.oneBoard. setCellById(new Integer(6), new CellAlphabetical("6","11",true));
        this.oneBoard. setCellById(new Integer(7), new CellAlphabetical("7","6",true));
        this.oneBoard. setCellById(new Integer(8), new CellAlphabetical("8","5",true));
        this.oneBoard. setCellById(new Integer(9), new CellAlphabetical("9","3",true));
        this.endGameCondition = new EndGameAllCellsFilled();
    }

    @Test
    public void validateFullBoardTest() throws Exception {
        assertEquals(true,this.endGameCondition.validate(this.oneBoard));

    }

    @Test
    public void validateNoFullBoardTest() throws Exception {
        this.oneBoard. setCellById(new Integer(9), new CellAlphabetical(null,"3",true));
        assertEquals(false,this.endGameCondition.validate(this.oneBoard));

    }

}