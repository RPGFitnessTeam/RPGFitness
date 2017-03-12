package com.tannerowens.healthandfitnessrpg;

/**
 * Created by Tanner on 3/11/2017.
 * Class for currency types. Currency can be gold, stone, wood, special resources, or gear
 */

public class Currency {
    int amount; //Integer containing the number of a resource within the currency object
    String resource; //String containing the type of resource; e.g. gold, wood, stone, silver spoon

    /**
     * Construct a new currency object with the given amount and resource type
     * @param amount
     * @param resource
     */
    public Currency(int amount, String resource) {
        this.amount = amount;
        this.resource = resource;
    }

    /**
     * Add or subtract the given amount from the current amount
     * Returns true if method succeeds, false otherwise
     * @param amount
     * @return
     */
    public boolean updateResource(int amount){
        this.amount = this.amount - amount;
        return true;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
