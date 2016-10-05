package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;

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
    private CellNumerical numericCell;
    private CellAlphabetical alfabeticCell;
    private Object visitingCellValue = null;
    private Integer integer1 ;

    @Before
    public void setUp() throws Exception {
        this.integer1 =  new Integer(4);
        this.oneBoard = new BoardRectangularWithRegions(9,9);
        this.oneRule = new RuleNoRepeatedValues(oneBoard,"6");
        this.numericCell = new CellNumerical(integer1, "4");
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
    public void visit1TestValue() throws Exception {
        this.oneRule.visit(this.numericCell);
        assertEquals (4,((Integer)oneRule.getVisitingCellValue()).intValue());
    }
    @Test
    public void visit1TestNull() throws Exception {
        this.numericCell = new CellNumerical(new Integer(0),"3");
        oneRule.visit(numericCell);
        assertEquals (null,oneRule.getVisitingCellValue());
    }

    @Test
    public void getRegionIdTest() throws Exception {
        assertEquals("6",oneRule.getRegionId());

    }

}