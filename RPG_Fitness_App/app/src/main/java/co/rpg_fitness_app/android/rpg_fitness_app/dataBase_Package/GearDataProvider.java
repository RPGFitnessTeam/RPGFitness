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


        Gear OrcMail = new Gear();
        OrcMail.setName("Orc Mail");
        OrcMail.setCategory("Chest");
        OrcMail.setOwned(true);
        Currency costOfOrcMail = new Currency();
        OrcMail.setCost(costOfOrcMail);
        Boost OrcMailBoost = new Boost();
        OrcMail.setBoost(OrcMailBoost);
        gearList.add(OrcMail);

        Gear ParachutePants = new Gear();
        ParachutePants.setName("Parachute Pants");
        ParachutePants.setCategory("Legs");
        ParachutePants.setOwned(true);
        Currency costOfParachutePants = new Currency();
        ParachutePants.setCost(costOfParachutePants);
        Boost ParachutePantsBoost = new Boost();
        ParachutePants.setBoost(ParachutePantsBoost);
        gearList.add(ParachutePants);


        Gear Frostblade = new Gear();
        Frostblade.setName("Frost Blade");
        Frostblade.setCategory("Weapon");
        Frostblade.setOwned(true);
        Currency costOfFrostblade = new Currency();
        Frostblade.setCost(costOfFrostblade);
        Boost FrostbladeBoost = new Boost();
        Frostblade.setBoost(FrostbladeBoost);
        gearList.add(Frostblade);

        Gear RubberChicken = new Gear();
        RubberChicken.setName("A Rubber Chicken");
        RubberChicken.setCategory("Weapon");
        RubberChicken.setOwned(true);
        Currency costOfRubberChicken = new Currency();
        RubberChicken.setCost(costOfRubberChicken);
        Boost RubberChickenBoost = new Boost();
        RubberChicken.setBoost(RubberChickenBoost);
        gearList.add(RubberChicken);

        Gear BeosBlade = new Gear();
        BeosBlade.setName("Beos Blade");
        BeosBlade.setCategory("Weapon");
        BeosBlade.setOwned(true);
        Currency costOfBeosBlade = new Currency();
        BeosBlade.setCost(costOfBeosBlade);
        Boost BeosBladeBoost = new Boost();
        BeosBlade.setBoost(BeosBladeBoost);
        gearList.add(BeosBlade);

        Gear DwarvenMail = new Gear();
        DwarvenMail.setName("Dwarven Mail");
        DwarvenMail.setCategory("Chest");
        DwarvenMail.setOwned(true);
        Currency costOfDwarvenMail = new Currency();
        DwarvenMail.setCost(costOfDwarvenMail);
        Boost DwarvenMailBoost = new Boost();
        DwarvenMail.setBoost(DwarvenMailBoost);
        gearList.add(DwarvenMail);



        Gear FoundersGrail = new Gear();
        FoundersGrail.setName("Founders Grail");
        FoundersGrail.setCategory("OffHand");
        FoundersGrail.setOwned(true);
        Currency costOfFoundersGrail = new Currency();
        FoundersGrail.setCost(costOfFoundersGrail);
        Boost FoundersGrailBoost = new Boost();
        FoundersGrail.setBoost(FoundersGrailBoost);
        gearList.add(FoundersGrail);








    }

    private static void addGear(Gear gear) {
        gearList.add(gear);
        gearMap.put(gear.getID(), gear);
    }
}

