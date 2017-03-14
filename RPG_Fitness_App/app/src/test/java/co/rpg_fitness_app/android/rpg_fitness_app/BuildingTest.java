package co.rpg_fitness_app.android.rpg_fitness_app;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Tanner on 3/12/2017.
 */
public class BuildingTest {
    @Test
    public void upgradeBuilding() throws Exception {
        Currency cur = new Currency(1, "wood");
        ArrayList<Currency> c = new ArrayList<>();
        c.add(cur);
        Boost boo = new Boost();
        ArrayList<Boost> b = new ArrayList<>();
        b.add(boo);
        Building buildingTest = new Building("building1", c, "category1", 1, b);
        buildingTest.upgradeBuilding();
        b.get(0).updateBoost(1);
        assertSame(2, buildingTest.getTier());
        assertSame(b, buildingTest.getBoost());
    }

    @Test
    public void getName() throws Exception {
        Building buildingTest = new Building("building1");
        assertSame("building1", buildingTest.getName());
    }

    @Test
    public void setName() throws Exception {
        Building buildingTest = new Building("building1");
        buildingTest.setName("b");
        assertSame("b", buildingTest.getName());
    }

    @Test
    public void getCost() throws Exception {
        Currency cur = new Currency(1, "wood");
        ArrayList<Currency> c = new ArrayList<>();
        c.add(cur);
        Boost boo = new Boost();
        ArrayList<Boost> b = new ArrayList<>();
        b.add(boo);
        Building buildingTest = new Building("building1", c, "category1", 1, b);
        assertSame(c, buildingTest.getCost());
    }

    @Test
    public void setCost() throws Exception {
        Currency cur = new Currency(1, "wood");
        ArrayList<Currency> c = new ArrayList<>();
        c.add(cur);
        Boost boo = new Boost();
        ArrayList<Boost> b = new ArrayList<>();
        b.add(boo);
        Building buildingTest = new Building("building1", c, "category1", 1, b);
        c.add(new Currency(2, "gold"));
        buildingTest.setCost(c);
        assertSame(c, buildingTest.getCost());
    }

    @Test
    public void getCategory() throws Exception {
        Building buildingTest = new Building("building1");
        buildingTest.setCategory("c");
        assertSame("category1", buildingTest.getCategory());
    }

    @Test
    public void setCategory() throws Exception {
        Building buildingTest = new Building("building1");
        buildingTest.setCategory("c");
        assertSame("c", buildingTest.getCategory());
    }

    @Test
    public void getTier() throws Exception {
        Building buildingTest = new Building("building1");
        assertSame(1, buildingTest.getTier());
    }

    @Test
    public void setTier() throws Exception {
        Building buildingTest = new Building("building1");
        buildingTest.setTier(10);
        assertSame(10, buildingTest.getTier());
    }

    @Test
    public void getBoost() throws Exception {
        Currency cur = new Currency(1, "wood");
        ArrayList<Currency> c = new ArrayList<>();
        c.add(cur);
        Boost boo = new Boost();
        ArrayList<Boost> b = new ArrayList<>();
        b.add(boo);
        Building buildingTest = new Building("building1", c, "category1", 1, b);
        assertSame(b, buildingTest.getBoost());
    }

    @Test
    public void setBoost() throws Exception {
        Currency cur = new Currency(1, "wood");
        ArrayList<Currency> c = new ArrayList<>();
        c.add(cur);
        Boost boo = new Boost();
        ArrayList<Boost> b = new ArrayList<>();
        b.add(boo);
        Building buildingTest = new Building("building1", c, "category1", 1, b);
        b.add(new Boost());
        buildingTest.setBoost(b);
        assertSame(b, buildingTest.getBoost());
    }

    @Test
    public void getId() throws Exception {
        Building buildingTest = new Building("building1");
        missingstepshere;
        assertSame("building1", buildingTest.getId());
    }

    @Test
    public void setId() throws Exception {
        Building buildingTest = new Building("building1");
        buildingTest.setId("id");
        assertSame("id", buildingTest.getId());
    }
}