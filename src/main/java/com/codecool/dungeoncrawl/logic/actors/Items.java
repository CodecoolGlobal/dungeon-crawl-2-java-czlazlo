
package com.codecool.dungeoncrawl.logic.actors;
public enum Items {
    SWORD("Sword_of_Doom"),
    ARMOR("Dragon_scale"),
    KEY_NEXT("Next_lvl_key"),
    KEY_END("Game_winning_key");


    private String name;

    Items(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}




