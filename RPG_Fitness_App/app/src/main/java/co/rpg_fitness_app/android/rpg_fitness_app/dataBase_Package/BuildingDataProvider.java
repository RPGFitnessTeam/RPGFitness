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
        cost.updateResource(false,5,0,0,0,0,0,0,0);

        name = "castle";
        cost.updateResource(true,5,0,0,0,0,0,0,0);
        category = "dwelling";
        tier = 2;
        goldBoost.setAmount(2);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(0);
        castle = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(castle);
        cost.updateResource(false,5,0,0,0,0,0,0,0);

        name = "wood bridge";
        cost.updateResource(true,0,0,2,1,0,0,0,0);
        category = "bridge";
        tier = 1;
        goldBoost.setAmount(0);
        woodBoost.setAmount(1);
        stoneBoost.setAmount(0);
        woodBridge = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(woodBridge);
        cost.updateResource(false,0,0,2,1,0,0,0,0);

        name = "stone bridge";
        cost.updateResource(true,0,0,2,1,0,0,0,0);
        category = "bridge";
        tier = 2;
        goldBoost.setAmount(0);
        woodBoost.setAmount(2);
        stoneBoost.setAmount(0);
        stoneBridge = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(stoneBridge);
        cost.updateResource(false,0,0,2,1,0,0,0,0);

        name = "cave";
        cost.updateResource(true,2,0,0,0,1,0,0,0);
        category = "mining";
        tier = 1;
        goldBoost.setAmount(0);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(1);
        cave = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(cave);
        cost.updateResource(false,2,0,0,0,1,0,0,0);

        name = "mine";
        cost.updateResource(true,2,0,0,0,1,0,0,0);
        category = "mining";
        tier = 2;
        goldBoost.setAmount(0);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(2);
        mine = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(mine);
        cost.updateResource(false,2,0,0,0,1,0,0,0);

        name = "tavern";
        cost.updateResource(true,0,0,2,0,0,1,0,0);
        category = "hospitality";
        tier = 1;
        goldBoost.setAmount(1);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(0);
        tavern = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(tavern);
        cost.updateResource(false,0,0,2,0,0,1,0,0);

        name = "inn and tavern";
        cost.updateResource(true,0,0,2,0,0,1,0,0);
        category = "hospitality";
        tier = 2;
        goldBoost.setAmount(0);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(2);
        innAndTavern = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(innAndTavern);
        cost.updateResource(false,0,0,2,0,0,1,0,0);

        name = "fort";
        cost.updateResource(true,2,0,0,0,0,0,1,0);
        category = "military";
        tier = 1;
        goldBoost.setAmount(0);
        woodBoost.setAmount(1);
        stoneBoost.setAmount(0);
        fort = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(fort);
        cost.updateResource(false,2,0,0,0,0,0,1,0);

        name = "fortress";
        cost.updateResource(true,2,0,0,0,0,0,1,0);
        category = "military";
        tier = 2;
        goldBoost.setAmount(0);
        woodBoost.setAmount(2);
        stoneBoost.setAmount(0);
        fortress = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(fortress);
        cost.updateResource(false,2,0,0,0,0,0,1,0);

        name = "pond";
        cost.updateResource(true,0,0,2,0,0,0,0,1);
        category = "water feature";
        tier = 1;
        goldBoost.setAmount(1);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(0);
        pond = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(pond);
        cost.updateResource(false,0,0,2,0,0,0,0,1);

        name = "fountain";
        cost.updateResource(true,0,0,2,0,0,0,0,1);
        category = "water feature";
        tier = 2;
        goldBoost.setAmount(2);
        woodBoost.setAmount(0);
        stoneBoost.setAmount(0);
        fountain = new Building(name, cost, category, tier, goldBoost, woodBoost, stoneBoost, null);
        addBuilding(fountain);
        cost.updateResource(false,0,0,2,0,0,0,0,1);
    }

    //TODO Building needs getID method
    private static void addBuilding(Building building) {
        buildingList.add(building);
        buildingMap.put(building.getId(), building);
    }
}


