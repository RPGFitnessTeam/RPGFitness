package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import java.util.UUID;

/**
 * Created by awhit on 3/11/2017.
 */

public class Boost {



    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBoostType() {
        return boostType;
    }

    public void setBoostType(String boostType) {
        this.boostType = boostType;
    }

    private int amount;
    private String ID;
    private String boostType;

    public Boost(){
        amount = 0;
        boostType = null;
    }

    public boolean setID()
    {
        ID =  UUID.randomUUID().toString();
        return true;
    }

    public boolean updateBoost(int amount)
    {
        this.amount = this.amount + amount;
        return true;
    }

    public String getID()
    {
        //TODO: Implement
        return null;
    }

}
