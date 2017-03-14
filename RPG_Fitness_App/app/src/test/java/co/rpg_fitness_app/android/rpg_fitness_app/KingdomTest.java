package co.rpg_fitness_app.android.rpg_fitness_app;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Tanner on 3/12/2017.
 */
public class KingdomTest {
    //pretty sure I did this wrong
    @Test
    public void getMyGrid() throws Exception {
        Kingdom kingdomTest = new Kingdom();
        ArrayList<Tile> testGrid = kingdomTest.getMyGrid();
        assertSame(testGrid, kingdomTest.getMyGrid());
    }

    @Test
    public void setMyGrid() throws Exception {
        Kingdom kingdomTest = new Kingdom();
        ArrayList<Tile> testGrid = new ArrayList<>();
        testGrid.add(new Tile(false, new Building("building1")));
        kingdomTest.setMyGrid(testGrid);
        assertSame(testGrid, kingdomTest.getMyGrid());
    }

}