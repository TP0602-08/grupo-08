package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.serialization.xml.RuleXml;
import ar.fiuba.tdd.tp1.serialization.xml.RulebookXml;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.*;

public class RulebookXmlSerializationTest {
    private static final String RULESXML = "src/test/resources/XmlRulebookTest.xml";
    private static final int SIZE = 2;

    private static Unmarshaller unmarshaller;
    private static File xml;

    @BeforeClass
    public static void setUpBeforeClass() {
        xml = new File(RULESXML);
        try {
            JAXBContext jaxb = JAXBContext.newInstance(RulebookXml.class);
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
    public void canReadUnmarshallRulebook() {
        try {
            RulebookXml rulebook = (RulebookXml)unmarshaller.unmarshal(xml);
            assertTrue(true);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readAllRules() {
        try {
            RulebookXml rulebook = (RulebookXml)unmarshaller.unmarshal(xml);
            assertEquals(rulebook.getRules().size(), SIZE);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void rulesHaveNames() {
        try {
            RulebookXml rulebook = (RulebookXml)unmarshaller.unmarshal(xml);
            for (RuleXml rule : rulebook.getRules()) {
                assertNotEquals(rule.getName(), null);
                assertNotEquals(rule.getName(), "");
            }
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}
