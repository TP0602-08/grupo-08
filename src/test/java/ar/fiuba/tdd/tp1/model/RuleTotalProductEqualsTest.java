package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;



public class RuleTotalProductEqualsTest {
    private RuleTotalProductEquals oneRule;
    private BoardRectangularWithRegions oneBoard;
    private int productTotalOfRegion;
    private String regionID;
    private String newRegionId;
    private int newProductResult;
    private List<Object> listParams;
    private Move moving;
    private List<Integer> listOfConflictingCellIds;
    private List<String>listCelds;
    private CellNumerical numericCell;

    @Before
    public void setUp() throws Exception {
        this.oneBoard = new BoardRectangularWithRegions(9,9);
        this.productTotalOfRegion = 10;
        this.regionID = "2";
        this.oneRule = new RuleTotalProductEquals(this.oneBoard,this.regionID,this.productTotalOfRegion );
        this.newRegionId = "3";
        this.newProductResult = 9;
        this.listParams = new ArrayList<Object>();
        this.listParams.add(newRegionId);
        this.listParams.add(newProductResult);
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
     assertEquals("TotalProductEquals",oneRule.getName());
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
        Rule secondRule = this.oneRule.createNewInstance(this.listParams);
       assertTrue(secondRule instanceof RuleTotalProductEquals);
    }

    @Test
    public void visit() throws Exception {

    }

    @Test
    public void visit1() throws Exception {

    }


    @Test
    public void getRegionIdTest() throws Exception {
        assertEquals(this.regionID, this.oneRule.getRegionId());
    }

    @Test
    public void getProduct() throws Exception {
        assertEquals(this.productTotalOfRegion,oneRule.getProduct());
    }

}