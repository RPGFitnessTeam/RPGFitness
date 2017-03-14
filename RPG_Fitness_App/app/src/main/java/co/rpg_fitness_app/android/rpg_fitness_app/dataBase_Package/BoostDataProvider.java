package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Boost;

public class BoostDataProvider {
    public static ArrayList<Boost> boostList;
    public static Map<String, Boost> boostMap;

    static {
        boostList = new ArrayList<Boost>();
        boostMap = new HashMap<String, Boost>();

        // Below here is where we will add all items to the database
    }

    private static void addBoost(Boost boost) {
        boostList.add(boost);
        boostMap.put(boost.getID(), boost);
    }
}
