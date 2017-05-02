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

        name = "Bandit Barrage";
        description = "A group of Bandits has stolen your goods!\n\n" +
                "Chase them down.\n\n-Run/Walk 2 miles without stopping";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Orc Invasion";
        description = "A tribe of rogue orcs has invaded your kingdom!\n\n" +
                "Protect it with your might.\n\n-perform 50 push-ups(total)";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Peasant Peril";
        description = "A group of peasants is trapped under a collapsed building!\n\n" +
                "Rescue them from the rubble.\n\n-perform lower body lifting routine";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Magic Focus";
        description = "An evil mage has challenged you to a duel of sorcery!\n\n" +
                    "unleash your inner magica.\n\n-perform 45 minutes of yoga";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Sea Orcs???";
        description = "Some Sea Orcs need a shipment from your kingdom!\n\n" +
                "Deliver it to them.\n\n-perform 30 minutes of water activity";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Magic Recovery";
        description = "You have drained your magica!\n\n" +
                  "Meditate to draw it back.\n\n-sleep for 8hrs one night";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Boulder Blockade";
        description = "a boulder is preventing you from expanding your kingdom!\n\n" +
                        "Clear them out.\n\n-Perform upper body lifting routine";
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

        name = "Champion";
        description = "Prove your worth, by completing multiple feats of strength!";
        isMasterQuest = true;
        quest = new Quest(isMasterQuest, reward, name, description);
        addQuest(quest);

    }

    private static void addQuest(Quest quest) {
        questList.add(quest);
        questMap.put(quest.getId(), quest);
    }
}

