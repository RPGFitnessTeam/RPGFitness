package co.rpg_fitness_app.android.rpg_fitness_app;

import android.widget.ArrayAdapter;

import org.junit.Test;

import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Boost;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Character;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Gear;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Species;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;

import static org.junit.Assert.*;

/**
 * Created by awhit on 3/14/2017.
 */
public class CharacterTest {
    @Test
    public void getDefaultInactiveGear() throws Exception {
        Character testChar = new Character();
        ArrayList<Gear> testObj = new ArrayList<>();
        assertEquals(testObj, testChar.getInactiveGear());
    }

    @Test
    public void setInactiveGear() throws Exception {
        Character testChar = new Character();

        Gear helmOfSorrow =  new Gear();
        helmOfSorrow.setName("helm of Sorrow");
        ArrayList<Gear> test = new ArrayList<Gear>();
        test.add(helmOfSorrow);

        testChar.setInactiveGear(test);

        assertEquals(test, testChar.getInactiveGear());
    }

    @Test
    public void getDefaultActiveGear() throws Exception {
        Character testChar = new Character();
        ArrayList<Gear> nullList = new ArrayList<Gear>();

        nullList.add(null);
        nullList.add(null);
        nullList.add(null);
        nullList.add(null);
        nullList.add(null);

        assertEquals(nullList, testChar.getActiveGear());
    }

    @Test
    public void setActiveGear() throws Exception {
        Character testChar = new Character();

        Gear helmOfSorrow =  new Gear();
        helmOfSorrow.setName("helm of Sorrow");
        ArrayList<Gear> test = new ArrayList<Gear>();
        test.add(helmOfSorrow);

        testChar.setActiveGear(test);

        assertEquals(test, testChar.getActiveGear());
    }

    @Test
    public void getDefaultMySpecies() throws Exception {
        Character testChar = new Character();
        assertNull(testChar.getSpecies());
    }

    @Test
    public void setMySpecies() throws Exception {
        Character testChar = new Character();
        Species Orc = new Species();
        Orc.setDescription("A fearsome greenskin Humanoid");
        Orc.setName("Orc");
        testChar.setSpecies(Orc);


        assertEquals(Orc, testChar.getSpecies());


    }

    @Test
    public void getDefaultName() throws Exception {
        Character testChar = new Character();
        assertNull(testChar.getName());
    }

    @Test
    public void setName() throws Exception {
        Character testChar = new Character();
        testChar.setName("Beowulf");
        assertSame("Beowulf", testChar.getName());
    }

    @Test
    public void getDefaultActiveBoosts() throws Exception {
        Character testChar = new Character();
        ArrayList<Boost> testObj = new ArrayList<Boost>();
        assertEquals(testObj, testChar.getActiveBoosts());
    }

    @Test
    public void setActiveBoosts() throws Exception {
        Character testChar = new Character();

        Boost testBoost = new Boost();
        testBoost.setBoostType("wood");
        testBoost.setAmount(100);

        ArrayList<Boost> boosts = new ArrayList<Boost>();
        boosts.add(testBoost);

        testChar.setActiveBoosts(boosts);
        assertEquals(boosts, testChar.getActiveBoosts());



    }

    @Test
    public void getDefaultMoneyChest() throws Exception {
        Character testChar = new Character();
        assertNull(testChar.getCurrency());
    }



