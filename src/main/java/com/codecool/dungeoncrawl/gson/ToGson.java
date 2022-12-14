package com.codecool.dungeoncrawl.gson;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.google.gson.Gson;
import util.GsonBuilderFactory;

import java.io.FileWriter;
import java.io.IOException;

public class ToGson {
    Gson gson = new Gson();

    private static final Gson gsonBuilder = GsonBuilderFactory.createGsonBuilder();

    public void saveObject(Object object) throws IOException {
        gson.toJson(object, new FileWriter("filePath"));
    }
}
