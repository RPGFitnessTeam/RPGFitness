package co.rpg_fitness_app.android.rpg_fitness_app;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tanner on 3/12/2017.
 */
public class TileTest {
    @Test
    public void isLocked() throws Exception {
        Tile tileTest = new Tile(false, new Building("building1"));
        assertFalse(tileTest.isLocked());
    }

    @Test
    public void setLocked() throws Exception {
        Tile tileTest = new Tile(false, new Building("building1"));
        tileTest.setLocked(true);
        assertTrue(tileTest.isLocked());
    }

    @Test
    public void getMyBuilding() throws Exception {
        Building b = new Building("building1");
        Tile tileTest = new Tile(false, b);
        assertSame(b, tileTest.getMyBuilding());
    }

    @Test
    public void setMyBuilding() throws Exception {
        Tile tileTest = new Tile(false, new Building("building1"));
        Building b = new Building("building1");
        tileTest.setMyBuilding(b);
        assertSame(b, tileTest.getMyBuilding());
    }

    @Test
    public void getTileCost() throws Exception {
        Tile tileTest = new Tile(false, new Building("building1"));
        Currency c = new Currency(1, "wood");
        tileTest.setTileCost(c);
        assertSame(c, tileTest.getTileCost());
    }

    @Test
    public void setTileCost() throws Exception {
        Tile tileTest = new Tile(false, new Building("building1"));
        Currency c = new Currency(1, "wood");
        tileTest.setTileCost(c);
        assertSame(c, tileTest.getTileCost());
    }

    @Test
    public void getTileNumber() throws Exception {
        Tile tileTest = new Tile(1);
        assertSame(1, tileTest.getTileNumber());
    }

    @Test
    public void setTileNumber() throws Exception {
        Tile tileTest = new Tile(1);
        tileTest.setTileNumber(10);
        assertSame(10, tileTest.getTileNumber());
    }

    @Test
    public void getId() throws Exception {
        Tile tileTest = new Tile(1);
        whatistheid;
        assertSame("test", tileTest.getId());
    }

    @Test
    public void setId() throws Exception {
        Tile tileTest = new Tile(1);
        tileTest.setId("test");
        assertSame("test", tileTest.getId());
    }
}