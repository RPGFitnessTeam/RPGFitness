package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import java.util.UUID;

/**
 * Created by awhit on 3/11/2017.
 */

public class Species {


    private String name;
    private String description;
    private String ID;


    // default constructor
    public Species()
    {
        name = null;
        description = null;
        ID = UUID.randomUUID().toString();
    }


    // getters and setters
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



    public String getID()
    {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }



}
