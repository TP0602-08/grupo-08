package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Board;
import ar.fiuba.tdd.tp1.model.interfaces.Rule;
import ar.fiuba.tdd.tp1.model.interfaces.VisitorOfCell;

import java.util.List;

public class RuleTotalSumEquals implements Rule, VisitorOfCell {
    private static final String name = "TotalSumEquals";
    private Board board;
    private String regionId;
    private int sum;

    //This constructor with no parameters is for creating an instance that'll act as a prototype for creating new instances with method
    // "createNewInstance".
    public RuleTotalSumEquals(Board boardValue) {
        this.board = boardValue;
        this.regionId = null;
        this.sum = 0;
    }

    //Regular constructor.
    public RuleTotalSumEquals(Board boardValue, String regionIdValue, int sumValue) {
        this.board = boardValue;
        this.regionId = regionIdValue;
        this.sum = sumValue;
    }

    //Constructor with list of Objects as parameters.
    @Deprecated
    public RuleTotalSumEquals(Board boardValue, List<Object> parametersList) {
        this.board = boardValue;
        this.regionId = (String) parametersList.get(0);
        this.sum = (int) parametersList.get(1);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void validate(Move move) {
        //TODO(Ivan)
    }

    @Override
    public RuleTotalSumEquals createNewInstance(List<Object> parametersList) {
        String newRegionId = (String) parametersList.get(0);
        int newSum = (int) parametersList.get(1);
        RuleTotalSumEquals newInstance = new RuleTotalSumEquals(this.board, newRegionId, newSum);
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

    //TODO(Ivan) Este método tal vez hay que volarlo.
    public int getSum() {
        return sum;
    }
}
