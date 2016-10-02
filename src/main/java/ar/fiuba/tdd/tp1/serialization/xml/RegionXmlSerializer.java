package ar.fiuba.tdd.tp1.serialization.xml;

import ar.fiuba.tdd.tp1.model.Region;
import ar.fiuba.tdd.tp1.serialization.interfaces.RegionSerializer;
import ar.fiuba.tdd.tp1.serialization.xml.RegionXml;

public class RegionXmlSerializer implements RegionSerializer {
    private RegionXml regionXml;

    public RegionXmlSerializer(RegionXml regionXml) {
        this.regionXml = regionXml;
    }

    public Region deserialize() {
        Region region = new Region(this.regionXml.getCells(), this.regionXml.getParam());
        return region;
    }
}
