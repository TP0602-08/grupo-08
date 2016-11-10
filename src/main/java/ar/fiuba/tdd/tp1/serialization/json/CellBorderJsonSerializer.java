package ar.fiuba.tdd.tp1.serialization.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import javax.swing.border.MatteBorder;

public class CellBorderJsonSerializer {

    private static final String EXTENSION = "BordersInfo.json";
    private String path = "src/main/resources/";

    public CellBorderJsonSerializer(String gameName) {
        this.path += gameName;
        this.path += EXTENSION;
    }

    public boolean fileExists() {
        return Files.exists(Paths.get(this.path));
    }

    public List<MatteBorder> getBorders() throws IOException {
        Gson gson = new Gson();
        Type datasetListType = new TypeToken<Collection<MatteBorder>>() {}.getType();
        return gson.fromJson(Json.getJsonString(this.path), datasetListType);
    }
}
