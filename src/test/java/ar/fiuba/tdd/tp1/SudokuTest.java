package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.model.*;
import ar.fiuba.tdd.tp1.serialization.json.GameJsonSerializer;
import ar.fiuba.tdd.tp1.serialization.json.GameReportJsonSerializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SudokuTest {
    private static final String SUDOKUJSON = "src/main/resources/sudoku.json";
    private static final String VALORREPETIDO = "Valor repetido.";
    private static final String INVALIDPLAYJSON = "src/test/resources/invalidSudokuPlay.json";
    private static final String VALIDPLAYJSON = "src/test/resources/validSudokuPlay.json";
    private static final String SUDOKUOUTPUTJSON = "src/test/resources/sudokuOutput.json";
    private static final String WINGAMESUDOKU = "src/test/resources/winGameSudoku.json";

    private static Game game;
    private static List<Move> moves = new ArrayList<>(Arrays.asList(
            new Move(1, new CellNumerical(3, "1")),
            new Move(2, new CellNumerical(1, "2")),
            new Move(4, new CellNumerical(5, "4")),
            new Move(6, new CellNumerical(8, "6")),
            new Move(7, new CellNumerical(7, "7")),
            new Move(9, new CellNumerical(4, "9")),
            new Move(10, new CellNumerical(9, "10")),
            new Move(12, new CellNumerical(6, "12")),
            new Move(13, new CellNumerical(7, "13")),
            new Move(14, new CellNumerical(3, "14")),
            new Move(16, new CellNumerical(2, "16")),
            new Move(17, new CellNumerical(5, "17")),
            new Move(19, new CellNumerical(8, "19")),
            new Move(21, new CellNumerical(5, "21")),
            new Move(24, new CellNumerical(6, "24")),
            new Move(25, new CellNumerical(9, "25")),
            new Move(26, new CellNumerical(1, "26")),
            new Move(29, new CellNumerical(6, "29")),
            new Move(30, new CellNumerical(7, "30")),
            new Move(31, new CellNumerical(8, "31")),
            new Move(32, new CellNumerical(4, "32")),
            new Move(33, new CellNumerical(2, "33")),
            new Move(35, new CellNumerical(9, "35")),
            new Move(36, new CellNumerical(1, "36")),
            new Move(37, new CellNumerical(4, "37")),
            new Move(38, new CellNumerical(8, "38")),
            new Move(40, new CellNumerical(3, "40")),
            new Move(42, new CellNumerical(9, "42")),
            new Move(44, new CellNumerical(7, "44")),
            new Move(45, new CellNumerical(2, "45")),
            new Move(46, new CellNumerical(2, "46")),
            new Move(47, new CellNumerical(9, "47")),
            new Move(49, new CellNumerical(1, "49")),
            new Move(50, new CellNumerical(7, "50")),
            new Move(51, new CellNumerical(5, "51")),
            new Move(52, new CellNumerical(4, "52")),
            new Move(53, new CellNumerical(8, "53")),
            new Move(56, new CellNumerical(3, "56")),
            new Move(57, new CellNumerical(8, "57")),
            new Move(58, new CellNumerical(2, "58")),
            new Move(61, new CellNumerical(6, "61")),
            new Move(63, new CellNumerical(9, "63")),
            new Move(65, new CellNumerical(5, "65")),
            new Move(66, new CellNumerical(4, "66")),
            new Move(68, new CellNumerical(1, "68")),
            new Move(69, new CellNumerical(3, "69")),
            new Move(70, new CellNumerical(8, "70")),
            new Move(72, new CellNumerical(7, "72")),
            new Move(73, new CellNumerical(7, "73")),
            new Move(75, new CellNumerical(9, "75")),
            new Move(76, new CellNumerical(6, "76")),
            new Move(78, new CellNumerical(4, "78")),
            new Move(80, new CellNumerical(3, "80")),
            new Move(81, new CellNumerical(5, "81"))
    ));

    @Before
    public void setUp() throws IOException {
        game = new GameJsonSerializer(SUDOKUJSON).deserialize();
    }

    @Test
    public void addingRepeatedValueInRegionCausesInvalidMove() {
        CellNumerical newCell = new CellNumerical(2, "10");
        Move invalidMove = new Move(10, newCell);
        game.process(invalidMove);
        assertFalse(invalidMove.isValid());
    }

    @Test
    public void addingRepeatedValueInRegionCausesNoRepeatedValuesViolation() {
        CellNumerical newCell = new CellNumerical(2, "10");
        Move invalidMove = new Move(10, newCell);
        game.process(invalidMove);
        assertEquals(1, invalidMove.getListOfViolationsOfRules().size());
        assertTrue(invalidMove.getListOfViolationsOfRules().get(0).getExplanation().contains(VALORREPETIDO));
    }

    @Test
    public void addingRepeatedValueInRegionAppearsAsInvalidMoveInMoveHistory() {
        CellNumerical newCell = new CellNumerical(2, "10");
        Move invalidMove = new Move(10, newCell);
        game.process(invalidMove);
        assertFalse(game.getMoveHistory().get(0).wasValid());
    }

    @Test
    public void addingRepeatedValueInRowCausesInvalidMove() {
        CellNumerical newCell = new CellNumerical(9, "1");
        Move invalidMove = new Move(1, newCell);
        game.process(invalidMove);
        assertFalse(invalidMove.isValid());
    }

    @Test
    public void addingRepeatedValueInRowCausesNoRepeatedValuesViolation() {
        CellNumerical newCell = new CellNumerical(9, "1");
        Move invalidMove = new Move(1, newCell);
        game.process(invalidMove);
        assertEquals(1, invalidMove.getListOfViolationsOfRules().size());
        assertTrue(invalidMove.getListOfViolationsOfRules().get(0).getExplanation().contains(VALORREPETIDO));
    }

    @Test
    public void addingRepeatedValueInRowAppearsAsInvalidMoveInMoveHistory() {
        CellNumerical newCell = new CellNumerical(9, "1");
        Move invalidMove = new Move(1, newCell);
        game.process(invalidMove);
        assertFalse(game.getMoveHistory().get(0).wasValid());
    }

    @Test
    public void addingRepeatedValueInColumnCausesInvalidMove() {
        CellNumerical newCell = new CellNumerical(5, "1");
        Move invalidMove = new Move(1, newCell);
        game.process(invalidMove);
        assertFalse(invalidMove.isValid());
    }

    @Test
    public void addingRepeatedValueInColumnCausesNoRepeatedValuesViolation() {
        CellNumerical newCell = new CellNumerical(5, "1");
        Move invalidMove = new Move(1, newCell);
        game.process(invalidMove);
        assertEquals(1, invalidMove.getListOfViolationsOfRules().size());
        assertTrue(invalidMove.getListOfViolationsOfRules().get(0).getExplanation().contains(VALORREPETIDO));
    }

    @Test
    public void addingRepeatedValueInColumnAppearsAsInvalidMoveInMoveHistory() {
        CellNumerical newCell = new CellNumerical(5, "1");
        Move invalidMove = new Move(1, newCell);
        game.process(invalidMove);
        assertFalse(game.getMoveHistory().get(0).wasValid());
    }

    @Test
    public void addingNonRepeatedValueIsValidMove() {
        CellNumerical newCell = new CellNumerical(8, "1");
        Move validMove = new Move(1, newCell);
        game.process(validMove);
        assertTrue(validMove.isValid());
    }

    @Test
    public void addingNonRepeatedValueCausesNoViolations() {
        CellNumerical newCell = new CellNumerical(8, "1");
        Move validMove = new Move(1, newCell);
        game.process(validMove);
        assertEquals(0, validMove.getListOfViolationsOfRules().size());
    }

    @Test
    public void addingNonRepeatedValueAppearsAsValidMoveInMoveHistory() {
        CellNumerical newCell = new CellNumerical(8, "1");
        Move validMove = new Move(1, newCell);
        game.process(validMove);
        assertTrue(game.getMoveHistory().get(0).wasValid());
    }

    @Test
    public void gameIsNotWonAfterValidMove() {
        CellNumerical newCell = new CellNumerical(8, "1");
        Move validMove = new Move(1, newCell);
        game.process(validMove);
        assertFalse(game.isGameWon());
    }

    @Test
    public void gameIsNotWonAfterInvalidMove() {
        CellNumerical newCell = new CellNumerical(5, "1");
        Move invalidMove = new Move(1, newCell);
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
    public void gameIsWonAfterEnteringAllValidMoves() {
        game.setMoves(moves);
        game.process();
        List<MoveHistory> moveHistory = game.getMoveHistory();
        GameReportJsonSerializer gameReport = new GameReportJsonSerializer(new GameReport(moveHistory), game.getBoardReport());
        gameReport.serialize(SUDOKUOUTPUTJSON);
        assertTrue(game.isGameWon());
    }

    @Test
    public void invalidPlayFromFileCausesInvalidMove() throws IOException {
        game = new GameJsonSerializer(SUDOKUJSON, INVALIDPLAYJSON).deserialize();
        game.process();
        assertFalse(game.getMoveHistory().get(0).wasValid());
    }

    @Test
    public void validPlayFromFileCausesValidMove() throws IOException {
        game = new GameJsonSerializer(SUDOKUJSON, VALIDPLAYJSON).deserialize();
        game.process();
        assertTrue(game.getMoveHistory().get(0).wasValid());
    }

    @Test
    public void allValidPlaysFromFileCausesValidMovesAndGameWon() throws IOException {
        game = new GameJsonSerializer(SUDOKUJSON, WINGAMESUDOKU).deserialize();
        game.process();
        for (MoveHistory move : game.getMoveHistory()) {
            assertTrue(move.wasValid());
        }
        assertTrue(game.isGameWon());
    }

    @Test
    public void deserializedGameReturnsCorrectListOfInputs() {
        List<String> validInputs = game.getValidInputs();
        List<String> expectedInputs = new LinkedList<>();
        for (int i = 1 ; i < 10 ; i++) {
            expectedInputs.add(Integer.toString(i));
        }
        assertNotNull(validInputs);
        assertTrue(validInputs.size() == expectedInputs.size());
        assertTrue(validInputs.equals(expectedInputs));
    }

    @Test
    public void undoMoveInWonGameMakesGameNotWon() {
        game.setMoves(moves);
        game.process();
        assertTrue(game.isGameWon());
        game.undo();
        assertFalse(game.isGameWon());

    }

    @After
    public void cleanUp() {
        File file = new File(SUDOKUOUTPUTJSON);
        file.delete();
    }

}
