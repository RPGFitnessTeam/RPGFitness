package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import java.util.ArrayList;
import java.util.UUID;

import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;

public class Character {

    private String name;
    private Species mySpecies;

  

    /** arraylist of the character's equiped gear. Gear occurs in the following
     *  order. Helm = 0, Chest = 1, Weapon = 2, Offhand = 3, Legs = 4.
     */
    private ArrayList<Gear> inventory;
    private ArrayList<Gear> activeGear;
    private ArrayList<Gear> inactiveGear;
    private Currency moneyChest;
    private ArrayList<Boost> activeBoosts;
    private String ID;


    public Character()
    {
        name = null;
        mySpecies = null;
        activeGear = new ArrayList<Gear>();
        inventory = new ArrayList<Gear>();
        // sets the helm, chest, weapon, offhand and legs slots to null
        activeBoosts = new ArrayList<Boost>();
        activeGear.add(null);
        activeGear.add(null);
        activeGear.add(null);
        activeGear.add(null);
        activeGear.add(null);
        inactiveGear = new ArrayList<Gear>();
        ID = UUID.randomUUID().toString();
    }


    // getters and setters for the attributes

  
    public void setinventory(ArrayList<Gear> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Gear> getInactiveGear() {
        return inactiveGear;
    }

    public void setInactiveGear(ArrayList<Gear> inactiveGear) {
        this.inactiveGear = inactiveGear;
    }

    public ArrayList<Gear> getActiveGear() {
        return activeGear;
    }

    public void setActiveGear(ArrayList<Gear> activeGear) {
        this.activeGear = activeGear;
    }

    public Species getSpecies() {
        return mySpecies;
    }

    public void setSpecies(Species mySpecies) {
        this.mySpecies = mySpecies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Boost> getActiveBoosts() {
        return activeBoosts;
    }

    public void setActiveBoosts(ArrayList<Boost> activeBoosts) {
        this.activeBoosts = activeBoosts;
    }

    public Currency getCurrency() {
        return moneyChest;
    }

    public void setCurrency(Currency moneyChest) {
        this.moneyChest = moneyChest;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    // returns the entire inventory of a character (both active and inactive gear)
    public ArrayList<Gear> getInventory()
    {
        return inventory;
    }

    // removes a piece of gear from both the active and inactive gear list
    public boolean removeGear(Gear gearDeleted) {
        boolean succ = false;
        for (int i = 0; i < activeGear.size(); i++) {
            if (activeGear.get(i).equals(gearDeleted)) {
                activeGear.remove(i);
                succ = true;
            }
        }

        for (int i = 0; i < inactiveGear.size(); i++)
        {
            if (inactiveGear.get(i).equals(gearDeleted)) {
                inactiveGear.remove(i);
                succ = true;
            }
        }

        return succ;
    }


    // adds a new piece of gear. First the method checks if the category is already in use and
    // adds it to the corresponding slot if not. If there is already a piece of gear equiped in
    // that slot it adds it to the inactive gear list
    public boolean addGear(Gear newGear)
    {
        boolean ret = false;
        String category = newGear.getCategory();
        if(category == "Helm")
        {
            if(activeGear.get(0) == null)
            {
                activeGear.add(0, newGear);
                activeBoosts.add(newGear.getBoost());
                ret = true;
            }
        }
        else if(category == "Chest")
        {
            if(activeGear.get(1) == null)
            {
                activeGear.add(1, newGear);
                activeBoosts.add(newGear.getBoost());
                ret = true;
            }
        }
        else if(category == "Weapon")
        {
            if(activeGear.get(2) == null)
            {
                activeGear.add(2, newGear);
                activeBoosts.add(newGear.getBoost());
                ret = true;
            }
        }
        else if(category == "OffHand")
        {
            if(activeGear.get(3) == null)
            {
                activeGear.add(3, newGear);
                activeBoosts.add(newGear.getBoost());
                ret = true;
            }
        }
        else if(category == "Legs")
        {
            if(activeGear.get(4) == null)
            {
                activeGear.add(4, newGear);
                activeBoosts.add(newGear.getBoost());
                ret = true;
            }
        }

        if(!ret)
        {
            inactiveGear.add(newGear);
            ret = true;
        }

        return ret;
    }


    // equips the item given in the parameter and places any gear replaced into the inactive gear
    public boolean equipItem(Gear equip)
    {
        boolean ret = false;
        String category = equip.getCategory();
        if(category == "Helm")
        {
            if(activeGear.get(0) == null)
            {
                activeGear.add(0, equip);
                activeBoosts.add(equip.getBoost());
            }
            else
            {
                Gear temp = activeGear.get(0);
                activeGear.remove(0);
                activeGear.add(0, equip);
                activeBoosts.add(equip.getBoost());
                inactiveGear.add(temp);

            }
        }
        else if(category == "Chest")
        {
            if(activeGear.get(1) == null)
            {
                activeGear.add(1, equip);
                activeBoosts.add(equip.getBoost());
            }
            else
            {
                Gear temp = activeGear.get(1);
                activeGear.remove(1);
                activeGear.add(1, equip);
                activeBoosts.add(equip.getBoost());
                inactiveGear.add(temp);

            }
        }
        else if(category == "Weapon")
        {
            if(activeGear.get(2) == null)
            {
                activeGear.add(2, equip);
                activeBoosts.add(equip.getBoost());
            }
            else
            {
                Gear temp = activeGear.get(2);
                activeGear.remove(2);
                activeGear.add(2, equip);
                activeBoosts.add(equip.getBoost());
                inactiveGear.add(temp);

            }
        }
        else if(category == "OffHand")
        {
            if(activeGear.get(3) == null)
            {
                activeGear.add(3, equip);
                activeBoosts.add(equip.getBoost());
            }
            else
            {
                Gear temp = activeGear.get(3);
                activeGear.remove(3);
                activeGear.add(3, equip);
                activeBoosts.add(equip.getBoost());
                inactiveGear.add(temp);

            }
        }
        else if(category == "Legs")
        {
            if(activeGear.get(4) == null)
            {
                activeGear.add(4, equip);
                activeBoosts.add(equip.getBoost());
            }
            else
            {
                Gear temp = activeGear.get(4);
                activeGear.remove(4);
                activeGear.add(4, equip);
                activeBoosts.add(equip.getBoost());
                inactiveGear.add(temp);

            }
        }

        return ret;
    }



    public ArrayList<Gear> retrieveGearInCategory(String category)
    {
        int index = -1;
        if( category == "Helm") index = 0;
        else if( category == "Chest") index = 1;
        else if( category == "Weapon") index = 2;
        else if( category == "OffHand") index = 3;
        else if( category == "Legs") index = 4;

        if(index == -1)
        {
            return null;
        }

        ArrayList<Gear> ret = new ArrayList<Gear>();

        ret.add(activeGear.get(index));

        for(int i = 0; i < inactiveGear.size(); i++)
        {
            if(inactiveGear.get(i).getCategory() == category) ret.add(inactiveGear.get(i));
        }

        return ret;
    }

    // populates the inactive and active gear lists
    public boolean populateLists()
    {
        String category = null;
        int index = -1;

        for(int i = 0; i < inventory.size(); i++)
        {
            if(inventory.get(i).isEquipped() && inventory.get(i).isOwned()) {
                category = inventory.get(i).getCategory();
                if( category == "Helm") index = 0;
                else if( category == "Chest") index = 1;
                else if( category == "Weapon") index = 2;
                else if( category == "OffHand") index = 3;
                else if( category == "Legs") index = 4;

                if(index != -1) activeGear.add(index, inventory.get(i));
            }
            else
            {
                if(inventory.get(i).isOwned() && !inventory.get(i).isEquipped())
                {
                    inactiveGear.add(inventory.get(i));
                }
            }
        }

        return true;

    }

}
