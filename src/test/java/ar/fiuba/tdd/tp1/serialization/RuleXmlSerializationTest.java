package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.serialization.xml.RuleXml;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RuleXmlSerializationTest {
    private static final String RULEXML = "src/test/resources/XmlRuleTest.xml";
    private static final String NAME = "RuleNoRepeatedValues";

    private static Unmarshaller unmarshaller;
    private static File xml;

    @BeforeClass
    public static void setUpBeforeClass() {
        xml = new File(RULEXML);
        try {
            JAXBContext jaxb = JAXBContext.newInstance(RuleXml.class);
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
    public void canReadUnmarshallRule() {
        try {
            RuleXml rule = (RuleXml)unmarshaller.unmarshal(xml);
            assertTrue(true);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readName() {
        try {
            RuleXml rule = (RuleXml)unmarshaller.unmarshal(xml);
            assertEquals(rule.getName(), NAME);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}
