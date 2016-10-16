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

public class KakuroTest {
    private static final String KAKUROJSON = "src/main/resources/kakuro.json";
    private static final String VALORREPETIDO = "Valor repetido.";
    private static final String LASUMANOESIGUALA = "La suma no es igual a ";
    private static final String INVALIDMOVEJSON = "src/test/resources/invalidKakuroMove.json";
    private static final String VALIDMOVEJSON = "src/test/resources/validKakuroPlay.json";
    private static final String WINGAMEKAKUROJSON = "src/test/resources/winGameKakuro.json";

    private static Game game;
    private static  List<Move> moves = new ArrayList<>(Arrays.asList(
            new Move(15, new CellNumerical(4, "15")),
            new Move(16, new CellNumerical(3, "16")),
            new Move(18, new CellNumerical(1, "18")),
            new Move(19, new CellNumerical(3, "19")),
            new Move(20, new CellNumerical(5, "20")),
            new Move(23, new CellNumerical(3, "23")),
            new Move(24, new CellNumerical(1, "24")),
            new Move(26, new CellNumerical(4, "26")),
            new Move(27, new CellNumerical(2, "27")),
            new Move(28, new CellNumerical(1, "28")),
            new Move(30, new CellNumerical(2, "30")),
            new Move(31, new CellNumerical(1, "31")),
            new Move(32, new CellNumerical(4, "32")),
            new Move(34, new CellNumerical(3, "34")),
            new Move(35, new CellNumerical(1, "35")),
            new Move(36, new CellNumerical(2, "36")),
            new Move(38, new CellNumerical(2, "38")),
            new Move(39, new CellNumerical(1, "39")),
            new Move(41, new CellNumerical(1, "41")),
            new Move(42, new CellNumerical(3, "42")),
            new Move(44, new CellNumerical(3, "44")),
            new Move(45, new CellNumerical(1, "45")),
            new Move(46, new CellNumerical(6, "46")),
            new Move(47, new CellNumerical(2, "47")),
            new Move(48, new CellNumerical(4, "48")),
            new Move(50, new CellNumerical(1, "50")),
            new Move(51, new CellNumerical(3, "51")),
            new Move(52, new CellNumerical(2, "52")),
            new Move(53, new CellNumerical(4, "53")),
            new Move(55, new CellNumerical(3, "55")),
            new Move(56, new CellNumerical(1, "56")),
            new Move(57, new CellNumerical(2, "57")),
            new Move(58, new CellNumerical(4, "58")),
            new Move(63, new CellNumerical(6, "63")),
            new Move(64, new CellNumerical(4, "64")),
            new Move(66, new CellNumerical(3, "66")),
            new Move(67, new CellNumerical(1, "67")),
            new Move(68, new CellNumerical(2, "68")),
            new Move(70, new CellNumerical(1, "70")),
            new Move(71, new CellNumerical(4, "71")),
            new Move(76, new CellNumerical(3, "76")),
            new Move(77, new CellNumerical(1, "77")),
            new Move(78, new CellNumerical(2, "78")),
            new Move(79, new CellNumerical(4, "79")),
            new Move(81, new CellNumerical(1, "81")),
            new Move(82, new CellNumerical(2, "82")),
            new Move(83, new CellNumerical(5, "83")),
            new Move(84, new CellNumerical(4, "84")),
            new Move(86, new CellNumerical(3, "86")),
            new Move(87, new CellNumerical(1, "87")),
            new Move(88, new CellNumerical(6, "88")),
            new Move(89, new CellNumerical(2, "89")),
            new Move(90, new CellNumerical(4, "90")),
            new Move(92, new CellNumerical(1, "92")),
            new Move(93, new CellNumerical(3, "93")),
            new Move(95, new CellNumerical(3, "95")),
            new Move(96, new CellNumerical(1, "96")),
            new Move(98, new CellNumerical(2, "98")),
            new Move(99, new CellNumerical(4, "99")),
            new Move(100, new CellNumerical(1, "100")),
            new Move(102, new CellNumerical(5, "102")),
            new Move(103, new CellNumerical(1, "103")),
            new Move(104, new CellNumerical(2, "104")),
            new Move(106, new CellNumerical(3, "106")),
            new Move(107, new CellNumerical(1, "107")),
            new Move(108, new CellNumerical(2, "108")),
            new Move(110, new CellNumerical(1, "110")),
            new Move(111, new CellNumerical(2, "111")),
            new Move(114, new CellNumerical(1, "114")),
            new Move(115, new CellNumerical(2, "115")),
            new Move(116, new CellNumerical(4, "116")),
            new Move(118, new CellNumerical(1, "118")),
            new Move(119, new CellNumerical(2, "119"))
    ));

