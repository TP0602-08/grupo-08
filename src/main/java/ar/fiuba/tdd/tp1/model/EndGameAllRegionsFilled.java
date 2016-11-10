package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.EndGameCondition;

import java.util.List;
import java.util.stream.Collectors;

public class EndGameAllRegionsFilled implements EndGameCondition {
    //TODO: probablemente se debería poner BLACK en alguna clase de Resources o algo así
    private static final String BLACK = "black";

    @Override
    public Boolean validate(Board board) {
        for (String regionId : board.getRegionsMap().keySet()) {
            List<CellAlphabetical> regionsCells = board.getCellsListFromRegionId(regionId)
                    .stream().map(x -> (CellAlphabetical)x).collect(Collectors.toList());
            if (regionsCells.stream().filter(x -> x.getDatum().equals(BLACK)).count() != 2) {
                return false;
            }
        }
        return true;
    }
}
