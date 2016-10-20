package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.model.CellAlphabetical;
import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.model.Move;
import ar.fiuba.tdd.tp1.serialization.json.GameJsonSerializer;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GokigenNanameTest {
    private static final String GOKIGENNANAMEJSON = "src/main/resources/gokigenNaname.json";
    private static final String LAESQUINANOESTOCADA = "La esquina no es tocada";

    private static Game game;

    @Before
    public void setUp() throws IOException {
        game = new GameJsonSerializer(GOKIGENNANAMEJSON).deserialize();
    }

    @Test
    public void fillingOneCellInATwoCellRegionWontCauseInvalidMove() {
        CellAlphabetical cell = new CellAlphabetical("\\", "1");
        Move validMove = new Move(1, cell);
        game.process(validMove);
        assertTrue(validMove.isValid());
    }

    @Test
    public void fillingOneCellInAZeroCellRegionCauseInvalidMove() {
        CellAlphabetical cell = new CellAlphabetical("\\", "5");
        Move invalidMove = new Move(5, cell);
        game.process(invalidMove);
        assertFalse(invalidMove.isValid());
    }

    @Test
    public void fillingCellsInRegionWithoutMeetingTheCornerTouchesCausesInvalidMove() {
        CellAlphabetical cell = new CellAlphabetical("\\", "1");
        Move move = new Move(1, cell);
        game.process(move);
        cell = new CellAlphabetical("\\", "2");
        move = new Move(2, cell);
        game.process(move);
        assertFalse(move.isValid());
    }

    @Test
    public void fillingCellsInRegionWithoutMeetingTheCornerTouchesCausesRuleMustTouchCornerXTimesError() {
        CellAlphabetical cell = new CellAlphabetical("\\", "1");
        Move move = new Move(1, cell);
        game.process(move);
        cell = new CellAlphabetical("\\", "2");
        move = new Move(2, cell);
        game.process(move);
        assertTrue(move.getListOfViolationsOfRules().get(0).getExplanation().contains(LAESQUINANOESTOCADA));
    }

    @Test
    public void fillingCellsInRegionTouchingMoreThanRequestedCausesInvalidMove() {
        CellAlphabetical cell = new CellAlphabetical("\\", "16");
        Move move = new Move(16, cell);
        game.process(move);
        cell = new CellAlphabetical("\\", "21");
        move = new Move(21, cell);
        game.process(move);
        assertFalse(move.isValid());
    }

    @Test
    public void fillingCellsInRegionTouchingMoreThanRequestedCausesRuleMustTouchCornerXTimesError() {
        CellAlphabetical cell = new CellAlphabetical("\\", "16");
        Move move = new Move(16, cell);
        game.process(move);
        cell = new CellAlphabetical("\\", "21");
        move = new Move(21, cell);
        game.process(move);
        assertTrue(move.getListOfViolationsOfRules().get(0).getExplanation().contains(LAESQUINANOESTOCADA));
    }

    @Test
    public void fillingCellsInRegionTouchingAsMuchAsRequestedCausesValidMove() {
        CellAlphabetical cell = new CellAlphabetical("/", "1");
        Move move = new Move(1, cell);
        game.process(move);
        cell = new CellAlphabetical("\\", "2");
        move = new Move(2, cell);
        game.process(move);
        assertTrue(move.isValid());
    }

    
}
