package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marcos on 20/10/16.
 */
public class EndGameNoCyclesTest {
    private BoardRectangularWithRegions oneBoard;
    private EndGameNoCycles endGameCondition;

    @Before
    public void setUp() throws Exception {
        int dimRowS = 3;
        int dimCols = 3;
        this.oneBoard = new BoardRectangularWithRegions(dimCols,dimRowS);
                                  //ID                          //dATA  //NAME //isEDITABLE
        this.oneBoard. setCellById(new Integer(5), new CellAlphabetical("/","1",true));
        this.oneBoard. setCellById(new Integer(6), new CellAlphabetical("\\","8",true));
        this.oneBoard. setCellById(new Integer(7), new CellAlphabetical("/","16",true));
        this.oneBoard. setCellById(new Integer(8), new CellAlphabetical("\\","15",true));
        this.oneBoard. setCellById(new Integer(9), new CellAlphabetical("/","12",true));
        this.oneBoard. setCellById(new Integer(10), new CellAlphabetical("/","11",true));
        this.oneBoard. setCellById(new Integer(11), new CellAlphabetical("\\","6",true));
        this.oneBoard. setCellById(new Integer(12), new CellAlphabetical("/","5",true));
        this.oneBoard. setCellById(new Integer(13), new CellAlphabetical("/","3",true));
        this.endGameCondition = new EndGameNoCycles();

    }

    @Test
    public void validate() throws Exception {
        assertEquals(true,this.endGameCondition.validate(this.oneBoard));
    }

}