    @Before
    public void setUp() throws IOException {
        game = new GameJsonSerializer(KAKUROJSON).deserialize();
    }

    @Test
    public void addingRepeatedValueInRegionCausesInvalidMove() {
        CellNumerical newCell = new CellNumerical(2, "15");
        Move validMove = new Move(15, newCell);
        game.process(validMove);
        newCell = new CellNumerical(2, "27");
        Move invalidMove = new Move(27, newCell);
        game.process(invalidMove);
        assertFalse(invalidMove.isValid());
    }

    @Test
    public void addingRepeatedValueInRegionCausesNoRepeatedValuesViolation() {
        CellNumerical newCell = new CellNumerical(2, "15");
        Move validMove = new Move(15, newCell);
        game.process(validMove);
        newCell = new CellNumerical(2, "27");
        Move invalidMove = new Move(27, newCell);
        game.process(invalidMove);
        assertEquals(1, invalidMove.getListOfViolationsOfRules().size());
        assertTrue(invalidMove.getListOfViolationsOfRules().get(0).getExplanation().contains(VALORREPETIDO));
    }

    @Test
    public void fillingRegionWithDifferentNumbersThatDontAddUpToRequiredSumCausesInvalidMove() {
        CellNumerical newCell = new CellNumerical(2, "15");
        Move validMove = new Move(15, newCell);
        game.process(validMove);
        newCell = new CellNumerical(3, "16");
        Move invalidMove = new Move(16, newCell);
        game.process(invalidMove);
        assertFalse(invalidMove.isValid());
    }

    @Test
    public void fillingRegionWithDifferentNumbersThatDontAddUpToRequiredSumCausesTotalSumEqualsViolation() {
        CellNumerical newCell = new CellNumerical(2, "15");
        Move validMove = new Move(15, newCell);
        game.process(validMove);
        newCell = new CellNumerical(3, "16");
        Move invalidMove = new Move(16, newCell);
        game.process(invalidMove);
        assertEquals(1, invalidMove.getListOfViolationsOfRules().size());
        assertTrue(invalidMove.getListOfViolationsOfRules().get(0).getExplanation().contains(LASUMANOESIGUALA));
    }

    @Test
    public void addingDifferentValuesThatDontAddUpToRequiredSumWithoutFillingRegionDoesntCauseInvalidMove() {
        CellNumerical newCell = new CellNumerical(2, "15");
        Move validMove = new Move(15, newCell);
        game.process(validMove);
        newCell = new CellNumerical(3, "27");
        validMove = new Move(27, newCell);
        game.process(validMove);
        assertTrue(validMove.isValid());
    }

    @Test
    public void addingDifferentValuesThatAddUpToRequiredSumDoesntCauseInvalidMove() {
        CellNumerical newCell = new CellNumerical(4, "15");
        Move validMove = new Move(15, newCell);
        game.process(validMove);
        newCell = new CellNumerical(3, "16");
        validMove = new Move(16, newCell);
        game.process(validMove);
        assertTrue(validMove.isValid());
    }

    @Test
    public void gameIsNotWonAfterValidMove() {
        CellNumerical newCell = new CellNumerical(4, "15");
        Move validMove = new Move(15, newCell);
        game.process(validMove);
        assertFalse(game.isGameWon());
    }

    @Test
    public void gameIsNotWonAfterInvalidMove() {
        CellNumerical newCell = new CellNumerical(2, "15");
        Move validMove = new Move(15, newCell);
        game.process(validMove);
        newCell = new CellNumerical(3, "16");
        Move invalidMove = new Move(16, newCell);
        game.process(invalidMove);
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
    public void gameIsWonAfterEnteringAllValidValues() {
        game.setMoves(moves);
        game.process();
        assertTrue(game.isGameWon());
    }

    @Test
    public void invalidPlayFromFileCausesInvalidMove() throws IOException {
        game = new GameJsonSerializer(KAKUROJSON, INVALIDMOVEJSON).deserialize();
        game.process();
        assertFalse(game.getMoveHistory().get(1).wasValid());
    }

    @Test
    public void validPlayFromFileCausesInvalidMove() throws IOException {
        game = new GameJsonSerializer(KAKUROJSON, VALIDMOVEJSON).deserialize();
        game.process();
        assertTrue(game.getMoveHistory().get(0).wasValid());
        assertTrue(game.getMoveHistory().get(1).wasValid());
    }

    @Test
    public void allValidPlaysFromFileCausesValidMovesAndGameWon() throws IOException {
        game = new GameJsonSerializer(KAKUROJSON, WINGAMEKAKUROJSON).deserialize();
        game.process();
        for (MoveHistory move : game.getMoveHistory()) {
            assertTrue(move.wasValid());
        }
        assertTrue(game.isGameWon());
    }
}
