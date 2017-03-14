package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Character;

/**
 * Created by Austin on 3/14/2017.
 */

public class CharacterDataProvider {
    public static ArrayList<Character> characterList;
    public static Map<String, Character> characterMap;

    static {
        characterList = new ArrayList<Character>();
        characterMap = new HashMap<String, Character>();

        // Below here is where we will add all items to the database
    }

    private static void addCharacter(Character character) {
        characterList.add(character);
        characterMap.put(character.getID(), character);
    }
}

