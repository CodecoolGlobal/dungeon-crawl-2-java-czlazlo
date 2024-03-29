package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.dao.GameDatabaseManager;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;
import com.codecool.dungeoncrawl.logic.items.Armor;
import com.codecool.dungeoncrawl.logic.items.Items;
import com.codecool.dungeoncrawl.logic.items.Key;
import com.codecool.dungeoncrawl.logic.items.Sword;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.google.gson.Gson;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import com.codecool.dungeoncrawl.logic.actors.Actor;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import util.GsonBuilderFactory;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.SQLException;
import java.util.Random;

public class Main extends Application {


    public void setMap(GameMap map) {
        this.map = map;
    }

    GameMap map = MapLoader.loadMap("/map.txt");

    private final Gson gsonBuilder = GsonBuilderFactory.createGsonBuilder();

    public void saveMap() {
        System.out.println("savemap vagyok");
        try (FileWriter writer = new FileWriter("./src/main/resources/save.json")){
            gsonBuilder.toJson(this.map, writer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static GameMap readMapFromJson(Gson gson) {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("./src/main/resources/save.json")
        )) {

            GameMap gameMap = gson.fromJson(reader, GameMap.class);
            gameMap.reset();
            return gameMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }






    Canvas canvas = new Canvas(
            map.getWidth() * Tiles.TILE_WIDTH,
            map.getHeight() * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Label healthLabel = new Label();
    Label inventoryLabel = new Label();
    Label armorLabel = new Label();
    Label attackDmg = new Label();
    GameDatabaseManager dbManager;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setupDbManager();
        context.setFill(Color.BLACK);
        GridPane ui = new GridPane();
        Text text = new Text();
        VBox vbox = new VBox(text);
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));

        ui.add(new Label("Health: "), 0, 0);
        ui.add(new Label("  Armor: "), 2, 0);
        ui.add(new Label("  Damage: "), 4, 0);
        ui.add(healthLabel, 1, 0);
        ui.add(armorLabel, 3, 0);
        ui.add(attackDmg, 5, 0);

        ui.add(inventoryLabel, 0, 7);
        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setBottom(ui);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);

        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                map.getPlayer().move(0, -1);
                map.getPlayer().attack(0, -1);
                break;
            case DOWN:
                map.getPlayer().move(0, 1);
                map.getPlayer().attack(0, 1);
                break;
            case LEFT:
                map.getPlayer().move(-1, 0);
                map.getPlayer().attack(-1, 0);
                break;
            case RIGHT:
                map.getPlayer().move(1, 0);
                map.getPlayer().attack(1, 0);
                break;
            case SPACE:
                map.getPlayer().pickUp(0, 0);
                break;
            case F6:
                saveMap();
                break;
            case F9:
//                setMap(MapLoader.loadMap("/map1.txt"));
                this.map = readMapFromJson(gsonBuilder);
//                setMap(readMapFromJson(gsonBuilder));
                break;


        }
        for (Actor monster : map.getMonsters()) {
            monster.act();
        }
        refresh();
        checkMapLoad();
    }

    public void checkMapLoad() {
        if(map.getPlayer().getCell().getType() == CellType.DOOR){
            setMap(MapLoader.loadMap("/map1.txt"));

        } else if (map.getPlayer().getCell().getType() == CellType.Z) {
            setMap(MapLoader.loadMap("/endgame.txt"));

        } else if (map.getPlayer().getCell().getType() == CellType.SAPHIRERING) {
            setMap(MapLoader.loadMap("/winmap.txt"));


        } else if (map.getPlayer().getCell().getType() == CellType.GOLDENRING || map.getPlayer().getCell().getType() == CellType.SILVERRING ) {
            setMap(MapLoader.loadMap("/losemap.txt"));

        }


    }
    public String convertIntToString(int text){
        return String.valueOf(text);
    }



    private void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Cell cell = map.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        healthLabel.setText("" + map.getPlayer().getHealth());
        inventoryLabel.setText(map.getPlayer().readInventory());
        armorLabel.setText(convertIntToString(map.getPlayer().getArmor()));
        attackDmg.setText(convertIntToString(map.getPlayer().getDmg()));
    }

    private void setupDbManager() {
        dbManager = new GameDatabaseManager();
        try {
            dbManager.setup();
        } catch (SQLException ex) {
            System.out.println("Cannot connect to database.");
        }
    }

    private void exit() {
        try {
            stop();
        } catch (Exception e) {
            System.exit(1);
        }
        System.exit(0);
    }

//    Jesus take the wheel
}
