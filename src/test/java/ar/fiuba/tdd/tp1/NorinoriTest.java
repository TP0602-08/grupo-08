package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.model.CellAlphabetical;
import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.model.Move;
import ar.fiuba.tdd.tp1.model.MoveHistory;
import ar.fiuba.tdd.tp1.serialization.json.GameJsonSerializer;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NorinoriTest {
    private static final String NORINORIJSON = "src/main/resources/norinori.json";
    private static final String WINGAMENORINORIJSON = "src/test/resources/winGameNorinori.json";
    private static final String BLACK = "black";
    private static final String HAYMASDEDOSCELDAS = "Hay más de 2 celdas en negro en la región";
    private static final String CELDASNEGRASCONTINUAS = "Las celdas negras de la región están continuas a celdas negras de otra región";

    private static Game game;

    @Before
    public void setUp() throws IOException {
        game = new GameJsonSerializer(NORINORIJSON).deserialize();
    }

    @Test
    public void addingBlackCellInRegionWithMoreThanOneCellCausesValidMove() {
        CellAlphabetical newCell = new CellAlphabetical(BLACK, "1");
        Move validMove = new Move(1, newCell);
        game.process(validMove);
        assertTrue(validMove.isValid());
    }

    @Test
    public void completingRegionWithTwoCellsDoesntCauseInvalidMove() {
        CellAlphabetical newCell = new CellAlphabetical(BLACK, "1");
        Move validMove = new Move(1, newCell);
        game.process(validMove);
        assertTrue(validMove.isValid());
        newCell = new CellAlphabetical(BLACK, "11");
        validMove = new Move(11, newCell);
        game.process(validMove);
    }

    @Test
    public void addingMoreBlackCellsThanAllowedCausesInvalidMove() {
        CellAlphabetical newCell = new CellAlphabetical(BLACK, "4");
        Move validMove = new Move(4, newCell);
        game.process(validMove);
        newCell = new CellAlphabetical(BLACK, "5");
        validMove = new Move(5, newCell);
        game.process(validMove);
        newCell = new CellAlphabetical(BLACK, "6");
        Move invalidMove = new Move(6, newCell);
        game.process(invalidMove);
        assertFalse(invalidMove.isValid());
    }

    @Test
    public void addingMoreBlackCellsThanAllowedCausesMoreThanTwoCellsViolation() {
        CellAlphabetical newCell = new CellAlphabetical(BLACK, "4");
        Move validMove = new Move(4, newCell);
        game.process(validMove);
        newCell = new CellAlphabetical(BLACK, "5");
        validMove = new Move(5, newCell);
        game.process(validMove);
        newCell = new CellAlphabetical(BLACK, "6");
        Move invalidMove = new Move(6, newCell);
        game.process(invalidMove);
        assertTrue(invalidMove.getListOfViolationsOfRules().get(0).getExplanation().equals(HAYMASDEDOSCELDAS));
    }

    @Test
    public void addingABlackCellNextToAnotherRegionsBlackCellCausesInvalidMove() {
        CellAlphabetical newCell = new CellAlphabetical(BLACK, "1");
        Move validMove = new Move(1, newCell);
        game.process(validMove);
        newCell = new CellAlphabetical(BLACK, "2");
        Move invalidMove = new Move(2, newCell);
        game.process(invalidMove);
        assertFalse(invalidMove.isValid());
    }

    @Test
    public void addingABlackCellNextToAnotherRegionsBlackCellCausesMustntTouchOtherRegionsViolation() {
        CellAlphabetical newCell = new CellAlphabetical(BLACK, "1");
        Move validMove = new Move(1, newCell);
        game.process(validMove);
        newCell = new CellAlphabetical(BLACK, "2");
        Move invalidMove = new Move(2, newCell);
        game.process(invalidMove);
        assertTrue(invalidMove.getListOfViolationsOfRules().get(0).getExplanation().equals(CELDASNEGRASCONTINUAS));
    }

    @Test
    public void allValidPlaysFromFileCausesValidMovesAndGameWon() throws IOException {
        game = new GameJsonSerializer(NORINORIJSON, WINGAMENORINORIJSON).deserialize();
        game.process();
        for (MoveHistory move : game.getMoveHistory()) {
            assertTrue(move.wasValid());
        }
        assertTrue(game.isGameWon());
    }
}
