package ar.fiuba.tdd.tp1.serialization.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cellNumerical")
@XmlAccessorType(XmlAccessType.FIELD)
public class CellNumericalXml extends CellXml {
    @XmlAttribute(name = "value")
    private int value;

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
