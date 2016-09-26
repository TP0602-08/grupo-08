package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.CellAlphabetical;
import ar.fiuba.tdd.tp1.model.CellNumerical;

public interface VisitorOfCell {
    public void visit(CellAlphabetical cellAlphabetical);

    public void visit(CellNumerical cellNumerical);

    //This method exists to handle new Cell implementations that aren't currently overloaded here (Cells other than Numerical and
    // Alphabetical).
    public default void visit(Cell cellGeneric) {
        return;
    }
}
