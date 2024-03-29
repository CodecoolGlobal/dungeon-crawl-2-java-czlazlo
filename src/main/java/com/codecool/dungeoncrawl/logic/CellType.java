package com.codecool.dungeoncrawl.logic;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    u("batman"),
    B("scrab"),
    DOOR("door"),
    HP("hp"),
    ARMOR("armor"),
    TREE("tree"),
    PINE("pine"),
    STONE("stone"),
    WATER("water"),
    KEY("key"),
    GLAIVE("glaive"),
    QUEEN("queen"),
    QMARK("qmark"),
    YLETTER("yletter"),
    OLETTER("oletter"),
    ULETTER("uletter"),
    SLETTER("sletter"),
    ALETTER("aletter"),
    VLETTER("vletter"),
    ELETTER("eletter"),
    DLETTER("dletter"),
    RLETTER("rletter"),
    FLETTER("fletter"),
    TLETTER("tletter"),
    WLETTER("wletter"),
    ILETTER("iletter"),
    CLETTER("cletter"),
    HLETTER("hletter"),
    GLETTER("gletter"),
    NLETTER("nletter"),
    MLETTER("mletter"),
    LLETTER("lletter"),
    PLETTER("pletter"),
    SAPHIRERING ("saphirering"),
    SILVERRING("silverring"),
    GOLDENRING("goldenring"),
    HEART("heart"),
    Z("seconddoor"),

    GHOST("ghost"),
    ITEM("item");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
