package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.model.Region;
import ar.fiuba.tdd.tp1.serialization.RegionXmlSerializer;
import ar.fiuba.tdd.tp1.serialization.xml.CellXml;
import ar.fiuba.tdd.tp1.serialization.xml.RegionXml;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.*;

public class RegionXmlSerializationTest {
    private static final String REGIONXML = "src/test/resources/XmlRegionTest.xml";
    private static final int SIZE = 16;
    private static final String PARAM = "5";

    private static Unmarshaller unmarshaller;
    private static File xml;

    @BeforeClass
    public static void setUpBeforeClass() {
        xml = new File(REGIONXML);
        try {
            JAXBContext jaxb = JAXBContext.newInstance(RegionXml.class);
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
    public void canReadUnmarshallRegion() {
        try {
            RegionXml region = (RegionXml)unmarshaller.unmarshal(xml);
            assertTrue(true);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readAllCells() {
        try {
            RegionXml region = (RegionXml)unmarshaller.unmarshal(xml);
            assertEquals(region.getCells().size(), SIZE);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readParam() {
        try {
            RegionXml region = (RegionXml)unmarshaller.unmarshal(xml);
            assertEquals(region.getParam(), PARAM);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void cellAttributesNotEmpty() {
        try {
            RegionXml region = (RegionXml)unmarshaller.unmarshal(xml);
            for (int i = 0; i < SIZE; i++) {
                String cell = region.getCells().get(i);
                assertEquals(cell, String.valueOf(i + 1));
            }
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void deserializedRegionShouldHaveSameNumberOfCells() {
        try {
            RegionXml region = (RegionXml)unmarshaller.unmarshal(xml);
            Region deserializedRegion = new RegionXmlSerializer(region).deserialize();
            assertEquals(region.getCells().size(), deserializedRegion.getCellsIdList().size());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void deserializedRegionShouldHaveSameIdsStored() {
        try {
            RegionXml region = (RegionXml)unmarshaller.unmarshal(xml);
            Region deserializedRegion = new RegionXmlSerializer(region).deserialize();
            for (int i = 0; i < SIZE; i++) {
                assertEquals(region.getCells().get(i), deserializedRegion.getCellsIdList().get(i));
            }
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}
