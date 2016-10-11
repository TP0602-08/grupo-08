package ar.fiuba.tdd.tp1.serialization.json;

public class RuleJson {
    private String type;
    private String region;
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String newRegion) {
        region = newRegion;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String newType) {
        type = newType;
    }
}
