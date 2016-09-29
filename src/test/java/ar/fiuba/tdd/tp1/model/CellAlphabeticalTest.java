package ar.fiuba.tdd.tp1.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CellAlphabeticalTest {
    @Test
    public void cellAlphabeticalIsCreated() {
        String cellDatumValue = "ABC123";
        String cellNameValue = "XYZ789";
        CellAlphabetical cellAlphabetical = new CellAlphabetical(cellDatumValue, cellNameValue);
        assertTrue(cellDatumValue.equals(cellAlphabetical.getDatum()));
        assertTrue(cellNameValue.equals(cellAlphabetical.getName()));
    }

    @Test
    public void setDatum() {
        String cellDatumValue = "ABC123";
        String cellNameValue = "XYZ789";
        String cellNewDatumValue = "DEF456";
        CellAlphabetical cellAlphabetical = new CellAlphabetical(cellDatumValue, cellNameValue);
        cellAlphabetical.setDatum(cellNewDatumValue);
        assertTrue(cellNewDatumValue.equals(cellAlphabetical.getDatum()));
    }

    @Test
    public void setName() {
        String cellDatumValue = "ABC123";
        String cellNameValue = "XYZ789";
        String cellNewNameValue = "UVW";
        CellAlphabetical cellAlphabetical = new CellAlphabetical(cellDatumValue, cellNameValue);
        cellAlphabetical.setName(cellNewNameValue);
        assertTrue(cellNewNameValue.equals(cellAlphabetical.getName()));
    }
}