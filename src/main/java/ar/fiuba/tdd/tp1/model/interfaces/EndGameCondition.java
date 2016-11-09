package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.BoardRectangularWithRegions;
/*Esta interfaz representa las condicones de fin de juego.El metodo Validate al retornar un valor
true,validará la condicion de fin juego.
* */
public interface EndGameCondition {
    Boolean validate(BoardRectangularWithRegions board);
}
