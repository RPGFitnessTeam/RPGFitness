package co.rpg_fitness_app.android.rpg_fitness_app;

import android.support.v7.app.AppCompatActivity;

import org.junit.Test;
import static org.junit.Assert.*;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Boost;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Building;

/**
 * Created by Austin on 4/6/2017.
 */

/*
Need to add this code to gradle to test with contexts
testOptions {
    unitTests.returnDefaultValues = true
  }
 */

public class DataSourceTest extends AppCompatActivity {
    @Test
    public void insertBoost() throws Exception {
        DataSource mDataSource = new DataSource(this);
        mDataSource.upgrade();

        Boost boost = new Boost();
        mDataSource.insertBoost(boost);

        Boost testBoost = mDataSource.getBoost(boost.getID());
        assertEquals(boost.getID(), testBoost.getID());
        assertEquals(boost.getAmount(), testBoost.getAmount());
        assertEquals(boost.getBoostType(), testBoost.getBoostType());
        mDataSource.close();
    }
    @Test
    public void insertBuilding() throws Exception {
        DataSource mDataSource = new DataSource(this);
        mDataSource.upgrade();

        Building building = new Building();
        mDataSource.insertBuilding(building);

        Building testBuilding = mDataSource.getBuilding(building.getId());
        assertEquals(building.getId(), testBuilding.getId());
        assertEquals(building.getCategory(), testBuilding.getCategory());
        assertEquals(building.getName(), testBuilding.getName());
        assertEquals(building.getImageName(), testBuilding.getImageName());
        mDataSource.close();
    }
    @Test
    public void insertCharacter() throws Exception {

    }
    @Test
    public void insertCurrency() throws Exception {

    }
    @Test
    public void insertGear() throws Exception {

    }
    @Test
    public void insertGoal() throws Exception {

    }
    @Test
    public void insertKingdom() throws Exception {

    }
    @Test
    public void insertLogEntry() throws Exception {

    }
    @Test
    public void insertSpecies() throws Exception {

    }

    @Test
    public void insertTile() throws Exception {

    }

    @Test
    public void insertTip() throws Exception {

    }

    @Test
    public void getAllBoosts() throws Exception {

    }
    @Test
    public void getAllBuildings() throws Exception {

    }
    @Test
    public void getAllCharacters() throws Exception {

    }
    @Test
    public void getAllCurrency() throws Exception {

    }
    @Test
    public void getAllGear() throws Exception {

    }
    @Test
    public void getAllGoals() throws Exception {

    }
    @Test
    public void getAllKingdoms() throws Exception {

    }
    @Test
    public void getAllLogEntries() throws Exception {

    }
    @Test
    public void getAllSpecies() throws Exception {

    }

    @Test
    public void getAllTiles() throws Exception {

    }

    @Test
    public void getAllTips() throws Exception {

    }

    @Test
    public void getBoost() throws Exception {

    }
    @Test
    public void getBuilding() throws Exception {

    }
    @Test
    public void getCharacter() throws Exception {

    }
    @Test
    public void getCurrency() throws Exception {

    }
    @Test
    public void getGear() throws Exception {

    }
    @Test
    public void getGoal() throws Exception {

    }
    @Test
    public void getLogEntry() throws Exception {

    }
    @Test
    public void getSpecies() throws Exception {

    }

    @Test
    public void getTile() throws Exception {

    }

    @Test
    public void getTips() throws Exception {

    }

    @Test
    public void updateCharacter() throws Exception {

    }

    @Test
    public void updateGoal() throws Exception {

    }

    @Test
    public void updateCurrency() throws Exception {

    }

    @Test
    public void updateGear() throws Exception {

    }

    @Test
    public void updateTile() throws Exception {

    }

    @Test
    public void updateKingdom() throws Exception {

    }

}
