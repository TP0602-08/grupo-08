package ar.fiuba.tdd.tp1.serialization;

import ar.fiuba.tdd.tp1.model.Board;
import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.model.Rule;
import ar.fiuba.tdd.tp1.model.Rulebook;
import ar.fiuba.tdd.tp1.serialization.json.GameJsonSerializer;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameJsonSerializerTest {
    private static final String GAMEJSON = "src/main/resources/kakuro.json";
    private static final int ROWS = 10;
    private static final int COLUMNS = 12;
    private static final int REGIONS = 48;
    private static final String REGION1 = "r1";
    private static final int REGION1CELLS = 2;
    private static final int REGION1CELL1ID = 15;
    private static final int REGION1CELL2ID = 16;
    private static final int RULES = 96;
    private static final int TOTALSUMEQUALS = 48;
    private static final int NOREPEATEDVALUES = 48;
    private static Game game;

    @BeforeClass
    public static void setUpBeforeClass() throws IOException {
        game = new GameJsonSerializer(GAMEJSON).deserialize();
    }

    @Test
    public void gameHasCorrectRows() {
        assertEquals(game.getBoard().getRowQuantity(), ROWS);
    }

    @Test
    public void gameHasCorrectColumns() {
        assertEquals(game.getBoard().getColumnQuantity(), COLUMNS);
    }

    @Test
    public void gameHasCorrectNumberOfCells() {
        assertEquals(((Board)game.getBoard()).getNumberOfCells(), ROWS * COLUMNS);
    }

    @Test
    public void gameHasCorrectNumberOfRegions() {
        assertEquals(((Board)game.getBoard()).getNumberOfRegions(), REGIONS);
    }

    @Test
    public void gameRegionsHaveCorrectNumberOfCells() {
        List<Integer> regionCells = game.getCellsIdInRegion(REGION1);
        assertEquals(regionCells.size(), REGION1CELLS);
        assertEquals(regionCells.get(0).intValue(), REGION1CELL1ID);
        assertEquals(regionCells.get(1).intValue(), REGION1CELL2ID);
    }

    @Test
    public void gameHasCorrectNumberOfRules() {
        Rulebook rules = game.getRulebook();
        assertEquals(rules.getRulesList().size(), RULES);
    }

    @Test
    public void gameHasCorrectTypeOfRules() {
        int totalSumEquals = 0;
        int noRepeatedValues = 0;
        for (Rule rule : game.getRulebook().getRulesList()) {
            if (rule.getName().equals("TotalSumEquals")) {
                totalSumEquals++;
            }
            if (rule.getName().equals("NoRepeatedValues")) {
                noRepeatedValues++;
            }
        }
        assertEquals(totalSumEquals, TOTALSUMEQUALS);
        assertEquals(noRepeatedValues, NOREPEATEDVALUES);
    }
}
