package com.tannerowens.healthandfitnessrpg;

import java.util.ArrayList;

/**
 * Created by Tanner on 3/9/2017.
 * Class for buildings. Each tile can have up to one building associated with it. Each building has
 * a cost associated to construct/upgrade. Each building once built offers benefits by increasing
 * the amount of a resource you may receive from a quest.
 */

public class Building {

    String name;//Name of the building.
    ArrayList<Currency> cost;//Cost of the building upgrade in various resources.
    String category;//Buildings fall into specific categories and can be upgraded within that category.
    int tier;//Buildings must be upgraded in order, the tier number determines which building comes next in the series
    ArrayList<Boost> boost;//Additional perks of owning this building.


    public Building(String name) {
        if (name == "building1"){
            this.name = name;
            this.cost = db.getCurrencyforthisshit;
            this.category = "category1";
            this.tier = 1;
            this.boost = new ArrayList<Boost>();
        }
        else if (name == "building2"){
            this.name = name;
            this.cost = new ArrayList<Currency>(100);
            this.category = "category2";
            this.tier = 1;
            this.boost = new ArrayList<Boost>();
        }
        else if (name == "building3"){
            this.name = name;
            this.cost = new ArrayList<Currency>(100);
            this.category = "category3";
            this.tier = 1;
            this.boost = new ArrayList<Boost>();
        }
    }

    public Building(String name, ArrayList<Currency> cost, String category, int tier, ArrayList<Boost> boost){
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.tier = tier;
        this.boost = boost;
    }

    public void upgradeBuilding(){
        this.setTier(this.getTier() + 1);
        this.setBoost(this.getBoost().add(new Boost()));
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

    public ArrayList<Boost> getBoost() {
        return boost;
    }

    public void setBoost(ArrayList<Boost> boost) {
        this.boost = boost;
    }
}
