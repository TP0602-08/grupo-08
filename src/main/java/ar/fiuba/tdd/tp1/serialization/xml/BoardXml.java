package ar.fiuba.tdd.tp1.serialization.xml;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "board")
public class BoardXml {
    @XmlAttribute(name = "rows")
    private int rows;
    @XmlAttribute(name = "cols")
    private int columns;
    @XmlElement(name = "cell", type = CellXml.class)
    private List<CellXml> cells;
    @XmlElement(name = "region", type = RegionXml.class)
    private List<RegionXml> regions;

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public List<CellXml> getCells() {
        return this.cells;
    }

    public List<RegionXml> getRegions() {
        return this.regions;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setCells(List<CellXml> cells) {
        this.cells = cells;
    }

    public void setRegions(List<RegionXml> regions) {
        this.regions = regions;
    }
}
