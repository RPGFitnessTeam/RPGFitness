package co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tanner on 3/9/2017.
 * An instance of the Kingdom is created upon initial start of the application, and kingdom persists
 * till the end of the life of the application. Each user will have 1 Kingdom with a grid of tiles.
 */

public class Kingdom implements Serializable {

    ArrayList<Tile> myGrid;//2D ArrayList of Tile objects to represent the kingdom map.

    public Kingdom() {
        this.myGrid = new ArrayList<>(20);
        Tile tile;
        for (int i = 0; i<=19; i++){
                tile = new Tile(i);
                myGrid.add(tile);
        }
    }

    public ArrayList<Tile> getMyGrid() {

        return myGrid;
    }

    public void setMyGrid(ArrayList<Tile> myGrid) {

        this.myGrid = myGrid;
    }
}
