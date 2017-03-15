package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.Goal;

/**
 * Created by Austin on 3/14/2017.
 */

public class GoalDataProvider {
    public static ArrayList<Goal> goalList;
    public static Map<String, Goal> goalMap;

    static {
        goalList = new ArrayList<Goal>();
        goalMap = new HashMap<String, Goal>();

        // Below here is where we will add all items to the database
    }

    //TODO: implement goal.getID or change DB
    private static void addGoal(Goal goal) {
        goalList.add(goal);
        //goalMap.put(goal.getID(), goal);
    }
}

