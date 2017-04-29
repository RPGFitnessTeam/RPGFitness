package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;
import co.rpg_fitness_app.android.rpg_fitness_app.quest_Package.Quest;

/**
 * Created by Austin on 3/14/2017.
 */


//TODO: implement quest methods
public class QuestDataProvider {
    public static ArrayList<Quest> questList;
    public static Map<String, Quest> questMap;

    static {
        questList = new ArrayList<Quest>();
        questMap = new HashMap<String, Quest>();

        // Below here is where we will add all items to the database
        boolean isMasterQuest = false;
        Currency reward = new Currency();
        reward.setGold(10);
        reward.setStone(10);
        reward.setWood(10);
        String name;
        String description;
        Quest quest;

        name = "Quest 1";
        description = "description 1";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Quest 2";
        description = "description 2";
        //parameters = "parameters 2";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Quest 3";
        description = "description 3";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Quest 4";
        description = "description 4";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Quest 5";
        description = "description 5";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Quest 6";
        description = "description 6";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Quest 7";
        description = "description 7";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

    }

    private static void addQuest(Quest quest) {
        questList.add(quest);
        questMap.put(quest.getId(), quest);
    }
}

