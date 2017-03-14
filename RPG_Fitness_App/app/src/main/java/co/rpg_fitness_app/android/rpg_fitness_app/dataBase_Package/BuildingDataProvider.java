package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Building;

/**
 * Created by Austin on 3/14/2017.
 */

public class BuildingDataProvider {
    public static ArrayList<Building> buildingList;
    public static Map<String, Building> buildingMap;

    static {
        buildingList = new ArrayList<Building>();
        buildingMap = new HashMap<String, Building>();

        // Below here is where we will add all items to the database
    }

    private static void addBuilding(Building building) {
        buildingList.add(building);
        buildingMap.put(building.getID(), building);
    }
}


