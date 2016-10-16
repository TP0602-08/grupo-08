package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.model.CellNumerical;
import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.model.Move;
import ar.fiuba.tdd.tp1.model.MoveHistory;
import ar.fiuba.tdd.tp1.serialization.json.GameJsonSerializer;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InshiNoHeyaTest {
    private static final String INSHINOHEYAJSON = "src/main/resources/inshinoheya.json";
    private static final String VALORREPETIDO = "Valor repetido.";
    private static final String ELPRODUCTONOESIGUAL = "El producto no es igual a ";
    private static List<Move> moves = new ArrayList<>(Arrays.asList(
            new Move(1, new CellNumerical(3, "1")),
            new Move(2, new CellNumerical(4, "2")),
            new Move(3, new CellNumerical(1, "3")),
            new Move(4, new CellNumerical(5, "4")),
            new Move(5, new CellNumerical(2, "5")),
            new Move(6, new CellNumerical(2, "6")),
            new Move(7, new CellNumerical(1, "7")),
            new Move(8, new CellNumerical(3, "8")),
            new Move(9, new CellNumerical(4, "9")),
            new Move(10, new CellNumerical(5, "10")),
            new Move(11, new CellNumerical(5, "11")),
            new Move(12, new CellNumerical(3, "12")),
            new Move(13, new CellNumerical(2, "13")),
            new Move(14, new CellNumerical(1, "14")),
            new Move(15, new CellNumerical(4, "15")),
            new Move(16, new CellNumerical(1, "16")),
            new Move(17, new CellNumerical(5, "17")),
            new Move(18, new CellNumerical(4, "18")),
            new Move(19, new CellNumerical(2, "19")),
            new Move(20, new CellNumerical(3, "20")),
            new Move(21, new CellNumerical(4, "21")),
            new Move(22, new CellNumerical(2, "22")),
            new Move(23, new CellNumerical(5, "23")),
            new Move(24, new CellNumerical(3, "24")),
            new Move(25, new CellNumerical(1, "25"))
    ));

    private static Game game;

    @Before
    public void setUp() throws IOException {
        game = new GameJsonSerializer(INSHINOHEYAJSON).deserialize();
    }

    @Test
    public void addingNonRepeatedValueCausesValidMove() {
        CellNumerical newCell = new CellNumerical(2, "1");
        Move validMove = new Move(1, newCell);
        game.process(validMove);
        assertTrue(validMove.isValid());
    }

    @Test
    public void addingRepeatedValueInRowCausesInvalidMove() {
        CellNumerical newCell = new CellNumerical(2, "2");
        Move validMove = new Move(2, newCell);
        game.process(validMove);
        CellNumerical invalidCell = new CellNumerical(2, "1");
        Move invalidMove = new Move(1, invalidCell);
        game.process(invalidMove);
        assertFalse(invalidMove.isValid());
    }

    @Test
    public void addingRepeatedValueInRowCausesNoRepeatedValuesViolation() {
        CellNumerical newCell = new CellNumerical(2, "2");
        Move validMove = new Move(2, newCell);
        game.process(validMove);
        CellNumerical invalidCell = new CellNumerical(2, "1");
        Move invalidMove = new Move(1, invalidCell);
        game.process(invalidMove);
        assertEquals(1, invalidMove.getListOfViolationsOfRules().size());
        assertTrue(invalidMove.getListOfViolationsOfRules().get(0).getExplanation().contains(VALORREPETIDO));
    }

    @Test
    public void addingRepeatedValueInColumnCausesInvalidMove() {
        CellNumerical newCell = new CellNumerical(2, "2");
        Move validMove = new Move(2, newCell);
        game.process(validMove);
        CellNumerical invalidCell = new CellNumerical(2, "7");
        Move invalidMove = new Move(7, invalidCell);
        game.process(invalidMove);
        assertFalse(invalidMove.isValid());
    }

    @Test
    public void addingRepeatedValueInColumnCausesNoRepeatedValuesViolation() {
        CellNumerical newCell = new CellNumerical(2, "2");
        Move validMove = new Move(2, newCell);
        game.process(validMove);
        CellNumerical invalidCell = new CellNumerical(2, "7");
        Move invalidMove = new Move(7, invalidCell);
        game.process(invalidMove);
        assertEquals(1, invalidMove.getListOfViolationsOfRules().size());
        assertTrue(invalidMove.getListOfViolationsOfRules().get(0).getExplanation().contains(VALORREPETIDO));
    }

    @Test
    public void fillingRegionWithNumbersThatDontMultiplyToRequiredNumberCausesInvalidMove() {
        CellNumerical newCell = new CellNumerical(3, "1");
        Move validMove = new Move(1, newCell);
        game.process(validMove);
        CellNumerical invalidCell = new CellNumerical(3, "6");
        Move invalidMove = new Move(6, invalidCell);
        game.process(invalidMove);
        assertFalse(invalidMove.isValid());
    }

    @Test
    public void fillingRegionWithNumbersThatDontMultiplyToRequiredNumberCausesTotalProductEqualsViolation() {
        CellNumerical newCell = new CellNumerical(3, "1");
        Move validMove = new Move(1, newCell);
        game.process(validMove);
        CellNumerical invalidCell = new CellNumerical(4, "6");
        Move invalidMove = new Move(6, invalidCell);
        game.process(invalidMove);
        assertEquals(1, invalidMove.getListOfViolationsOfRules().size());
        assertTrue(invalidMove.getListOfViolationsOfRules().get(0).getExplanation().contains(ELPRODUCTONOESIGUAL));
    }

    @Test
    public void fillingRegionWithDifferentNumbersThatDoMultiplyToRequiredNumberIsValid() {
        CellNumerical newCell = new CellNumerical(3, "1");
        Move validMove = new Move(1, newCell);
        game.process(validMove);
        CellNumerical validCell = new CellNumerical(2, "6");
        validMove = new Move(6, validCell);
        game.process(validMove);
        assertTrue(validMove.isValid());
    }

    @Test
    public void gameNotWonAfterBuilding() {
        assertFalse(game.isGameWon());
    }

    @Test
    public void gameNotWonAfterInvalidMove() {
        CellNumerical newCell = new CellNumerical(2, "2");
        Move validMove = new Move(2, newCell);
        game.process(validMove);
        CellNumerical invalidCell = new CellNumerical(2, "1");
        Move invalidMove = new Move(1, invalidCell);
        game.process(invalidMove);
        assertFalse(game.isGameWon());
    }

    @Test
    public void gameIsNotWonAfterValidMove() {
        CellNumerical newCell = new CellNumerical(2, "2");
        Move validMove = new Move(2, newCell);
        game.process(validMove);
        assertFalse(game.isGameWon());
    }

    @Test
    public void addingAllValidValuesAndFillingRecordsAllValidMoves() {
        game.setMoves(moves);
        game.process();
        for (MoveHistory move : game.getMoveHistory()) {
            assertTrue(move.wasValid());
        }
    }

    @Test
    public void gameIsWonAfterAllValidValuesAreInserted() {
        game.setMoves(moves);
        game.process();
        assertTrue(game.isGameWon());
    }
}
