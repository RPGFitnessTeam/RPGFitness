package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import java.util.ArrayList;
import java.util.UUID;

import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;

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
    private Currency cost;
    private boolean equipped;
    private boolean owned;
    private Boost boost;
    private String ID;


    // default constructor
    public Gear()
    {
        name = null;
        category = null;
        equipped = false;
        boost = null;
        cost = null;
        owned = false;
        ID = UUID.randomUUID().toString();
    }


    // getters and setters for all the attributes

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
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


    public Currency getCost() {
        return cost;
    }

    public void setCost(Currency currency) {
        this.cost = cost;
    }

    public Boost getBoost() {
        return boost;
    }

    public void setBoost(Boost boost) {
        this.boost = boost;
    }

    public String getID()
    {
        return ID;
    }


}
