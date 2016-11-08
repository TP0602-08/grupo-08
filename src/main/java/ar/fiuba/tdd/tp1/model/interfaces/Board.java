package ar.fiuba.tdd.tp1.model.interfaces;

import ar.fiuba.tdd.tp1.model.Cell;
import ar.fiuba.tdd.tp1.model.Move;
import ar.fiuba.tdd.tp1.model.Region;

import java.util.List;
import java.util.Map;
/*Esta interfaz tiene como objetivo representar al tablero del juego.Cada celda tiene su
Id , y varias Ids forma una region.El tablero tendra un numero de celdas y una dimension
(filas x columnas),ademas de un mapa que nos brinda los valores del tablero del tipo <id,valor>
La idea de esta interfaz era ser extensible para varios tipos de tableros
* */
public interface Board {
    void apply(Move move);

    Region getRegion(String regionId);

    List<Integer> getCellIdsListFromRegionId(String regionId);

    Cell getCellFromCellId(Integer cellId);

    int getRowQuantity();

    int getColumnQuantity();

    int getNumberOfCells();

    Map<Integer,String> getBoardValues();
}
