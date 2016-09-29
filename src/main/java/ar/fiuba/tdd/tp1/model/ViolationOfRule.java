package ar.fiuba.tdd.tp1.model;

import java.util.List;

public class ViolationOfRule {
    private String explanation;
    private List<Integer> conflictingCellIdsList;

    public ViolationOfRule(String explanationValue, List<Integer> conflictingCellIdsListValue) {
        this.explanation = explanationValue;
        this.conflictingCellIdsList = conflictingCellIdsListValue;
    }

    public String getExplanation() {
        return explanation;
    }

    public List<Integer> getConflictingCellsList() {
        return conflictingCellIdsList;
    }
}
