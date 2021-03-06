package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by awhit on 3/11/2017.
 */

public class Species implements Serializable{


    private String name;
    private String description;
    private String ID;
    private String imageName;

    // default constructor
    public Species()
    {
        name = "Stark";
        description = "A man of the North";
        ID = UUID.randomUUID().toString();
        imageName = null;
    }

    public Species(String name, String description, String ID, String imageName)
    {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.imageName = imageName;
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

    public String getImageName() { return imageName; }

    public void setImageName(String imageName) { this.imageName = imageName; }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }



}
