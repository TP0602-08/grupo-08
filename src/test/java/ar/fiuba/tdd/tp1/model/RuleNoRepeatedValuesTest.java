package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.BoardRectangularWithRegions;
import ar.fiuba.tdd.tp1.model.interfaces.Board;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import java.util.Objects;

import static org.junit.Assert.*;

public class RuleNoRepeatedValuesTest {
    private BoardRectangularWithRegions oneBoard;
    private RuleNoRepeatedValues oneRule;
    private List<Object> listOfConflictingCellIds;
    private List<Object> listParams;
    private Move moving;
    private CellNumerical numericCell;
    private CellAlphabetical alfabeticCell;
    private Object visitingCellValue = null;
    private Integer integer1;
    private ArrayList<ViolationOfRule> violatedRules;

    @Before
    public void setUp() throws Exception {
        this.integer1 = new Integer(4);
        this.oneBoard = new BoardRectangularWithRegions(9, 9);
        this.oneRule = new RuleNoRepeatedValues(oneBoard, "6");
        this.numericCell = new CellNumerical(integer1, "4");
        this.alfabeticCell = new CellAlphabetical("a", "3");
        this.moving = new Move(new Integer(5), numericCell);
        this.listParams = new ArrayList<Object>();
        this.listParams.add("18");
       // this.listOfConflictingCellIds.add("18");
        //this.violatedRules.add(new ViolationOfRule("hay valores repetidos",this.listOfConflictingCellIds));
    }

    @Test
    public void getNameTest() throws Exception {
        assertEquals("NoRepeatedValues",oneRule.getName());
    }

    @Test
    public void validateTest() throws Exception {
        //this.numericCell = new CellNumerical(new Integer(0),"3");
        //assertEquals(3,this.listOfConflictingCellIds.size());
        //assertEquals(false,oneRule.validate(moving));
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
        assertEquals("a", ((String) oneRule.getVisitingCellValue()));
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
        assertEquals("6", this.oneRule.getRegionId());
    }

}