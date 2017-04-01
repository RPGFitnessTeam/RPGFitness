package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.Tips;

/**
 * Created by Austin on 3/14/2017.
 */

public class TipsDataProvider {
    public static ArrayList<Tips> tipsList;
    public static Map<String, Tips> tipsMap;

    static {
        tipsList = new ArrayList<Tips>();
        tipsMap = new HashMap<String, Tips>();

        // Below here is where we will add all items to the database
    }


    //TODO: add getID for tips
    private static void addTips(Tips tips) {
        tipsList.add(tips);
        //tipsMap.put(tips.getID(), tips);
    }
}

