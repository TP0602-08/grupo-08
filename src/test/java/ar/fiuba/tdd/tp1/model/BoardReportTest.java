package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by marcos on 18/10/16.
 */
public class BoardReportTest {

    private BoardReport report;
    private List<BoardValue> values;
    private BoardValue oneValue;
    private BoardValue secondValue;
    private String status;

    @Before
    public void setUp() throws Exception {
        this.oneValue = new BoardValue(12,5,2);
        this.secondValue = new BoardValue(1,5,3);
        this.values = new ArrayList<BoardValue>(Arrays.asList(this.oneValue,this.secondValue));
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