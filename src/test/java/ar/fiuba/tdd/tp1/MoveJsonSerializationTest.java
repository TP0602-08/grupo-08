package ar.fiuba.tdd.tp1;

import com.google.gson.Gson;

import ar.fiuba.tdd.tp1.model.BoardRectangularWithRegions;
import ar.fiuba.tdd.tp1.model.CellNumerical;
import ar.fiuba.tdd.tp1.model.Move;
import ar.fiuba.tdd.tp1.serialization.json.MoveJson;
import ar.fiuba.tdd.tp1.serialization.json.MovesJson;
import ar.fiuba.tdd.tp1.serialization.json.MovesJsonSerializer;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class MoveJsonSerializationTest {
    private static final String PLAYS = "src/main/resources/plays.json";
    private static final String PLAY = "src/test/resources/play.json";
    private static final int NUMBER = 1;
    private static final int[] POSITION = new int[] {1,1};
    private static final String VALUE = "3";
    private static final int SIZE = 4;
    private static final int INT_ZERO = 0;
    private static final int INT_ONE = 1;
    private static final int INT_TWO = 2;
    private static final int INT_THREE = 2;

    private static String playJson;
    private static String playsJson;
    private static BoardRectangularWithRegions board;

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    @BeforeClass
    public static void setUpBeforeClass() throws IOException {
        playJson = readFile(PLAY, StandardCharsets.UTF_8);
        playsJson = readFile(PLAYS, StandardCharsets.UTF_8);
        board = Mockito.mock(BoardRectangularWithRegions.class);
        Mockito.when(board.getCellByCoordinates(0,0)).thenReturn(new CellNumerical(0, "0"));
        Mockito.when(board.getCellByCoordinates(0,1)).thenReturn(new CellNumerical(0, "1"));
        Mockito.when(board.getCellByCoordinates(0,2)).thenReturn(new CellNumerical(0, "2"));
        Mockito.when(board.getCellByCoordinates(0,2)).thenReturn(new CellNumerical(0, "2"));
        Mockito.when(board.computeCellId(0,0)).thenReturn(0);
        Mockito.when(board.computeCellId(0,1)).thenReturn(1);
        Mockito.when(board.computeCellId(0,2)).thenReturn(2);
        Mockito.when(board.computeCellId(0,3)).thenReturn(3);
    }

    @Test
    public void canDeserializeSimplePlay() {
        Gson gson = new Gson();
        MoveJson move = gson.fromJson(playJson, MoveJson.class);
        assertTrue(true);
    }

    @Test
    public void deserializeNumber() {
        Gson gson = new Gson();
        MoveJson move = gson.fromJson(playJson, MoveJson.class);
        assertEquals(move.getNumber(), NUMBER);
    }

    @Test
    public void deserializePosition() {
        Gson gson = new Gson();
        MoveJson move = gson.fromJson(playJson, MoveJson.class);
        assertEquals(move.getPosition()[0], POSITION[0]);
        assertEquals(move.getPosition()[1], POSITION[1]);
    }

    @Test
    public void deserializeValue() {
        Gson gson = new Gson();
        MoveJson move = gson.fromJson(playJson, MoveJson.class);
        assertEquals(move.getValue(), VALUE);
    }

    @Test
    public void canDeserializePlays() {
        Gson gson = new Gson();
        MovesJson moves = gson.fromJson(playsJson, MovesJson.class);
        assertTrue(true);
    }

    @Test
    public void deserializesAllPlays() {
        Gson gson = new Gson();
        MovesJson moves = gson.fromJson(playsJson, MovesJson.class);
        assertEquals(moves.getMoves().size(), SIZE);
    }

    @Test
    public void deserializedPlaysHaveNonNullValues() {
        Gson gson = new Gson();
        MovesJson moves = gson.fromJson(playsJson, MovesJson.class);
        for (MoveJson move: moves.getMoves()) {
            assertNotEquals(move.getNumber(), 0);
            assertNotEquals(move.getPosition(), null);
            assertNotEquals(move.getValue(), null);
        }
    }

    @Test
    public void deserializeToMovesFinal() throws IOException {
        MovesJsonSerializer serializer = new MovesJsonSerializer(PLAYS, board);
        List<Move> moves = serializer.deserialize();
        assertTrue(true);
    }

    @Test
    public void deserializedMovesHaveSameNumberOfMovesAsJson() throws IOException {
        MovesJsonSerializer serializer = new MovesJsonSerializer(PLAYS, board);
        List<Move> moves = serializer.deserialize();
        assertEquals(moves.size(), SIZE);
    }

    @Test
    public void deserializedMovesHaveDeterminedIds() throws IOException {
        MovesJsonSerializer serializer = new MovesJsonSerializer(PLAYS, board);
        List<Move> moves = serializer.deserialize();
        assertEquals(moves.get(0).getcellId().intValue(), INT_ZERO);
        assertEquals(moves.get(1).getcellId().intValue(), INT_ONE);
        assertEquals(moves.get(2).getcellId().intValue(), INT_TWO);
        assertEquals(moves.get(3).getcellId().intValue(), INT_THREE);
    }
}
