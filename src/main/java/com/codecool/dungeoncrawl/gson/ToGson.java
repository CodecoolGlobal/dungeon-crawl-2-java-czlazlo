package com.codecool.dungeoncrawl.gson;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class ToGson {
    Gson gson = new Gson();



    public void saveObject(Object object) throws IOException {
        gson.toJson(object, new FileWriter("filePath"));
    }
}
