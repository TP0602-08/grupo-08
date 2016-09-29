package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MoveTest {
    private static Integer cellDatumValue;
    private static String cellNameValue;
    private static CellNumerical cell;
    private static Integer cellIdValue;
    private static Move move;
    private static List<Integer> listOfCellIds;
    private static ViolationOfRule violationOfRule;

    @Before
    public void setUpBeforeClass() {
        cellDatumValue = 123456;
        cellNameValue = "XYZ789";
        cell = new CellNumerical(cellDatumValue, cellNameValue);
        cellIdValue = new Integer(789);
        move = new Move(cellIdValue, cell);
        listOfCellIds = new ArrayList<Integer>();
        violationOfRule = new ViolationOfRule("ABC", listOfCellIds);
    }

    @Test
    public void moveIsCreated() {
        assertEquals(cellIdValue, move.getcellId());
        assertEquals(cell, move.getNewCell());
    }

    @Test
    public void getcellId() {
        assertEquals(cellIdValue, move.getcellId());
    }

    @Test
    public void getNewCell() {
        assertEquals(cell, move.getNewCell());
    }

    @Test
    public void getListOfViolationsOfRulesReturnsEmptyListCalledRightAfterConstruction() {
        assertTrue(move.getListOfViolationsOfRules().isEmpty());
    }

    @Test
    public void getListOfViolationsOfRulesWithOneViolationInTheList() {
        move.addViolationOfRule(violationOfRule);
        assertEquals(move.getListOfViolationsOfRules().size(), 1);
    }

    @Test
    public void getListOfViolationsOfRulesWithOneViolationInTheListDidntChangeTheViolation() {
        move.addViolationOfRule(violationOfRule);
        assertEquals(move.getListOfViolationsOfRules().get(0), violationOfRule);
    }

    @Test
    public void isValidReturnsTrueCalledRightAfterConstruction() {
        assertTrue(move.isValid());
    }

    @Test
    public void isValidReturnsFalseWhenThereAreViolations() {
        move.addViolationOfRule(violationOfRule);
        assertFalse(move.isValid());
    }

    @Test
    public void addViolationOfRule() {
        assertTrue(move.isValid());
        move.addViolationOfRule(violationOfRule);
        assertFalse(move.isValid());
    }

    @Test
    public void addViolationOfRuleDidntChangeTheViolation() {
        move.addViolationOfRule(violationOfRule);
        assertEquals(move.getListOfViolationsOfRules().get(0), violationOfRule);
    }
}