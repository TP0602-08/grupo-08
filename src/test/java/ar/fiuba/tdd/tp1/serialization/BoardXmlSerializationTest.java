package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.model.Board;
import ar.fiuba.tdd.tp1.serialization.xml.BoardXml;
import ar.fiuba.tdd.tp1.serialization.xml.BoardXmlSerializer;
import ar.fiuba.tdd.tp1.serialization.xml.CellNumericalXml;
import ar.fiuba.tdd.tp1.serialization.xml.CellXml;
import ar.fiuba.tdd.tp1.serialization.xml.RegionXml;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BoardXmlSerializationTest {
    private static final String SIMPLEBOARDXML = "src/test/resources/XmlSimpleBoardTest.xml";
    private static final String WITHREGIONSXML = "src/test/resources/XmlBoardWithRegionsTest.xml";
    private static final int COLUMNS = 4;
    private static final int ROWS = 4;
    private static final int CELLSSIZE = 16;
    private static final int REGIONSSIZE = 1;

    private static Unmarshaller unmarshaller;
    private static File simpleXml;
    private static File withRegionsXml;

    @BeforeClass
    public static void setUpBeforeClass() {
        simpleXml = new File(SIMPLEBOARDXML);
        withRegionsXml = new File(WITHREGIONSXML);
        try {
            JAXBContext jaxb = JAXBContext.newInstance(BoardXml.class);
            unmarshaller = jaxb.createUnmarshaller();
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void canReadFiles() {
        assertTrue(simpleXml.exists());
        assertTrue(withRegionsXml.exists());
    }

    @Test
    public void canReadUnmarshallSimpleBoard() {
        try {
            BoardXml board = (BoardXml)unmarshaller.unmarshal(simpleXml);
            assertTrue(true);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void canReadUnmarshallBoardWithRegions() {
        try {
            BoardXml board = (BoardXml)unmarshaller.unmarshal(withRegionsXml);
            assertTrue(true);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readColumnsValue() {
        try {
            BoardXml board = (BoardXml)unmarshaller.unmarshal(simpleXml);
            assertEquals(board.getColumns(), COLUMNS);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readRowsValue() {
        try {
            BoardXml board = (BoardXml)unmarshaller.unmarshal(simpleXml);
            assertEquals(board.getRows(), ROWS);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readAllCells() {
        try {
            BoardXml board = (BoardXml)unmarshaller.unmarshal(simpleXml);
            assertEquals(board.getCells().size(), CELLSSIZE);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readCellsAreNumerical() {
        try {
            BoardXml board = (BoardXml)unmarshaller.unmarshal(simpleXml);
            for (int i = 0; i < board.getRows(); i++) {
                for (int j = 0; j < board.getColumns(); j++) {
                    CellXml cell = board.getCells().get(i * board.getColumns() + j);
                    assertEquals(cell.getClass(), CellNumericalXml.class);
                }
            }
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readCellAttributes() {
        try {
            BoardXml board = (BoardXml)unmarshaller.unmarshal(simpleXml);
            for (int i = 0; i < board.getRows(); i++) {
                for (int j = 0; j < board.getColumns(); j++) {
                    CellXml cell = board.getCells().get(i * board.getColumns() + j);
                    assertEquals(cell.getRow(), i);
                    assertEquals(cell.getColumn(), j);
                    assertEquals(((CellNumericalXml)cell).getValue(), i + 1);
                }
            }
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readAllRegions() {
        try {
            BoardXml board = (BoardXml)unmarshaller.unmarshal(withRegionsXml);
            assertEquals(board.getRegions().size(), REGIONSSIZE);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readRegionCellsIds() {
        try {
            BoardXml board = (BoardXml)unmarshaller.unmarshal(withRegionsXml);
            for (int i = 0; i < board.getRegions().size(); i++) {
                RegionXml region = board.getRegions().get(i);
                for (int j = 0; j < region.getCells().size(); j++) {
                    assertEquals(region.getCells().get(j), String.valueOf(i * board.getRegions().size() + j + 1));
                }
            }
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void deserializedBoardHasSameNumberOfRegions() {
        try {
            BoardXml board = (BoardXml)unmarshaller.unmarshal(withRegionsXml);
            Board deserializedBoard = new BoardXmlSerializer(board).deserialize();
            assertEquals(board.getRegions().size(), deserializedBoard.getNumberOfRegions());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void deserializedBoardHasSameNumberOfCells() {
        try {
            BoardXml board = (BoardXml)unmarshaller.unmarshal(withRegionsXml);
            Board deserializedBoard = new BoardXmlSerializer(board).deserialize();
            assertEquals(board.getCells().size(), deserializedBoard.getNumberOfCells());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}
