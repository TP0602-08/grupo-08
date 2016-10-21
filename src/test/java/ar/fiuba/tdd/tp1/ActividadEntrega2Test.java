package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.model.BoardReport;
import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.model.GameReport;
import ar.fiuba.tdd.tp1.model.MoveHistory;
import ar.fiuba.tdd.tp1.serialization.json.GameJsonSerializer;
import ar.fiuba.tdd.tp1.serialization.json.GameReportJson;
import ar.fiuba.tdd.tp1.serialization.json.GameReportJsonSerializer;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class ActividadEntrega2Test {

    private static final String INSHINOHEYAJSON = "src/main/resources/inshinoheya.json";
    private static final String INSHINOHEYAMOVESJSON = "src/test/resources/actividad2InshiNoHeya.json";
    private static final String JSONOUTPUT = "src/test/resources/actividad2InshiNoHeyaOutput.json";
    private static final String JSONOUTPUTENUNCIADO = "src/test/resources/actividad2InshiNoHeyaOutputEnunciado.json";

    private static final String GOKIGENNANAMEJSON = "src/main/resources/gokigenNaname.json";
    private static final String GOKIGENNANAMEMOVESJSON = "src/test/resources/actividad2GokigenNaname.json";

    private Game game;

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    @Test
    public void inshiNoHeyaActividad2Test() throws IOException {
        game = new GameJsonSerializer(INSHINOHEYAJSON, INSHINOHEYAMOVESJSON).deserialize();
        game.process();
        List<MoveHistory> moveHistory = game.getMoveHistory();
        GameReportJsonSerializer gameReportJsonSerializer = new GameReportJsonSerializer(new GameReport(moveHistory),
                game.getBoardReport());
        gameReportJsonSerializer.serialize(JSONOUTPUT);
        String report =  readFile(JSONOUTPUT, StandardCharsets.UTF_8);
        GameReportJson gameReportJson = gameReportJsonSerializer.deserialize(report);
        GameReport gameReport = gameReportJson.getGameReport();
        BoardReport boardReport = gameReportJson.getBoardReport();

        String reportEnunciado =  readFile(JSONOUTPUTENUNCIADO, StandardCharsets.UTF_8);
        GameReportJson gameReportJsonEnunciado = gameReportJsonSerializer.deserialize(reportEnunciado);
        GameReport gameReportEnunciado = gameReportJsonEnunciado.getGameReport();
        BoardReport boardReportEnunciado = gameReportJsonEnunciado.getBoardReport();

        assertTrue(gameReport.comparePlays(gameReportEnunciado));
        assertTrue(boardReport.compareValues(boardReportEnunciado));

        File file = new File(JSONOUTPUT);
        file.delete();
    }



    @Test
    public void gokikenNanameActividad2Test() throws IOException {
        game = new GameJsonSerializer(GOKIGENNANAMEJSON, GOKIGENNANAMEMOVESJSON).deserialize();
        game.process();
        List<MoveHistory> moveHistory = game.getMoveHistory();
        for (MoveHistory move : moveHistory) {
            assertTrue(move.wasValid());
        }
        assertTrue(game.isGameWon());
    }
}
