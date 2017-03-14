package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Gear;

/**
 * Created by Austin on 3/14/2017.
 */

public class GearDataProvider {
    public static ArrayList<Gear> gearList;
    public static Map<String, Gear> gearMap;

    static {
        gearList = new ArrayList<Gear>();
        gearMap = new HashMap<String, Gear>();

        // Below here is where we will add all items to the database
    }

    private static void addGear(Gear gear) {
        gearList.add(gear);
        gearMap.put(gear.getID(), gear);
    }
}

