package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class RuleTotalSumEqualsTest {
    private Board oneBoard;
    private RuleTotalSumEquals oneRule;
    private List<Integer> listOfConflictingCellIds;
    private List<Object> listParams;
    private Move moving;
    private CellNumerical numericCell;
    private Region validRegion;
    private Region invalidRegion;
    private List<String> listCelds;
    private int sumTotalDeLaRegion;
    private String regionID;
    private String nuevaRegionId;
    private int nuevaSuma;

    @Before
    public void setUp() throws Exception {
        this.oneBoard = new Board(9,9);
        this.sumTotalDeLaRegion = 10;
        this.regionID = "2";
        this.oneRule = new RuleTotalSumEquals(this.oneBoard,this.regionID,this.sumTotalDeLaRegion);
        this.nuevaRegionId = "3";
        this.nuevaSuma = 9;
        this.listParams = new ArrayList<Object>();
        this.listParams.add(nuevaRegionId);
        this.listParams.add(nuevaSuma);
        this.moving = new Move(new Integer(6), new CellAlphabetical("a", "3"));
        this.listOfConflictingCellIds = new ArrayList<Integer>(Arrays.asList(11, 18));
        this.listCelds = new ArrayList<String>(Arrays.asList("1", "2", "3", "4"));
        this.oneBoard.setCellById(new Integer(1), new CellNumerical(new Integer(2),"1"));
        this.oneBoard.setCellById(new Integer(2), new CellNumerical(new Integer(3),"2"));
        this.oneBoard.setCellById(new Integer(3), new CellNumerical(new Integer(1),"3"));
        this.oneBoard.setCellById(new Integer(4), new CellNumerical(new Integer(5),"4"));
        this.oneBoard.setRegion("1", new Region(this.listCelds,"13"));
        this.oneBoard.setRegion("2", new Region(this.listCelds,"8"));
    }

    @Test
    public void getName() throws Exception {
        assertEquals("TotalSumEquals",this.oneRule.getName());
    }

    @Test
    public void validate() throws Exception {
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
    public void createNewInstance() throws Exception {
        RuleTotalSumEquals secondRule = this.oneRule.createNewInstance(this.listParams);
        assertTrue(secondRule instanceof RuleTotalSumEquals);
    }

    @Test
    public void visit1() throws Exception {
        //this.oneRule.visit(this.alfabeticCell);
        //assertEquals("a",((String)oneRule.getVisitingCellValue()));
    }

    @Test
    public void getRegionId() throws Exception {
        assertEquals(this.regionID,oneRule.getRegionId());
    }

    @Test
    public void getSum() throws Exception {
        assertEquals(sumTotalDeLaRegion,oneRule.getSum());

    }

}