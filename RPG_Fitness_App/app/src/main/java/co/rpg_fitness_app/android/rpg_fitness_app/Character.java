package co.rpg_fitness_app.android.rpg_fitness_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Currency;

public class Character extends AppCompatActivity {

    private String name;
    private Species mySpecies;
    /** arraylist of the character's equiped gear. Gear occurs in the following
     *  order. Helm = 0, Chest = 1, Weapon = 2, Offhand = 3, Legs = 4.
     */
    private ArrayList<Gear> activeGear;
    private ArrayList<Gear> inactiveGear;
    private ArrayList<co.rpg_fitness_app.android.rpg_fitness_app.Currency> moneyChest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
    }

    public Character()
    {
        name = null;
        mySpecies = null;
        activeGear = new ArrayList<Gear>();
        // sets the helm, chest, weapon, offhand and legs slots to null
        activeGear.add(null);
        activeGear.add(null);
        activeGear.add(null);
        activeGear.add(null);
        activeGear.add(null);
        inactiveGear = new ArrayList<Gear>();
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

    public Species getMySpecies() {
        return mySpecies;
    }

    public void setMySpecies(Species mySpecies) {
        this.mySpecies = mySpecies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // returns the entire invetory of a character (both active and inactive gear)
    public ArrayList<Gear> getInvetory()
    {
        ArrayList<Gear> ret = new ArrayList<Gear>();
        ret.addAll(activeGear);
        ret.addAll(inactiveGear);
        return ret;
    }

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


    boolean addGear(Gear newGear)
    {
        boolean ret = false;
        String category = newGear.getCategory();
        if(category == "Helm")
        {
            if(activeGear.get(0) == null)
            {
                activeGear.add(0, newGear);
                ret = true;
            }
        }
        else if(category == "Chest")
        {
            if(activeGear.get(1) == null)
            {
                activeGear.add(1, newGear);
                ret = true;
            }
        }
        else if(category == "Weapon")
        {
            if(activeGear.get(2) == null)
            {
                activeGear.add(2, newGear);
                ret = true;
            }
        }
        else if(category == "OffHand")
        {
            if(activeGear.get(3) == null)
            {
                activeGear.add(3, newGear);
                ret = true;
            }
        }
        else if(category == "Legs")
        {
            if(activeGear.get(4) == null)
            {
                activeGear.add(4, newGear);
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

}
