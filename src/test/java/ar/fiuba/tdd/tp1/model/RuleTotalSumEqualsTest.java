package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.*;

public class RuleTotalSumEqualsTest {
    private BoardRectangularWithRegions oneBoard;
    private RuleTotalSumEquals oneRule;
    private List<Integer> listOfConflictingCellIds;
    private List<Object> listParams;
    private Move moving;
    private CellNumerical numericCell;
    private CellAlphabetical alfabeticCell;
    private CellNumerical numericCell1;
    private CellNumerical numericCell2;
    private CellNumerical numericCell3;
    private CellNumerical numericCell4;
    private Region validRegion;
    private Region invalidRegion;
    private List<String> listCelds;
    private List<Integer> listIdCelds;
    private Map<String, Region> regionsMap;
    private int sumTotalDeLaRegion;
    private String regionID;
    private String nuevaRegionId;
    private int nuevaSuma;

    @Before
    public void setUp() throws Exception {
        this.oneBoard = new BoardRectangularWithRegions(9,9);
        this.sumTotalDeLaRegion = 10;
        this.regionID = "2";
        this.oneRule = new RuleTotalSumEquals(this.oneBoard,this.regionID,this.sumTotalDeLaRegion);
        this.nuevaRegionId = "3";
        this.nuevaSuma = 9;
        this.listParams = new ArrayList<Object>();
        this.listParams.add(nuevaRegionId);
        this.listParams.add(nuevaSuma);
        this.alfabeticCell = new CellAlphabetical("a", "3");
        this.numericCell = new CellNumerical(new Integer(2), "6");
        this.moving = new Move(new Integer(6), this.alfabeticCell);
        this.numericCell1 = new CellNumerical(new Integer(2), "1");

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

        this.validRegion = new Region(this.listCelds,"13");
        this.invalidRegion = new Region(this.listCelds,"8");
        this.oneBoard.setCellById(new Integer(1),numericCell1);
        this.oneBoard.setCellById(new Integer(2),numericCell2);
        this.oneBoard.setCellById(new Integer(3),numericCell3);
        this.oneBoard.setCellById(new Integer(4),numericCell4);
        this.oneBoard.setRegion("1",this.validRegion);
        this.oneBoard.setRegion("2",this.invalidRegion);

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