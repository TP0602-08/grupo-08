package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;



public class RuleTotalProductEqualsTest {
    private RuleTotalProductEquals oneRule;
    private BoardRectangularWithRegions oneBoard;

    @Before
    public void setUp() throws Exception {
        this.oneRule = new RuleTotalProductEquals(this.oneBoard,"1",23);
    }

    @Test
    public void getName() throws Exception {
     assertEquals("TotalProductEquals",oneRule.getName());
    }


    @Test
    public void validate() throws Exception {

    }

    @Test
    public void createNewInstance() throws Exception {

    }

    @Test
    public void visit() throws Exception {

    }

    @Test
    public void visit1() throws Exception {

    }


    @Test
    public void getRegionIdTest() throws Exception {
        assertEquals("1", this.oneRule.getRegionId());
    }

    @Test
    public void getProduct() throws Exception {

    }

}