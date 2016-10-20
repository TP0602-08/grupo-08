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
        int dimRowS = 5;
        int dimCols = 5;
        this.oneBoard = new BoardRectangularWithRegions(dimCols,dimRowS);
                                  //ID                          //dATA  //NAME //isEDITABLE
        this.oneBoard. setCellById(new Integer(1), new CellAlphabetical("/","1",true));
        this.oneBoard. setCellById(new Integer(2), new CellAlphabetical("\\","2",true));
        this.oneBoard. setCellById(new Integer(6), new CellAlphabetical("\\","6",true));
        this.oneBoard. setCellById(new Integer(7), new CellAlphabetical("/","7",true));
        this.endGameCondition = new EndGameNoCycles();


    }

    @Test
    public void validate() throws Exception {
        assertFalse(this.endGameCondition.validate(this.oneBoard));
    }

}