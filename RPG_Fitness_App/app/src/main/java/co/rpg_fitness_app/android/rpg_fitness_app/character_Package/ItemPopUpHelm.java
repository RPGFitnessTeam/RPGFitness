package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Character;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Gear;

/**
 * Created by awhit on 3/13/2017.
 */
public class ItemPopUpHelm extends Activity {

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


        ImageButton helm = (ImageButton) findViewById(R.id.imageButtonItem);
        helm.setBackgroundResource(R.drawable.lock_padlock);

        getWindow().setLayout( (int) (width*0.8), (int) (height*0.5));



        //Adapter used to display list's data (in this case a list of helms the player owns)
        //ArrayAdapter<Gear> items = new ArrayAdapter<Gear>(this, R.layout.character_item_popup,
        //        R.id.item_textView, character.retrieveGearInCategory("Helm"));



    }

}
