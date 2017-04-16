package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Species;

/**
 * Created by Austin on 3/14/2017.
 */

public class SpeciesDataProvider {
    public static ArrayList<Species> speciesList;
    public static Map<String, Species> speciesMap;

    static {
        speciesList = new ArrayList<Species>();
        speciesMap = new HashMap<String, Species>();
    }

    private static void addSpecies(Species species) {
        speciesList.add(species);
        speciesMap.put(species.getID(), species);
    }
}

