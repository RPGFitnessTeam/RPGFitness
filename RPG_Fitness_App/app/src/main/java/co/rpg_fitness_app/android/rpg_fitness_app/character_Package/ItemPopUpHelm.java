package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Character;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Gear;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;

/**
 * Created by awhit on 3/13/2017.
 */
public class ItemPopUpHelm extends Activity {

    Character character;
    DataSource mDataSource;
    ArrayList<Gear> helmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDataSource = new DataSource(this);
        mDataSource.open();

        setContentView(R.layout.character_item_popup);

        TableLayout tableL = (TableLayout) findViewById(R.id.TableLayout);


        // initialise variables from DB
        final ArrayList<Gear> gearList = mDataSource.getAllGear();
        character = mDataSource.getAllCharacters().get(0);


        // retrieve all helms from the DB
        helmList = new ArrayList<Gear>();
        for (int i = 0; i < gearList.size(); i++) {
            if (gearList.get(i).getCategory().equals("Helm")) {
                helmList.add(gearList.get(i));
            }
        }


        // checks if no item is eqquipped, set top item to eqquipped if so
        if(character.getActiveGear().get(0) == null) {
            character.equipItem(helmList.get(0));
        }



        // TODO find a way to make this list dynamic so that the size of the helm list
        // TODO does not have to match the iterator #
        for (int i = 0; i < 2; i++) {
            // get item name
            TableRow row = (TableRow) tableL.getChildAt(i * 2);
            TextView itemName = (TextView) row.getChildAt(0);



            if(helmList.get(i).equals(character.getActiveGear().get(0))) {
                itemName.setText(helmList.get(i).getName() + " (Eq.)");
            }
            else {
                itemName.setText(helmList.get(i).getName());
            }

        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;


        ImageButton helm1 = (ImageButton) findViewById(R.id.imageButtonItem);
        ImageButton helm2 = (ImageButton) findViewById(R.id.imageButtonItem2);

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.5));


        // equips the 1st helmet
        helm1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                character.equipItem(helmList.get(0));
                mDataSource.updateCharacter(character);
            }

        });


        // equips the 2nd helmet
        helm2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                character.equipItem(helmList.get(1));
                mDataSource.updateCharacter(character);
            }

        });


    }

}
