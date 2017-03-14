package co.rpg_fitness_app.android.rpg_fitness_app;

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
        assertNull(testChar.getInactiveGear());
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
        assertNull(testChar.getActiveGear());
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
        assertNull(testChar.getActiveBoosts());
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
    public void setMoneyChest() throws Exception {
        //TODO MAKE THIS TEST

    }

    @Test
    public void getInvetory() throws Exception {
        Character testChar = new Character();

        Gear helmOfSorrow =  new Gear();
        helmOfSorrow.setName("helm of Sorrow");

        Gear helmOfAnger =  new Gear();
        helmOfSorrow.setName("helm of Anger");

        Gear swordOfMight =  new Gear();
        helmOfSorrow.setName("Sword of Might");


        ArrayList<Gear> test = new ArrayList<Gear>();

        testChar.addGear(helmOfSorrow);
        testChar.addGear(helmOfAnger);
        testChar.addGear(swordOfMight);


        test.add(helmOfSorrow);
        test.add(helmOfAnger);
        test.add(swordOfMight);

        assertEquals(test, testChar.getInvetory());



    }

    @Test
    public void addRemoveGear() throws Exception {
        Character testChar = new Character();

        Gear helmOfSorrow =  new Gear();
        helmOfSorrow.setName("helm of Sorrow");
        testChar.addGear(helmOfSorrow);


        assertSame(helmOfSorrow, testChar.getInvetory().get(0));


        testChar.removeGear(helmOfSorrow);

        assertNull(testChar.getInvetory());

    }

    @Test
    public void equipItem() throws Exception {
        Character testChar = new Character();

        Gear helmOfSorrow =  new Gear();
        helmOfSorrow.setName("helm of Sorrow");
        testChar.equipItem(helmOfSorrow);

        assertSame(helmOfSorrow, testChar.getActiveGear().get(0));

        Gear helmOfAnger =  new Gear();
        helmOfSorrow.setName("helm of Anger");
        testChar.equipItem(helmOfAnger);

        assertSame(helmOfAnger, testChar.getActiveGear().get(0));
        assertSame(helmOfSorrow, testChar.getInactiveGear().get(0));

    }

    @Test
    public void retrieveGearInCategory() throws Exception {
        Character testChar = new Character();

        Gear helmOfSorrow =  new Gear();
        helmOfSorrow.setName("helm of Sorrow");

        Gear helmOfAnger =  new Gear();
        helmOfSorrow.setName("helm of Anger");

        Gear swordOfMight =  new Gear();
        helmOfSorrow.setName("Sword of Might");


        testChar.addGear(helmOfSorrow);
        testChar.addGear(helmOfAnger);
        testChar.addGear(swordOfMight);

        ArrayList<Gear> listOfHelms = new ArrayList<Gear>();
        listOfHelms.add(helmOfSorrow);
        listOfHelms.add(helmOfAnger);

        assertEquals(listOfHelms, testChar.retrieveGearInCategory("Helm"));



    }

}