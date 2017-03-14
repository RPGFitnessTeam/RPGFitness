package co.rpg_fitness_app.android.rpg_fitness_app;

import java.util.ArrayList;

/**
 * Created by awhit on 3/11/2017.
 */

public class Gear {


    /**
     * attributes for the Gear class. Each gear object has a name, a category
     * (helm, chest, weapon, offhand and legs), a cost (in the form of an array list so that
     * multiple currencies can be used for one item) and an array list of boosts that designate
     * the positive effects the gear performs.
     */
    private String name;
    private String category;
    private ArrayList<Currency> cost;
    ArrayList<Boost> boost;


    // default constructor
    public Gear()
    {
        name = null;
        category = null;
        //cost = null;
        boost = new ArrayList<>();
    }


    // getters and setters for all the attributes

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


    public ArrayList<Currency> getCost() {
        return cost;
    }

    public void setCost(ArrayList<Currency> cost) {
        this.cost = cost;
    }

    public ArrayList<Boost> getBoost() {
        return boost;
    }

    public void setBoost(ArrayList<Boost> boost) {
        this.boost = boost;
    }

}
