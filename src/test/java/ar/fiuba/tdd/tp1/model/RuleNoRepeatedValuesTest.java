package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.BoardRectangularWithRegions;
import ar.fiuba.tdd.tp1.model.interfaces.Board;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.Objects;

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
    private Object visitingCellValue = null;
    private Integer integer1;
    private ArrayList<ViolationOfRule> violatedRules;
    private CellNumerical numericCell1;
    private CellNumerical numericCell2;
    private CellNumerical numericCell3;
    private CellNumerical numericCell4;
    private Region validRegion;
    private Region invalidRegion;
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
        this.listParams = new ArrayList<Object>();
        this.listParams.add("18");
        this.listOfConflictingCellIds = new ArrayList<Integer>();
        this.listOfConflictingCellIds.add(new Integer(11));
        this.listOfConflictingCellIds.add(new Integer(18));

        this.numericCell1 = new CellNumerical(new Integer(2),"1");
        this.numericCell2 = new CellNumerical(new Integer(3),"2");
        this.numericCell3 = new CellNumerical(new Integer(1),"3");
        this.numericCell4 = new CellNumerical(new Integer(5),"4");

        this.listCelds = new ArrayList<String>();
        this.listCelds.add("1");
        this.listCelds.add("2");
        this.listCelds.add("3");
        this.listCelds.add("4");

        this.listIdCelds = new ArrayList<Integer>();
        this.listIdCelds.add(new Integer(1));
        this.listIdCelds.add(new Integer(2));
        this.listIdCelds.add(new Integer(3));
        this.listIdCelds.add(new Integer(4));


        this.validRegion = new Region(listCelds,"15");
        this.invalidRegion = new Region(listCelds,"8");

        this.oneBoard.setCellById(new Integer(1),numericCell1);
        this.oneBoard.setCellById(new Integer(2),numericCell2);
        this.oneBoard.setCellById(new Integer(3),numericCell3);
        this.oneBoard.setCellById(new Integer(4),numericCell4);

        this.oneBoard.setRegion("1",this.validRegion);
        this.oneBoard.setRegion("2",this.invalidRegion);

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