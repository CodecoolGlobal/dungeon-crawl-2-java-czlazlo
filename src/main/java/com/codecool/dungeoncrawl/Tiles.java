package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("player", new Tile(27, 0));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("Batman", new Tile(29,7));
        tileMap.put("door", new Tile(3,4));
        tileMap.put("hp", new Tile (27,23));
        tileMap.put("tree", new Tile(4,2));
        tileMap.put("pine", new Tile(1,1));
        tileMap.put("stone", new Tile(5,2));
        tileMap.put("water", new Tile(8,4));
        tileMap.put("key", new Tile(16,23));
        tileMap.put("queen", new Tile(31,10));
        tileMap.put("qmark", new Tile (21,25));
        tileMap.put("glaive", new Tile(10,30));
        tileMap.put("yletter", new Tile(30,31));
        tileMap.put("oletter", new Tile(20,31));
        tileMap.put("uletter", new Tile(26,31));
        tileMap.put("sletter", new Tile(24,31));
        tileMap.put("aletter", new Tile(19,30));
        tileMap.put("vletter", new Tile(27,31));
        tileMap.put("eletter", new Tile(23,30));
        tileMap.put("dletter", new Tile(22,30));
        tileMap.put("rletter", new Tile(23,31));
        tileMap.put("fletter", new Tile(24,30));
        tileMap.put("tletter", new Tile(25,31));
        tileMap.put("wletter", new Tile(28,31));
        tileMap.put("iletter", new Tile(27,30));
        tileMap.put("cletter", new Tile(21,30));
        tileMap.put("hletter", new Tile(26,30));
        tileMap.put("gletter", new Tile(25,30));
        tileMap.put("nletter", new Tile(19,31));
        tileMap.put("mletter", new Tile(31,30));
        tileMap.put("lletter", new Tile(30,30));
        tileMap.put("pletter", new Tile(21,31));
        tileMap.put("goldenring", new Tile(13,28));
        tileMap.put("silverring", new Tile(12,28));
        tileMap.put("saphirering", new Tile(14,28));
        tileMap.put("heart", new Tile(23,22));
        tileMap.put("scrab", new Tile(25,5));
        tileMap.put("batman", new Tile(26,8));
        tileMap.put("armor", new Tile (4,22));

    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
