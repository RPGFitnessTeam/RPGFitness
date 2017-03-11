package co.rpg_fitness_app.android.rpg_fitness_app;

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
    private String boostType;

    public Boost(){
        amount = 0;
        boostType = null;
    }

    boolean updateBoost(int amount)
    {
        this.amount = this.amount + amount;
        return true;
    }

}
