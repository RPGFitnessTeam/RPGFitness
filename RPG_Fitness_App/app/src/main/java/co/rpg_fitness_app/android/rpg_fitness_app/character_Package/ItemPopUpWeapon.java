package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by awhit on 3/13/2017.
 */
public class ItemPopUpWeapon extends Activity {

    // TODO: replace with consistent character object from DB
    Character character = new Character();

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.character_item_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;


        getWindow().setLayout( (int) (width*0.8), (int) (height*0.5));

        //Adapter used to display list's data (in this case a list of helms the player owns)
        //ArrayAdapter<Gear> items = new ArrayAdapter<Gear>(this, R.layout.character_item_popup,
        //        R.id.item_textView, character.retrieveGearInCategory("Helm"));

        String[] Weapons = {"Frostmourne", "Oath Keeper"};




        //TODO implement changing the DB according to what item was selected in menu
        /*listview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long ID) {
                //TODO update DB according to the new species chosen
                //TODO update the img file according to the new species chosen
            }

            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });*/

    }

}
