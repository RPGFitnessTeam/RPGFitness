package co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Tanner on 3/9/2017.
 * Class for a tile. Each Kingdom will have a grid of tiles. The tiles will either be locked or
 * unlocked. If locked the tile will have a cost associated to unlock the tile. Additionally, a tile
 * can contain a building or be blank
 */

public class Tile implements Serializable {

    String id;
    boolean isLocked;//Whether the tile is locked or unlocked. Determines whether a building can exist.
    Building myBuilding;//Instance of a Building object associated with this tile.
    Currency tileCost;//Cost to unlock this tile using Currency object.
    int tileNumber;

    public Tile(){
        this.id = UUID.randomUUID().toString();
        this.isLocked = true;
        this.myBuilding = null;
        this.tileCost = new Currency();
        this.tileNumber = 0;
    }

    public Tile(int tileNumber){
        this.id = UUID.randomUUID().toString();
        this.isLocked = true;
        this.myBuilding = null;
        this.tileCost = new Currency();
        this.tileCost.setGold(1);
        this.tileCost.setWood(1);
        this.tileCost.setStone(1);
        this.tileNumber = tileNumber;
    }

    /**
     * Constructor to create a new tile, initialize the tile to locked/unlocked and associated with
     * a new building. Used in initial startup to give player a starting building. (no cost)
     * @param isLocked false - this is a free tile for user
     * @param myBuilding users initial building (castle)
     */
    public Tile(boolean isLocked, Building myBuilding){
        this.id = UUID.randomUUID().toString();
        this.isLocked = isLocked;
        this.myBuilding = myBuilding;
        this.tileCost = null;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Building getMyBuilding() {
        return myBuilding;
    }

    public void setMyBuilding(Building myBuilding) {
        this.myBuilding = myBuilding;
    }

    public Currency getTileCost() {
        return tileCost;
    }

    public void setTileCost(Currency tileCost) {
        this.tileCost = tileCost;
    }

    public int getTileNumber() {
        return tileNumber;
    }

    public void setTileNumber(int tileNumber) {
        this.tileNumber = tileNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
