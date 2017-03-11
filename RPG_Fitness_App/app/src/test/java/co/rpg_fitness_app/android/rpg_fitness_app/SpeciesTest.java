package co.rpg_fitness_app.android.rpg_fitness_app;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by awhit on 3/11/2017.
 */
public class SpeciesTest {
    @Test
    public void getDefaultName() throws Exception {
        Species testSpecies = new Species();
        assertNull(testSpecies.getName());
    }

    public void getDefaultDescription() throws Exception {
        Species testSpecies = new Species();
        assertNull(testSpecies.getDescription());
    }

    @Test
    public void setName() throws Exception {
        Species testSpecies = new Species();
        testSpecies.setName("orc");
        assertSame("orc", testSpecies.getName());
    }

    @Test
    public void setDescription() throws Exception {
        Species testSpecies = new Species();
        testSpecies.setDescription("A large green humanoid");
        assertSame("A large green humanoid", testSpecies.getDescription());
    }


}