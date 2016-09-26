package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.Rule;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

import java.util.List;

public class RuleNoRepeatedValues implements Rule, VisitorOfCell {
    private static final String name = "NoRepeatedValues";
    private Board board;
    private String regionId;

    //This constructor is for using an instance as a prototype for creating new instances.
    public RuleNoRepeatedValues(Board boardValue) {
        this.board = boardValue;
        this.regionId = null;
    }

    //Regular constructor.
    public RuleNoRepeatedValues(Board boardValue, String regionIdValue) {
        this.board = boardValue;
        this.regionId = regionIdValue;
    }

    //Constructor with list of Objects as parameters.
    @Deprecated
    public RuleNoRepeatedValues(Board boardValue, List<Object> parametersList) {
        this.board = boardValue;
        this.regionId = (String) parametersList.get(0);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isValid(Move move) {
        //TODO(Ivan)
        return true;
    }

    @Override
    public RuleNoRepeatedValues createNewInstance(List<Object> parametersList) {
        String newRegionId = (String) parametersList.get(0);
        RuleNoRepeatedValues newInstance = new RuleNoRepeatedValues(this.board, newRegionId);
        return newInstance;
    }

    @Override
    public void visit(CellAlphabetical cell) {
        //TODO(Ivan)
    }

    @Override
    public void visit(CellNumerical cell) {
        //TODO(Ivan)
    }

    //TODO(Ivan) Este método tal vez hay que volarlo.
    public String getRegionId() {
        return regionId;
    }
}
