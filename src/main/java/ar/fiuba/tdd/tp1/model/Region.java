package ar.fiuba.tdd.tp1.model;

import java.util.List;
/*Esta intefaz representa una region de celdas que puede de disitas formas en el tablero
 Tien una lista de objetos cell que nos determina que id de que celda pertenecen a la region
 para luego aplicar validacion y reglas sobre ella.
 Cada region tendra un id para identificarla univocamente representado en el campo "param" del constructor
* */
public class Region {
    private String param;

    private List<String> cellNamesList;

    public Region(List<String> cellsIdListValue) {
        this.cellNamesList = cellsIdListValue;
    }

    public Region(List<String> cellsIdListValue, String param) {
        this.param = param;
        this.cellNamesList = cellsIdListValue;
    }

    public List<String> getCellNamesList() {
        return cellNamesList;
    }

    public String getParam() {
        return this.param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
