package ar.fiuba.tdd.tp1.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *This class is for the unit test of class InfoCell.
 The getId method, should return the cell ID.
 The getValue method should return the value of the cell.
 The isEditable method should return a Boolean condition that
 says whether the cell is editable or not.
 */
public class CellInfoTest {
    private CellInfo cellInfo;
    int cellId;
    String cellValue;
    Boolean isEditableCell;

    @Before
    public void setUp() throws Exception {
        this.cellId = 1;
        this.cellValue = "2";
        this.isEditableCell = false;
        this.cellInfo = new CellInfo(cellId,this.cellValue,this.isEditableCell);

    }

    @Test
    public void getId() throws Exception {
        assertEquals(this.cellId,this.cellInfo.getId());
    }

    @Test
    public void getValue() throws Exception {
        assertEquals(this.cellValue,this.cellInfo.getValue());
    }



    @Test
    public void isEditable() throws Exception {
        assertEquals(this.isEditableCell,this.cellInfo.isEditable());
    }

}