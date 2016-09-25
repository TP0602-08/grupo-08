package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Rule;

import java.util.List;

public class RuleTotalSumEquals implements Rule {
    private static final String name = "TotalSumEquals";
    private String regionId;
    private int sum;

    //This constructor with no parameters is for using an instance as a prototype for creating new instances.
    public RuleTotalSumEquals() {
        this.regionId = null;
        this.sum = 0;
    }

    public RuleTotalSumEquals(String regionIdValue, int sumValue) {
        this.regionId = regionIdValue;
        this.sum = sumValue;
    }

    public RuleTotalSumEquals(List<Object> parametersList) {
        this.regionId = (String) parametersList.get(0);
        this.sum = (int) parametersList.get(1);
    }

    @Override
    public boolean isValid(Move move) {
        //TODO(Ivan)
        return false;
    }

    @Override
    public void visit(CellNumerical cell) {
        //TODO(Ivan)
    }

    @Override
    public void visit(CellAlphabetical cell) {
        //TODO(Ivan)
    }

    //TODO(Ivan) Este método tal vez hay que volarlo.
    public int getSum() {
        return sum;
    }

    //TODO(Ivan) Este método tal vez hay que volarlo.
    public String getRegionIdm() {
        return regionId;
    }

    public String getName() {
        return this.name;
    }
}
