package ar.fiuba.tdd.tp1.model.interfaces;

public interface Cell {
    public String getName();

    void accept(VisitorOfCell visitorOfCell);
}
