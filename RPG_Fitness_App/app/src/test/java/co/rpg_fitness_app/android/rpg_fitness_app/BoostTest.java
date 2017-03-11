package co.rpg_fitness_app.android.rpg_fitness_app;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by awhit on 3/11/2017.
 */
public class BoostTest {
    @Test
    public void getDefaultAmount() throws Exception {
        Boost boostTest = new Boost();
        assertSame(0, boostTest.getAmount());
    }

    @Test
    public void setAmount() throws Exception {
        Boost boostTest = new Boost();
        boostTest.setAmount(100);
        assertSame(100, boostTest.getAmount());
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
        assertEquals(50, boostTest.getAmount());
    }

    @Test
    public void updatePositiveBoost() throws Exception {
        Boost boostTest = new Boost();
        boostTest.setAmount(100);
        boostTest.updateBoost(50);
        assertEquals(150, boostTest.getAmount());
    }

}