package co.rpg_fitness_app.android.rpg_fitness_app;

import org.junit.Test;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Boost;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Character;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Gear;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;

import static org.junit.Assert.*;

/**
 * Created by awhit on 3/11/2017.
 */
public class GearTest {
    @Test
    public void getDefaultCategory() throws Exception {
        Gear gearTest = new Gear();
        assertNull(gearTest.getCategory());
    }

    @Test
    public void setCategory() throws Exception {
        Gear gearTest = new Gear();
        gearTest.setCategory("helmet");
        assertSame("helmet", gearTest.getCategory());
    }

    @Test
    public void getDefaultName() throws Exception {
        Gear gearTest = new Gear();
        assertNull(gearTest.getName());
    }

    @Test
    public void setName() throws Exception {
        Gear gearTest = new Gear();
        gearTest.setName("helm of Sorrow");
        assertSame("helm of Sorrow", gearTest.getName());
    }

    @Test
    public void getDefaultBoostList() throws Exception {
        Gear gearTest = new Gear();
        assertEquals(null, gearTest.getBoost());
    }


    @Test
    public void getSetOwned() throws Exception {
        Gear gearTest = new Gear();
        gearTest.setOwned(true);
        assertTrue(gearTest.isOwned());

        gearTest.setOwned(false);
        assertFalse(gearTest.isOwned());
    }

    @Test
    public void setGetIsEquipped() throws Exception {
        Gear gearTest = new Gear();
        gearTest.setEquipped(true);
        assertTrue(gearTest.isEquipped());

        gearTest.setEquipped(false);
        assertFalse(gearTest.isEquipped());

    }

    @Test
    public void setGetIsEquippedCharacter() throws Exception {
        Gear gearTest = new Gear();
        gearTest.setCategory("Helm");
        gearTest.setName("test helm");

        Gear gearTest2 = new Gear();
        gearTest2.setCategory("Helm2");
        gearTest2.setName("test helm 2");

        Character testChar = new Character();
        testChar.addGear(gearTest);
        testChar.addGear(gearTest2);

        assertTrue(gearTest.isEquipped());
        assertFalse(gearTest2.isEquipped());
    }


    @Test
    public void setGetIsEquippedEquipOnChar() throws Exception {
        Gear gearTest = new Gear();
        gearTest.setCategory("Helm");
        gearTest.setName("test helm");

        Gear gearTest2 = new Gear();
        gearTest2.setCategory("Helm");
        gearTest2.setName("test helm 2");

        Character testChar = new Character();
        testChar.addGear(gearTest);
        testChar.addGear(gearTest2);

        testChar.equipItem(gearTest2);

        assertFalse(gearTest.isEquipped());
        assertTrue(gearTest2.isEquipped());
    }

    @Test
    public void setGetCurrency() throws Exception {
        Gear gearTest = new Gear();
        Currency curr = new Currency();
        curr.setGold(1);
        gearTest.setCost(curr);

        assertEquals(curr, gearTest.getCost());
    }


    @Test
    public void setGetBoost() throws Exception {
        Gear gearTest = new Gear();
        Boost boost = new Boost();
        boost.setAmount(20.0);
        boost.setBoostType("wood");
        gearTest.setBoost(boost);

        assertEquals(boost, gearTest.getBoost());
    }


    @Test
    public void setGetID() throws Exception {
        Gear gearTest = new Gear();
        gearTest.setID("Test ID");
        String test = "Test ID";
        assertEquals("Test ID", gearTest.getID());
    }




}