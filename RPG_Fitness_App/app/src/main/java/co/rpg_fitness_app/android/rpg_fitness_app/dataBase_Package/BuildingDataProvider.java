package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Boost;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Building;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;

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
        String name; Currency cost = new Currency(); String category; int tier; Boost goldBoost = new Boost(); Boost woodBoost = new Boost(); Boost stoneBoost = new Boost();
        Building house, castle, woodBridge, stoneBridge, cave, mine, tavern, innAndTavern, fort, fortress, pond, fountain;
        goldBoost.setBoostType("gold"); woodBoost.setBoostType("wood");stoneBoost.setBoostType("stone");

        name = "house";
        cost.updateResource(true,5,0,0,1,1,1,1,1);
        category = "dwelling";
        tier = 1;
        goldBoost.setAmount(1);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(0);
        house = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(house);

        name = "castle";
        cost = new Currency();
        cost.updateResource(true,5,0,0,1,1,1,1,1);
        category = "dwelling";
        tier = 2;
        goldBoost.setAmount(2);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(0);
        castle = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(castle);

        name = "wood bridge";
        cost = new Currency();
        cost.updateResource(true,0,0,2,1,0,0,0,0);
        category = "bridge";
        tier = 1;
        goldBoost.setAmount(0);
        woodBoost.setAmount(1);
        stoneBoost.setAmount(0);
        woodBridge = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(woodBridge);

        name = "stone bridge";
        cost = new Currency();
        cost.updateResource(true,0,0,2,1,0,0,0,0);
        category = "bridge";
        tier = 2;
        goldBoost.setAmount(0);
        woodBoost.setAmount(2);
        stoneBoost.setAmount(0);
        stoneBridge = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(stoneBridge);

        name = "cave";
        cost = new Currency();
        cost.updateResource(true,2,0,0,0,1,0,0,0);
        category = "mining";
        tier = 1;
        goldBoost.setAmount(0);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(1);
        cave = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(cave);

        name = "mine";
        cost = new Currency();
        cost.updateResource(true,2,0,0,0,1,0,0,0);
        category = "mining";
        tier = 2;
        goldBoost.setAmount(0);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(2);
        mine = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(mine);

        name = "tavern";
        cost = new Currency();
        cost.updateResource(true,0,0,2,0,0,1,0,0);
        category = "hospitality";
        tier = 1;
        goldBoost.setAmount(1);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(0);
        tavern = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(tavern);

        name = "inn and tavern";
        cost = new Currency();
        cost.updateResource(true,0,0,2,0,0,1,0,0);
        category = "hospitality";
        tier = 2;
        goldBoost.setAmount(0);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(2);
        innAndTavern = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(innAndTavern);

        name = "fort";
        cost = new Currency();
        cost.updateResource(true,2,0,0,0,0,0,1,0);
        category = "military";
        tier = 1;
        goldBoost.setAmount(0);
        woodBoost.setAmount(1);
        stoneBoost.setAmount(0);
        fort = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(fort);

        name = "fortress";
        cost = new Currency();
        cost.updateResource(true,2,0,0,0,0,0,1,0);
        category = "military";
        tier = 2;
        goldBoost.setAmount(0);
        woodBoost.setAmount(2);
        stoneBoost.setAmount(0);
        fortress = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(fortress);

        name = "pond";
        cost = new Currency();
        cost.updateResource(true,0,0,2,0,0,0,0,1);
        category = "water feature";
        tier = 1;
        goldBoost.setAmount(1);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(0);
        pond = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(pond);

        name = "fountain";
        cost = new Currency();
        cost.updateResource(true,0,0,2,0,0,0,0,1);
        category = "water feature";
        tier = 2;
        goldBoost.setAmount(2);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(0);
        fountain = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(fountain);
    }

    //TODO Building needs getID method
    private static void addBuilding(Building building) {
        buildingList.add(building);
        buildingMap.put(building.getId(), building);
    }
}


