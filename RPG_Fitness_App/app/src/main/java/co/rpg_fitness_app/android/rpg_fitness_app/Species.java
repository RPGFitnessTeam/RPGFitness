package co.rpg_fitness_app.android.rpg_fitness_app;

/**
 * Created by awhit on 3/11/2017.
 */

public class Species {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String name;
    private String description;

    public Species()
    {
        name = null;
        description = null;
    }



}
