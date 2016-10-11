package ar.fiuba.tdd.tp1.serialization.json;

import java.util.List;

public class GameJson {
    private List<RuleJson> rulebook;
    private BoardJson board;
    private List<String> validInputs;

    public List<RuleJson> getRulebook() {
        return this.rulebook;
    }

    public BoardJson getBoard() {
        return this.board;
    }

    public List<String> getValidInputs() {
        return this.validInputs;
    }

    public void setRulebook(List<RuleJson> rules) {
        this.rulebook = rules;
    }

    public void setBoard(BoardJson board) {
        this.board = board;
    }

    public void setValidInputs(List<String> validInputs) {
        this.validInputs = validInputs;
    }
}
