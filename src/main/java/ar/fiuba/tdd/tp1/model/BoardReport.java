package ar.fiuba.tdd.tp1.model;

import java.util.List;

public class BoardReport {

    private String status;
    private List<BoardValue> values;

    public BoardReport(boolean status, List<BoardValue> values) {

        if (status) {
            this.status = "valid";
        } else {
            this.status = "invalid";
        }
        this.values = values;
    }

    public String getStatus() {
        return this.status;
    }

    public List<BoardValue> getValues() {
        return this.values;
    }

    public boolean compareValues(BoardReport boardReportToCompare) {

        if (! this.status.equals(boardReportToCompare.status) ) {
            return false;
        }

        for (int i = 0; i < this.getValues().size() ; i++) {
            if ( !this.getValues().get(i).compareValue(boardReportToCompare.getValues().get(i))) {
                return false;
            }
        }
        return true;
    }

}
