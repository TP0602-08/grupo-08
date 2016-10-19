package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *This class is for the unit test of Board Value class .
 The getX method, you should return the X  coordinate (rows)of the board.
 The getY method should return the Y coordinate (columns) of the board.
 The getValue method should return the valor of cell.
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
        int expectedCordXValue = 2;
        assertEquals(expectedCordXValue,this.valueOfBoard.getX());
    }

    @Test
    public void getY() throws Exception {
        int expectedCordYValue = 7;
        assertEquals(expectedCordYValue,this.valueOfBoard.getY());
    }

    @Test
    public void getValue() throws Exception {
        assertEquals(this.value,this.valueOfBoard.getValue());
    }

}