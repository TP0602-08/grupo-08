package ar.fiuba.tdd.tp1.model;



import java.util.LinkedList;
import java.util.List;

public class GameReport {
    private List<PlayReport> plays;

    public GameReport(List<MoveHistory> movesHistory) {
        int playNumber = 1;
        plays = new LinkedList<>();
        for (MoveHistory moveHistory: movesHistory) {
            plays.add(new PlayReport(playNumber, moveHistory.wasValid()));
            playNumber++;
        }
    }

    public boolean comparePlays(GameReport gameReportToCompare) {

        for (int i = 0; i < this.plays.size() ; i++) {
            if (! this.plays.get(i).areEquals(gameReportToCompare.plays.get(i))) {
                return false;
            }

        }
        return true;
    }


}
