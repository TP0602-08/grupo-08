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
    private Board oneBoard;
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
   // public void setUp() throws Exception {
   //     this.oneBoard = new BoardRectangularWithRegions(3,3);
   //     this.cell1 = new CellAlphabetical("3","1");
   //     this.cell2 = new CellAlphabetical("","1");
   // }

    @Test
    public void validateTest() throws Exception {

    }

}