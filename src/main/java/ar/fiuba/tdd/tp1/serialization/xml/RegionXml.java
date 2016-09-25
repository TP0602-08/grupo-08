package ar.fiuba.tdd.tp1.serialization.xml;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "region")
public class RegionXml {
    @XmlAttribute(name = "param")
    private String param;
    @XmlElement(name = "cell")
    private List<String> cells;

    public List<String> getCells() {
        return this.cells;
    }

    public void setCells(List<String> cells) {
        this.cells = cells;
    }

    public String getParam() {
        return this.param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
