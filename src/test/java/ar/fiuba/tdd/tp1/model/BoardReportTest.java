package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 *Class designed to test the current state of the board.
 The getValues method should return the list of values of the board.
 The getStatus method should return the state in which the board is
 (Valid or invalid).
 */
public class BoardReportTest {

    private BoardReport report;
    private List<BoardValue> values;
    private BoardValue oneValue;
    private BoardValue secondValue;
    private String status;

    @Before
    public void setUp() throws Exception {
        int cellId = 12;
        int cellId2 = 1;
        int numberOfColumns = 5;
        String cellValue1 = "2";
        String cellValue2 = "3";
        this.oneValue = new BoardValue(cellId,numberOfColumns,cellValue1);
        this.secondValue = new BoardValue(cellId2,numberOfColumns,cellValue2);
        this.values = new ArrayList<>(Arrays.asList(this.oneValue, this.secondValue));
        this.report = new BoardReport(true,this.values);
    }

    @Test
    public void getStatus() throws Exception {
        this.status = "valid";
        assertEquals(this.status,this.report.getStatus());

    }

    @Test
    public void getValues() throws Exception {
        assertEquals(this.values,this.report.getValues());
    }

}