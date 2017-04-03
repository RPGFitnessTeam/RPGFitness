package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import java.util.UUID;

/**
 * Created by awhit on 3/11/2017.
 */

public class Boost {


    private double amount;
    private String ID;
    private String boostType;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBoostType() {
        return boostType;
    }

    public void setBoostType(String boostType) {
        this.boostType = boostType;
    }


    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID()
    {
        return ID;
    }


    public Boost(){
        amount = 0;
        boostType = null;
        ID =  UUID.randomUUID().toString();
    }



    public boolean updateBoost(double amount)
    {
        this.amount = this.amount + amount;
        return true;
    }




}
