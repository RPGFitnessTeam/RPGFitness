package co.rpg_fitness_app.android.rpg_fitness_app;

import junit.framework.Assert;

import org.junit.Test;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Boost;


import static org.junit.Assert.*;

/**
 * Created by awhit on 3/11/2017.
 */
public class BoostTest {
    @Test
    public void getDefaultAmount() throws Exception {
        Boost boostTest = new Boost();
        assertEquals(0.0, boostTest.getAmount(), 0.0);
    }

    @Test
    public void setAmount() throws Exception {
        Boost boostTest = new Boost();
        boostTest.setAmount(100);
        assertEquals( 100.0, boostTest.getAmount(), 0.0);
    }

    @Test
    public void getDefaultBoostType() throws Exception {
        Boost boostTest = new Boost();
        assertNull(boostTest.getBoostType());
    }

    @Test
    public void setBoostType() throws Exception {
        Boost boostTest = new Boost();
        boostTest.setBoostType("wood");
        assertSame("wood", boostTest.getBoostType());
    }

    @Test
    public void updateNegativeBoost() throws Exception {
        Boost boostTest = new Boost();
        boostTest.setAmount(100);
        boostTest.updateBoost(-50);
        assertEquals(50, boostTest.getAmount(), 0);
    }

    @Test
    public void updatePositiveBoost() throws Exception {
        Boost boostTest = new Boost();
        boostTest.setAmount(100);
        boostTest.updateBoost(50);
        assertEquals(150, boostTest.getAmount(), 0);
    }


    @Test
    public void setGetID() throws Exception {
        Boost boostTest = new Boost();
        boostTest.setID("123");
        Assert.assertEquals("123",boostTest.getID());
    }

}