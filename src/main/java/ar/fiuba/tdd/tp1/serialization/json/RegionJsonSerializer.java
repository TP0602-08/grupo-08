package ar.fiuba.tdd.tp1.serialization.json;

import ar.fiuba.tdd.tp1.model.Region;
import ar.fiuba.tdd.tp1.serialization.interfaces.RegionSerializer;

import java.util.stream.Collectors;

public class RegionJsonSerializer implements RegionSerializer {
    private RegionJson regionJson;

    public RegionJsonSerializer(RegionJson regionJson) {
        this.regionJson = regionJson;
    }

    public Region deserialize() {
        Region region = new Region(this.regionJson.getCells().stream().map(Object::toString).collect(Collectors.toList()));
        return region;
    }
}
