package ar.fiuba.tdd.tp1.model;

public class PlayReport {
    private int number;
    private String boardStatus;

    public PlayReport(int playNumber,boolean boardStatus) {
        this.number = playNumber;
        if (boardStatus) {
            this.boardStatus = "valid";
        } else {
            this.boardStatus = "invalid";
        }
    }

    public int getPlayNumber() {
        return this.number;
    }

    public String getBoardStatus() {
        return this.boardStatus;
    }

    public boolean areEquals(PlayReport playReportToCompare) {
        return ((this.boardStatus.equals(playReportToCompare.boardStatus)) && (this.number == playReportToCompare.number));
    }

    //TODO ivan revisar porque esta comparacion no anda
   /* public boolean equals(Object playReportToCompare) {
        return playReportToCompare.equals(this);
    }

    public boolean equals(PlayReport playReportToCompare) {
        return true;//this.number == playReportToCompare.number && this.boardStatus.equals(playReportToCompare.boardStatus);
    }*/
}
