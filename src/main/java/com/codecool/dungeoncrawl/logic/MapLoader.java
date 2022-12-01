package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Batman;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Scrab;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;
import com.codecool.dungeoncrawl.logic.items.HealthPotion;
import com.codecool.dungeoncrawl.logic.items.Key;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap(String url) {
        InputStream is = MapLoader.class.getResourceAsStream(url);
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            map.addSkeleton(new Skeleton(cell));
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case 'd':
                            cell.setType(CellType.DOOR);
                            break;
                        case 'w':
                            cell.setType(CellType.WATER);
                            break;
                        case 'p':
                            cell.setType(CellType.PINE);
                            break;
                        case 't':
                            cell.setType(CellType.TREE);
                            break;
                        case 'a':
                            cell.setType(CellType.ARMOR);
                            break;
                        case 'h':
                            cell.setType(CellType.HP);
                            cell.setItems(new HealthPotion(cell));
                            break;
                        case 'k':
                            cell.setType(CellType.KEY);
                            cell.setItems(new Key(cell));
                            break;
                        case 'q':
                            cell.setType(CellType.QUEEN);
                            break;
                        case 'g':
                            cell.setType(CellType.GLAIVE);
                            break;
                        case '?':
                            cell.setType(CellType.QMARK);
                            break;
                        case 'Y':
                            cell.setType(CellType.YLETTER);
                            break;
                        case 'O':
                            cell.setType(CellType.OLETTER);
                            break;
                        case 'U':
                            cell.setType(CellType.ULETTER);
                            break;
                        case 'S':
                            cell.setType(CellType.SLETTER);
                            break;
                        case 'A':
                            cell.setType(CellType.ALETTER);
                            break;
                        case 'V':
                            cell.setType(CellType.VLETTER);
                            break;
                        case 'E':
                            cell.setType(CellType.ELETTER);
                            break;
                        case 'D':
                            cell.setType(CellType.DLETTER);
                            break;
                        case 'R':
                            cell.setType(CellType.RLETTER);
                            break;
                        case 'F':
                            cell.setType(CellType.FLETTER);
                            break;
                        case 'T':
                            cell.setType(CellType.TLETTER);
                            break;
                        case 'W':
                            cell.setType(CellType.WLETTER);
                            break;
                        case 'I':
                            cell.setType(CellType.ILETTER);
                            break;
                        case 'C':
                            cell.setType(CellType.CLETTER);
                            break;
                        case 'H':
                            cell.setType(CellType.HLETTER);
                            break;
                        case 'G':
                            cell.setType(CellType.GLETTER);
                            break;
                        case 'N':
                            cell.setType(CellType.NLETTER);
                            break;
                        case 'M':
                            cell.setType(CellType.MLETTER);
                            break;
                        case 'L':
                            cell.setType(CellType.LLETTER);
                            break;
                        case 'P':
                            cell.setType(CellType.PLETTER);
                            break;
                        case '1':
                            cell.setType(CellType.GOLDENRING);
                            break;
                        case '2':
                            cell.setType(CellType.SAPHIRERING);
                            break;
                        case '3':
                            cell.setType(CellType.SILVERRING);
                            break;
                        case '4':
                            cell.setType(CellType.HEART);
                            break;
                        case 'b':
                            cell.setType(CellType.B);
                            map.setScrab(new Scrab(cell));
                            break;
                        case 'u':
                            cell.setType(CellType.U);
                            map.addBatman(new Batman(cell));
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

    public void giveTheRing(){

    }

}