    @Test
    public void getActiveInactiveInvetory() throws Exception {
        Character testChar = new Character();

        Gear helmOfSorrow =  new Gear();
        helmOfSorrow.setName("helm of Sorrow");
        helmOfSorrow.setCategory("Helm");

        Gear helmOfAnger =  new Gear();
        helmOfAnger.setName("helm of Anger");
        helmOfAnger.setCategory("Helm");

        Gear chestOfSorrow =  new Gear();
        chestOfSorrow.setName("chest of Sorrow");
        chestOfSorrow.setCategory("Chest");

        Gear chestOfAnger =  new Gear();
        chestOfAnger.setName("chest of Anger");
        chestOfAnger.setCategory("Chest");

        Gear swordOfMight =  new Gear();
        swordOfMight.setName("Sword of Might");
        swordOfMight.setCategory("Weapon");

        Gear swordOfSmite =  new Gear();
        swordOfSmite.setName("Sword of Smite");
        swordOfSmite.setCategory("Weapon");

        Gear emblem =  new Gear();
        emblem.setName("emblem");
        emblem.setCategory("OffHand");

        Gear talismn =  new Gear();
        talismn.setName("orb");
        talismn.setCategory("OffHand");

        Gear sandals = new Gear();
        sandals.setName("hermes sandals");
        sandals.setCategory("Legs");

        Gear flipFlop = new Gear();
        flipFlop.setName("hermes flip flops");
        flipFlop.setCategory("Legs");


        testChar.addGear(helmOfSorrow);
        testChar.addGear(helmOfAnger);

        testChar.addGear(chestOfSorrow);
        testChar.addGear(chestOfAnger);

        testChar.addGear(swordOfMight);
        testChar.addGear(swordOfSmite);

        testChar.addGear(emblem);
        testChar.addGear(talismn);

        testChar.addGear(sandals);
        testChar.addGear(flipFlop);


        assertEquals(helmOfSorrow, testChar.getActiveGear().get(0));
        assertEquals(chestOfSorrow, testChar.getActiveGear().get(1));
        assertEquals(swordOfMight, testChar.getActiveGear().get(2));
        assertEquals(emblem, testChar.getActiveGear().get(3));
        assertEquals(sandals, testChar.getActiveGear().get(4));

        assertEquals(helmOfAnger, testChar.getInactiveGear().get(0));
        assertEquals(chestOfAnger, testChar.getInactiveGear().get(1));
        assertEquals(swordOfSmite, testChar.getInactiveGear().get(2));
        assertEquals(talismn, testChar.getInactiveGear().get(3));
        assertEquals(flipFlop, testChar.getInactiveGear().get(4));


    }

    @Test
    public void addRemoveActiveGear() throws Exception {
        Character testChar = new Character();

        Gear helmOfSorrow =  new Gear();
        helmOfSorrow.setName("helm of Sorrow");
        helmOfSorrow.setCategory("Helm");
        testChar.addGear(helmOfSorrow);

        assertSame(helmOfSorrow, testChar.getInventory().get(0));

        testChar.removeGear(helmOfSorrow);

        ArrayList<Gear> testObj = new ArrayList<Gear>();

        assertEquals(testObj, testChar.getInventory());

    }


    @Test
    public void addRemoveinActiveGear() throws Exception {
        Character testChar = new Character();

        Gear helmOfSorrow =  new Gear();
        helmOfSorrow.setName("helm of Sorrow");
        helmOfSorrow.setCategory("Helm");
        testChar.addGear(helmOfSorrow);


        Gear helmOfSorrow2 =  new Gear();
        helmOfSorrow2.setName("helm of Sorrow 2");
        helmOfSorrow2.setCategory("Helm");
        testChar.addGear(helmOfSorrow2);

        assertSame(helmOfSorrow2, testChar.getInactiveGear().get(0));

        testChar.removeGear(helmOfSorrow2);

        ArrayList<Gear> testObj = new ArrayList<Gear>();
        testObj.add(helmOfSorrow);

        assertEquals(testObj, testChar.getInventory());

    }

    @Test
    public void equipItem() throws Exception {
        Character testChar = new Character();

        Gear helmOfSorrow =  new Gear();
        helmOfSorrow.setName("helm of Sorrow");
        helmOfSorrow.setCategory("Helm");
        testChar.equipItem(helmOfSorrow);

        assertSame(helmOfSorrow, testChar.getActiveGear().get(0));

        Gear helmOfAnger =  new Gear();
        helmOfAnger.setName("helm of Anger");
        helmOfAnger.setCategory("Helm");
        testChar.equipItem(helmOfAnger);

        assertEquals(helmOfAnger, testChar.getActiveGear().get(0));
        assertEquals(helmOfSorrow, testChar.getInactiveGear().get(0));

    }

    @Test
    public void retrieveGearInCategory() throws Exception {
        Character testChar = new Character();

        Gear helmOfSorrow =  new Gear();
        helmOfSorrow.setName("helm of Sorrow");
        helmOfSorrow.setCategory("Helm");

        Gear helmOfAnger =  new Gear();
        helmOfAnger.setName("helm of Anger");
        helmOfAnger.setCategory("Helm");

        Gear swordOfMight =  new Gear();
        swordOfMight.setName("Sword of Might");
        swordOfMight.setCategory("Weapon");


        testChar.addGear(helmOfSorrow);
        testChar.addGear(helmOfAnger);
        testChar.addGear(swordOfMight);

        ArrayList<Gear> listOfHelms = new ArrayList<Gear>();
        listOfHelms.add(helmOfSorrow);
        listOfHelms.add(helmOfAnger);

        assertEquals(listOfHelms, testChar.retrieveGearInCategory("Helm"));

    }

}