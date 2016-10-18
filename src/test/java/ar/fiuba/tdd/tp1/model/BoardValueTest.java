package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marcos on 18/10/16.
 */
public class BoardValueTest {
   private BoardValue valueOfBoard;
   private int cellId;
   private int value;
   private int valueOfColums;

    @Before
    public void setUp() throws Exception {
         this.cellId = 16;
         this.value = 12;
         this.valueOfColums = 9;
         this.valueOfBoard = new BoardValue(this.cellId,this.valueOfColums,this.value);

    }

    @Test
    public void getX() throws Exception {
         assertEquals(3,this.valueOfBoard.getX());
    }

    @Test
    public void getY() throws Exception {
        assertEquals(-2,this.valueOfBoard.getY());
    }

    @Test
    public void getValue() throws Exception {
        assertEquals(this.value,this.valueOfBoard.getValue());
    }

}