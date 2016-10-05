package ar.fiuba.tdd.tp1.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CellNumericalTest {
    @Test
    public void cellNumericalIsCreated() {
        Integer cellDatumValue = 123456;
        String cellNameValue = "XYZ789";
        CellNumerical cellNumerical = new CellNumerical(cellDatumValue, cellNameValue);
        assertTrue(cellDatumValue.equals(cellNumerical.getDatum()));
        assertTrue(cellNameValue.equals(cellNumerical.getName()));
    }

    @Test
    public void setDatum() {
        Integer cellDatumValue = 123456;
        String cellNameValue = "XYZ789";
        Integer cellNewDatumValue = 654321;
        CellNumerical cellNumerical = new CellNumerical(cellDatumValue, cellNameValue);
        cellNumerical.setDatum(cellNewDatumValue);
        assertTrue(cellNewDatumValue.equals(cellNumerical.getDatum()));
    }

    @Test
    public void setName() {
        Integer cellDatumValue = 123456;
        String cellNameValue = "XYZ789";
        String cellNewNameValue = "UVW";
        CellNumerical cellNumerical = new CellNumerical(cellDatumValue, cellNameValue);
        cellNumerical.setName(cellNewNameValue);
        assertTrue(cellNewNameValue.equals(cellNumerical.getName()));
    }

    @Test
    public  void isCellEmptyTest() {
        Integer cellDatumValue = 0;
        String cellNameValue = "XYZ789";
        CellNumerical cellNumerical = new CellNumerical(cellDatumValue, cellNameValue);
        assertEquals(true,cellNumerical.empty);

    }
}
