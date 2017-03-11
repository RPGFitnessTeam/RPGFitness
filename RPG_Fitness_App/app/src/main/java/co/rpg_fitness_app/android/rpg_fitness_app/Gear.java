package co.rpg_fitness_app.android.rpg_fitness_app;

import java.util.ArrayList;

/**
 * Created by awhit on 3/11/2017.
 */

public class Gear {


    private String name;
    private String category;
    //private ArrayList<Currency> cost;
    ArrayList<Boost> boost;


    public Gear()
    {
        name = null;
        category = null;
        //cost = null;
        boost = new ArrayList<>();
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Boost> getBoost() {
        return boost;
    }

    public void setBoost(ArrayList<Boost> boost) {
        this.boost = boost;
    }

}
