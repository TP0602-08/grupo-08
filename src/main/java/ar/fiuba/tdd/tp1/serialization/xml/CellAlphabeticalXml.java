package ar.fiuba.tdd.tp1.serialization.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cellAlphabetical")
@XmlAccessorType(XmlAccessType.FIELD)
public class CellAlphabeticalXml extends CellXml {
    @XmlAttribute(name = "value")
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
