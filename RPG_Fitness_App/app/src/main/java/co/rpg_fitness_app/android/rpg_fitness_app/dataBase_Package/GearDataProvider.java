package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Gear;

/**
 * Created by Austin on 3/14/2017.
 */

public class GearDataProvider {
    public static ArrayList<Gear> gearList;
    public static Map<String, Gear> gearMap;

    static {
        gearList = new ArrayList<Gear>();
        gearMap = new HashMap<String, Gear>();

        Gear helmOfCourage = new Gear();
        helmOfCourage.setName("Helm of Courage");
        helmOfCourage.setCategory("Helm");
        helmOfCourage.setOwned(true);
        gearList.add(helmOfCourage);

        Gear LichHelm = new Gear();
        LichHelm.setName("Helm of the King Lich");
        LichHelm.setCategory("Helm");
        LichHelm.setOwned(true);
        gearList.add(LichHelm);


    }

    private static void addGear(Gear gear) {
        gearList.add(gear);
        gearMap.put(gear.getID(), gear);
    }
}

