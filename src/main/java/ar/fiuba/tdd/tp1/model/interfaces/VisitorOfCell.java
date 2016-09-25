package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.CellAlphabetical;
import ar.fiuba.tdd.tp1.model.CellNumerical;

public interface VisitorOfCell {
    public void visit(CellNumerical cellNumerical);

    public void visit(CellAlphabetical cellAlphabetical);

    //This method exists to handle new Cell types that aren't currently overloaded here (Cells other than Numerical and Alphabetical).
    public default void visit(Cell cellGeneric) {
        return;
    }
}
