package ar.fiuba.tdd.tp1.model;

public class MoveHistory {
    private Move move;
    private Boolean valid;

    public MoveHistory() {

    }

    public MoveHistory(Move move, Boolean valid) {
        this.move = move;
        this.valid = valid;
    }

    public Move getMove() {
        return this.move;
    }

    public Boolean wasValid() {
        return this.valid;
    }
}
