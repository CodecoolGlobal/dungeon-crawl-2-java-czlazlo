package util;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.*;
import com.codecool.dungeoncrawl.logic.items.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonBuilderFactory {


    public static Gson createGsonBuilder(){

        RuntimeTypeAdapterFactory<Actor> ActorAdapterFactory
                = RuntimeTypeAdapterFactory.of(Actor.class);
        ActorAdapterFactory.registerSubtype(Batman.class, "Batman");
        ActorAdapterFactory.registerSubtype(Ghost.class, "Ghost");
        ActorAdapterFactory.registerSubtype(Skeleton.class, "Skeleton");
        ActorAdapterFactory.registerSubtype(Player.class, "Player");
        ActorAdapterFactory.registerSubtype(Scrab.class, "Scrab");


        RuntimeTypeAdapterFactory<Items> itemAdapterFactory
                = RuntimeTypeAdapterFactory.of(Items.class);
        itemAdapterFactory.registerSubtype(Armor .class, "Armor");
        itemAdapterFactory.registerSubtype(Key .class, "Key");
        itemAdapterFactory.registerSubtype(GoldenRing .class, "GoldenRing");
        itemAdapterFactory.registerSubtype(SaphireRing .class, "SaphireRing");
        itemAdapterFactory.registerSubtype(SilverRing .class, "SilverRing");
        itemAdapterFactory.registerSubtype(HealthPotion .class, "HealthPotion");
        itemAdapterFactory.registerSubtype(Sword.class, "Sword");

        return new GsonBuilder()
                .registerTypeAdapterFactory(ActorAdapterFactory)
                .registerTypeAdapterFactory(itemAdapterFactory)
                .setPrettyPrinting()
                .create();
    }



}