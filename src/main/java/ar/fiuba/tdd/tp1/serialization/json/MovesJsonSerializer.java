package ar.fiuba.tdd.tp1.serialization.json;

import com.google.gson.Gson;

import ar.fiuba.tdd.tp1.model.*;
import ar.fiuba.tdd.tp1.serialization.interfaces.MovesSerializer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MovesJsonSerializer implements MovesSerializer {
    private MovesJson movesJson;
    private BoardRectangularWithRegions board;

    public MovesJsonSerializer(String path, BoardRectangularWithRegions board) throws IOException {
        Gson gson = new Gson();
        this.movesJson = gson.fromJson(getJson(path), MovesJson.class);
        this.board = board;
    }

    public List<Move> deserialize() {
        List<Move> moves = new ArrayList<>();
        for (MoveJson move : this.movesJson.getMoves()) {
            moves.add(mapMoveJsonToMove(move));
        }
        return moves;
    }

    private Move mapMoveJsonToMove(MoveJson moveJson) {
        Cell cell = MoveCellSerializer.deserializeCell(this.board, moveJson);
        Move move = new Move(this.board.computeCellId(moveJson.getPosition()[0] - 1, moveJson.getPosition()[1] - 1), cell);
        return move;
    }

    private String getJson(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }
}
