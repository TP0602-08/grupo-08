package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.serialization.xml.CellXml;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.*;

public class CellXmlSerializationTests {
    private static final String CELLXML = "src/test/resources/XmlCellTest.xml";
    private static final int COLUMN = 10;
    private static final int ROW = 10;
    private static final String ID = "1";
    private static final String VALUE = "3";
    private static Unmarshaller unmarshaller;
    private static File xml;

    @BeforeClass
    public static void setUpBeforeClass() {
        xml = new File(CELLXML);
        try {
            JAXBContext jaxb = JAXBContext.newInstance(CellXml.class);
            unmarshaller = jaxb.createUnmarshaller();
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void canReadFile() {
        assertTrue(xml.exists());
    }

    @Test
    public void canReadUnmarshallCell() {
        try {
            CellXml cell = (CellXml)unmarshaller.unmarshal(xml);
            assertTrue(true);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readColumnValue() {
        try {
            CellXml cell = (CellXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getColumn(), COLUMN);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readRowValue() {
        try {
            CellXml cell = (CellXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getRow(), ROW);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readValueValue() {
        try {
            CellXml cell = (CellXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getValue(), VALUE);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readIdValue() {
        try {
            CellXml cell = (CellXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getId(), ID);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}
