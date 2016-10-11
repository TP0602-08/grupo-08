package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.BoardRectangularWithRegions;
import ar.fiuba.tdd.tp1.model.interfaces.Board;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class RuleNoRepeatedValuesTest {
    private BoardRectangularWithRegions oneBoard;
    private RuleNoRepeatedValues oneRule;
    private RuleNoRepeatedValues otherRule;
    private RuleNoRepeatedValues oneMoreRule;

    private List<Integer> listOfConflictingCellIds;
    private List<Object> listParams;
    private Move moving;
    private CellNumerical numericCell;
    private CellAlphabetical alfabeticCell;
    private Integer integer1;
    private List<String> listCelds;
    private List<Integer> listIdCelds;
    private Map<String, Region> regionsMap;

    @Before
    public void setUp() throws Exception {
        this.integer1 = new Integer(4);
        this.oneBoard = new BoardRectangularWithRegions(9, 9);
        this.oneRule = new RuleNoRepeatedValues(oneBoard,"1");
        this.numericCell = new CellNumerical(integer1,"4");

        this.alfabeticCell = new CellAlphabetical("a","3");

        this.moving = new Move(new Integer(4), numericCell);
        this.listParams = new ArrayList<Object>(Arrays.asList("18"));
        this.listOfConflictingCellIds = new ArrayList<Integer>(Arrays.asList(11, 18));

        this.listCelds = new ArrayList<String>(Arrays.asList("1", "2", "3", "4"));
        this.listCelds.add("4");

        this.listIdCelds = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));

        this.oneBoard.setCellById(new Integer(1), new CellNumerical(new Integer(2),"1"));
        this.oneBoard.setCellById(new Integer(2), new CellNumerical(new Integer(3),"2"));
        this.oneBoard.setCellById(new Integer(3), new CellNumerical(new Integer(1),"3"));
        this.oneBoard.setCellById(new Integer(4),new CellNumerical(new Integer(5),"4"));

        this.oneBoard.setRegion("1",new Region(listCelds,"15"));
        this.oneBoard.setRegion("2",new Region(listCelds,"8"));

        this.otherRule = new RuleNoRepeatedValues(this.oneBoard,"1");
        this.oneMoreRule = new RuleNoRepeatedValues(this.oneBoard,"2");
    }

    @Test
    public void getNameTest() throws Exception {
        assertEquals("NoRepeatedValues",oneRule.getName());
    }

    @Test
    public void validateTestNoViolationRule() throws Exception {
        assertTrue(this.moving.getListOfViolationsOfRules().isEmpty());
        this.oneRule.validate(this.moving);
        assertEquals(0,moving.getListOfViolationsOfRules().size());
    }

    @Test
    public void validateTestViolationRule() throws Exception {
        assertTrue(this.moving.getListOfViolationsOfRules().isEmpty());
        this.numericCell = new CellNumerical(new Integer(2),"1");
        this.moving = new Move(new Integer(4), numericCell);
        this.oneRule.validate(this.moving);
        assertEquals(false,moving.getListOfViolationsOfRules().isEmpty());
    }

    @Test
    public void validateDeleteMoveNumericalCellTest() throws Exception {
        this.numericCell = new CellNumerical(new Integer(0), "3");
        this.moving = new Move(new Integer(5), numericCell);
        assertEquals(false, oneRule.validate(moving));
    }

    @Test
    public void validateDeleteMoveAlphabeticalCellTest() throws Exception {
        this.alfabeticCell = new CellAlphabetical(null, "3");
        this.moving = new Move(new Integer(5), this.alfabeticCell);
        assertEquals(false, oneRule.validate(moving));
    }

    @Test
    public void createNewInstanceTest() throws Exception {
        RuleNoRepeatedValues secondRule = oneRule.createNewInstance(this.listParams);
        assertTrue(secondRule instanceof RuleNoRepeatedValues);
    }

    @Test
    public void visitTest() throws Exception {
        this.oneRule.visit(this.alfabeticCell);
        assertEquals("a",((String)oneRule.getVisitingCellValue()));
    }

    @Test
    public void visit1TestValue() throws Exception {
        this.oneRule.visit(this.numericCell);
        assertEquals(4, ((Integer) this.oneRule.getVisitingCellValue()).intValue());
    }

    @Test
    public void visit1TestNull() throws Exception {
        this.numericCell = new CellNumerical(new Integer(0), "3");
        oneRule.visit(numericCell);
        assertEquals(null, this.oneRule.getVisitingCellValue());
    }

    @Test
    public void getRegionIdTest() throws Exception {
        assertEquals("1", this.oneRule.getRegionId());
    }

}