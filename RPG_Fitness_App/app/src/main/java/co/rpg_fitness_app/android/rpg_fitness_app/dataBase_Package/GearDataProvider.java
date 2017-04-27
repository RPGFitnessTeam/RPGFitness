package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import android.icu.util.CurrencyAmount;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Boost;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Gear;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;

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
        Currency costOfHelmOfCourage = new Currency();
        helmOfCourage.setCost(costOfHelmOfCourage);
        Boost helmOfCourageBoost = new Boost();
        helmOfCourage.setBoost(helmOfCourageBoost);
        gearList.add(helmOfCourage);

        Gear LichHelm = new Gear();
        LichHelm.setName("Helm of the King Lich");
        LichHelm.setCategory("Helm");
        LichHelm.setOwned(true);
        Currency costOfLichHelm = new Currency();
        LichHelm.setCost(costOfLichHelm);
        Boost LichHelmBoost = new Boost();
        LichHelm.setBoost(LichHelmBoost);
        gearList.add(LichHelm);


    }

    private static void addGear(Gear gear) {
        gearList.add(gear);
        gearMap.put(gear.getID(), gear);
    }
}

