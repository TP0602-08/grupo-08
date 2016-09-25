package ar.fiuba.tdd.tp1.serialization.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rulebook")
public class RulebookXml {
    @XmlElement(name = "rule", type = RuleXml.class)
    private List<RuleXml> rules;

    public void setRules(List<RuleXml> rules) {
        this.rules = rules;
    }

    public List<RuleXml> getRules() {
        return this.rules;
    }
}
