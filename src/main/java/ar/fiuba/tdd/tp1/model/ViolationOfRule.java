package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Cell;

import java.util.List;

public class ViolationOfRule {
    private String explanation;
    private List<Cell> conflictingCellsList;

    public ViolationOfRule(String explanationValue, List<Cell> conflictingCellsListValue) {
        //TODO(Ivan) Ver si está bien "pasarle" los objetos así, o si necesita hacer copias de las listas, mapas y sus elementos.
        this.explanation = explanationValue;
        this.conflictingCellsList = conflictingCellsListValue;
    }

    //TODO(Ivan) Este método tal vez hay que volarlo.
    public String getExplanation() {
        return explanation;
    }

    //TODO(Ivan) Este método tal vez hay que volarlo.
    public List<Cell> getConflictingCellsList() {
        return conflictingCellsList;
    }
}
