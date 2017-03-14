package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Austin on 3/14/2017.
 */

public class TileDataProvider {
    public static ArrayList<Tile> tileList;
    public static Map<String, Tile> tileMap;

    static {
        tileList = new ArrayList<Tile>();
        tileMap = new HashMap<String, Tile>();

        // Below here is where we will add all items to the database
    }

    private static void addTile(Tile tile) {
        tileList.add(tile);
        tileMap.put(tile.getID(), tile);
    }
}


