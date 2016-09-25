package ar.fiuba.tdd.tp1.model;

import ar.fiuba.tdd.tp1.model.interfaces.Rule;

public class RuleTotalSumEquals implements Rule {
    private static final String name = "TotalSumEquals";
    private int sum;

    //This constructor with no parameters is for using an instance as a prototype for creating new instances.
    public RuleTotalSumEquals() {
        this.sum = 0;
    }

    public RuleTotalSumEquals(int sumValue) {
        this.sum = sumValue;
    }

    @Override
    public boolean isAValidMove() {
        //TODO(Ivan)
        return false;
    }

    //TODO(Ivan) Este método tal vez hay que volarlo.
    public int getSum() {
        return sum;
    }

    public String getName() {
        return this.name;
    }
}
