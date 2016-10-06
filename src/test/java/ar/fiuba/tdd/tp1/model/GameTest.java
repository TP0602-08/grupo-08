package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.serialization.xml.GameXmlSerializer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GameTest {
    private static final String GAMEXML = "src/main/resources/sudoku.xml";
    private static Game game;

    @Before
    public void setUpBeforeClass() {
        try {
            game = new GameXmlSerializer(GAMEXML).deserialize();
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void sudokuRepeatedValueInRowCausesInvalidMove() {
        Cell changedValuedCell = new CellNumerical(2, "2");
        Move move = new Move(2, changedValuedCell);
        game.process(move);
        List<MoveHistory> moveHistory = game.getMoveHistory();
        assertFalse(moveHistory.get(0).wasValid());
    }

    @Test
    public void sudokuRepeatedValueInColumnCausesInvalidMove() {
        Cell changedValuedCell = new CellNumerical(5, "2");
        Move move = new Move(1, changedValuedCell);
        game.process(move);
        List<MoveHistory> moveHistory = game.getMoveHistory();
        assertFalse(moveHistory.get(0).wasValid());
    }

    @Test
    public void sudokuRepeatedValueInBlockCausesInvalidMove() {
        Cell changedValuedCell = new CellNumerical(7, "2");
        Move move = new Move(1, changedValuedCell);
        game.process(move);
        List<MoveHistory> moveHistory = game.getMoveHistory();
        assertFalse(moveHistory.get(0).wasValid());
    }


    @Test
    public void sudokuNonRepeatedValueIsValidMove() {
        Cell changedValuedCell = new CellNumerical(8, "2");
        Move move = new Move(1, changedValuedCell);
        game.process(move);
        List<MoveHistory> moveHistory = game.getMoveHistory();
        assertTrue(moveHistory.get(0).wasValid());
    }
}
