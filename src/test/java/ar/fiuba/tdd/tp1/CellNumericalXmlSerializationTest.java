package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.serialization.xml.CellNumericalXml;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CellNumericalXmlSerializationTest {
    private static final int COLUMN = 10;
    private static final int ROW = 10;
    private static final String ID = "1";
    private static final int VALUE = 100;
    
    private static final String CELLNUMERICALXML = "src/test/resources/XmlCellNumericalTest.xml";
    private static Unmarshaller unmarshaller;
    private static File xml;

    @BeforeClass
    public static void setUpBeforeClass() {
        xml = new File(CELLNUMERICALXML);
        try {
            JAXBContext jaxb = JAXBContext.newInstance(CellNumericalXml.class);
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
            CellNumericalXml cell = (CellNumericalXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getClass(), CellNumericalXml.class);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }


    @Test
    public void readColumnValue() {
        try {
            CellNumericalXml cell = (CellNumericalXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getColumn(), COLUMN);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readRowValue() {
        try {
            CellNumericalXml cell = (CellNumericalXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getRow(), ROW);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readIdValue() {
        try {
            CellNumericalXml cell = (CellNumericalXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getId(), ID);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readValue() {
        try {
            CellNumericalXml cell = (CellNumericalXml)unmarshaller.unmarshal(xml);
            assertEquals(cell.getValue(), VALUE);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

    }
}
