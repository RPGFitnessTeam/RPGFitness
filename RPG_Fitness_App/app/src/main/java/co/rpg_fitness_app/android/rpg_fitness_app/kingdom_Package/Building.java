package co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package;

import java.io.Serializable;
import java.util.UUID;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Boost;

public class Building implements Serializable {

    String id;
    String name;//Name of the building.
    Currency cost;//Cost of the building upgrade in various resources.
    String category;//Buildings fall into specific categories and can be upgraded within that category.
    int tier;//Buildings must be upgraded in order, the tier number determines which building comes next in the series
    Boost goldBoost;//gold boost perk
    Boost woodBoost;//wood boost perk
    Boost stoneBoost;//stone boost perk

    public Building() {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.cost = new Currency();
        this.category = "";
        this.tier = 1;
        this.goldBoost = new Boost();
        this.woodBoost = new Boost();
        this.stoneBoost = new Boost();
    }

    //used for unit tests
    public Building(String name) {
        this.id = UUID.randomUUID().toString();
        if (name == "house"){
            this.name = name;
            this.cost = new Currency();
            this.category = "dwelling";
            this.tier = 1;
            this.goldBoost = null;
            this.woodBoost = null;
            this.stoneBoost = null;
        }
        else if (name == "wood bridge"){
            this.name = name;
            this.cost = new Currency();
            this.category = "bridge";
            this.tier = 1;
            this.goldBoost = null;
            this.woodBoost = null;
            this.stoneBoost = null;
        }
        else if (name == "cave"){
            this.name = name;
            this.cost = new Currency();
            this.category = "mining";
            this.tier = 1;
            this.goldBoost = null;
            this.woodBoost = null;
            this.stoneBoost = null;
        }
    }

    public Building(String name, Currency cost, String category, int tier, Boost goldBoost, Boost woodBoost, Boost stoneBoost){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.tier = tier;
        this.goldBoost = goldBoost;
        this.woodBoost = woodBoost;
        this.stoneBoost = stoneBoost;
    }

    public void upgradeBuilding(){
        this.setTier(this.getTier() + 1);
        this.goldBoost.updateBoost(1);
        this.woodBoost.updateBoost(1);
        this.stoneBoost.updateBoost(1);
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

    public void setCost(Currency cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public Boost getGoldBoost() {
        return this.goldBoost;
    }

    public Boost getWoodBoost() {
        return this.woodBoost;
    }

    public Boost getStoneBoost() {
        return this.stoneBoost;
    }

    public void setGoldBoost(Boost boost) {
        this.goldBoost = boost;
    }

    public void setWoodBoost(Boost boost) {
        this.woodBoost = boost;
    }

    public void setStoneBoost(Boost boost) {
        this.stoneBoost = boost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
