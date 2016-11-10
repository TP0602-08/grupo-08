package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.serialization.json.GameJsonSerializer;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class UndoTest {

    private static final String SUDOKUJSON = "src/main/resources/sudoku.json";
    private static Game game;
    private static Move move;
    private static Move invalidMove;

    @Before
    public void setUp() throws IOException {
        game = new GameJsonSerializer(SUDOKUJSON).deserialize();
        move = new Move(1, new CellNumerical(3, "1"));
        invalidMove = new Move(1, new CellNumerical(5, "1"));
    }

    @Test
    public void undoMoveAddsToMoveHistory() {
        game.process(move);
        game.undo();
        assertTrue(game.getMoveHistory().size() == 2);
    }

    @Test
    public void undoInvalidMoveDoesNotAddToMoveHistory() {
        game.process(invalidMove);
        game.undo();
        assertTrue(game.getMoveHistory().size() == 1);
    }


    @Test
    public void undoRemovesMoveFromAppliedMoves() {
        game.process(move);
        game.undo();
        assertTrue(game.getAppliedMovesCount() == 0);
    }

    @Test
    public void invalidMoveDoesNotAddToAppliedMoves() {
        game.process(invalidMove);
        assertTrue(game.getAppliedMovesCount() == 0);
    }

    @Test
    public void undoWhenThereAreNoPlaysDoestNothing() {
        game.undo();
        assertTrue(game.getMoveHistory().isEmpty());
    }

    @Test
    public void undoMoveIsValid() {
        game.process(move);
        game.undo();
        assertTrue(game.getMoveHistory().get(1).wasValid());
    }

    @Test
    public void appliedMovesStoresTheNumberOfCellWhereMoveWillBeApplied() {
        game.process(move);
        assertTrue(game.getIdOfLastAppliedMove() == move.getcellId());
    }

    @Test
    public void appliedMovesStoresTheValueOfTheOriginalValueOfCellWhereMoveWillBeApplied() {
        String originalValue = game.getCell(move.getcellId()).datumToString();
        game.process(move);
        assertTrue(game.getStringValueOfLastAppliedMove().equals(originalValue));
    }


}
