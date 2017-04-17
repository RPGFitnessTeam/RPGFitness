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

        Species Orc = new Species();
        Orc.setName("Orc");

        Species Elf = new Species();
        Elf.setName("Elf");

        Species Human = new Species();
        Human.setName("Human");

        Species Dwarf = new Species();
        Dwarf.setName("Dwarf");

        speciesList.add(Orc);
        speciesList.add(Elf);
        speciesList.add(Human);
        speciesList.add(Dwarf);

    }

    private static void addSpecies(Species species) {
        speciesList.add(species);
        speciesMap.put(species.getID(), species);
    }
}

