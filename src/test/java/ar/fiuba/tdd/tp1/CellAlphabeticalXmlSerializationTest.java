package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.serialization.xml.CellAlphabeticalXml;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CellAlphabeticalXmlSerializationTest {
    private static final int COLUMN = 10;
    private static final int ROW = 10;
    private static final String ID = "1";
    private static final String VALUE = "Test";

    private static final String CELLALPHABETICALXML = "src/test/resources/XmlCellAlphabeticalTest.xml";
    private static Unmarshaller unmarshaller;
    private static File xml;

    @BeforeClass
    public static void setUpBeforeClass() {
        xml = new File(CELLALPHABETICALXML);
        try {
            JAXBContext jaxb = JAXBContext.newInstance(CellAlphabeticalXml.class);
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
            CellAlphabeticalXml cell = (CellAlphabeticalXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getClass(), CellAlphabeticalXml.class);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }


    @Test
    public void readColumnValue() {
        try {
            CellAlphabeticalXml cell = (CellAlphabeticalXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getColumn(), COLUMN);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readRowValue() {
        try {
            CellAlphabeticalXml cell = (CellAlphabeticalXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getRow(), ROW);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readIdValue() {
        try {
            CellAlphabeticalXml cell = (CellAlphabeticalXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getId(), ID);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readValue() {
        try {
            CellAlphabeticalXml cell = (CellAlphabeticalXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getValue(), VALUE);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

    }
}
