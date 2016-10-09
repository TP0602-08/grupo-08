package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class RuleTotalSumEqualsTest {
    private BoardRectangularWithRegions oneBoard;
    private Move oneMove;
    private RuleTotalSumEquals oneRule;
    private int sumaTotalDeLaRegion;
    private String regionID;
    private List<Object> listParams;
    private String nuevaRegionId;
    private int nuevaSuma;
    private Cell alfabeticCell;

    @Before
    public void setUp() throws Exception {
        this.sumaTotalDeLaRegion = 10;
        this.regionID = "2";
        this.oneRule = new RuleTotalSumEquals(oneBoard,regionID,sumaTotalDeLaRegion);
        this.nuevaRegionId = "3";
        this.nuevaSuma = 9 ;
        this.listParams = new ArrayList<Object>();
        this.listParams.add(nuevaRegionId);
        this.listParams.add(nuevaSuma);
        this.alfabeticCell = new CellAlphabetical("a","3");

    }

    @Test
    public void getName() throws Exception {
        assertEquals("TotalSumEquals",this.oneRule.getName());
    }
    //TODO
    @Test
    public void validate() throws Exception {

    }

    @Test
    public void createNewInstance() throws Exception {
        RuleTotalSumEquals secondRule = this.oneRule.createNewInstance(this.listParams);
        assertTrue(secondRule instanceof RuleTotalSumEquals);
    }
     //TODO Sin modificar la clase
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
         assertEquals(sumaTotalDeLaRegion,oneRule.getSum());

    }

}