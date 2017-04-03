package co.rpg_fitness_app.android.rpg_fitness_app;

import org.junit.Test;

import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Boost;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Gear;

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
        ArrayList<Boost> boostTester = new ArrayList<Boost>();
        assertEquals(boostTester, gearTest.getBoost());
    }

    @Test
    public void setBoostList() throws Exception {
        Gear gearTest = new Gear();
        ArrayList<Boost> boostTester = new ArrayList<Boost>();

        Boost helmBoost = new Boost();
        boostTester.add(helmBoost);
        gearTest.setBoost(boostTester.get(0));

        assertEquals(boostTester, gearTest.getBoost());
    }



}