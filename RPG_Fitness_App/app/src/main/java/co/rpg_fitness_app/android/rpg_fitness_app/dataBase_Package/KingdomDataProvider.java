package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Kingdom;

/**
 * Created by Austin on 3/14/2017.
 */

public class KingdomDataProvider {
    public static ArrayList<Kingdom> kingdomList;
    public static Map<String, Kingdom> kingdomMap;

    static {
        kingdomList = new ArrayList<Kingdom>();
        kingdomMap = new HashMap<String, Kingdom>();

        // Below here is where we will add all items to the database
    }

    //TODO: add getID for kingdom
    private static void addKingdom(Kingdom kingdom) {
        kingdomList.add(kingdom);
        //kingdomMap.put(kingdom.getID(), kingdom);
    }
}

