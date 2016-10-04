package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class RuleNoRepeatedValuesTest {
    private BoardRectangularWithRegions oneBoard;
    private RuleNoRepeatedValues oneRule;
    private List<Integer> listOfConflictingCellIds;
    private Move moving ;
    private Cell numericCell;
    private Cell alfabeticCell;

    @Before
    public void setUp() throws Exception {
        this.oneBoard = new BoardRectangularWithRegions(9,9);
        this.oneRule = new RuleNoRepeatedValues(oneBoard,"6");
        this.numericCell = new CellNumerical(new Integer(4), "2");
        this.alfabeticCell = new CellAlphabetical("a","3");
        this.moving = new Move(new Integer(5),numericCell);
        this.listOfConflictingCellIds = new ArrayList<Integer>();
        this.listOfConflictingCellIds.add(4);
        this.listOfConflictingCellIds.add(18);
    }

    @Test
    public void getNameTest() throws Exception {
        assertEquals("NoRepeatedValues",oneRule.getName());
    }

    @Test
    public void validateTest() throws Exception {

    }

    @Test
    public void createNewInstanceTest() throws Exception {

    }

    @Test
    public void visitTest() throws Exception {

    }

    @Test
    public void visit1() throws Exception {

    }

    @Test
    public void getRegionIdTest() throws Exception {
        assertEquals("6",oneRule.getRegionId());

    }

}