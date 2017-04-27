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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;

/**
 * Created by awhit on 3/13/2017.
 */
public class ItemPopUpHelm extends Activity {

    Character character;
    DataSource mDataSource;
    ArrayList<Gear> helmList;
    ArrayList<Button> buttons;

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
            if (gearList.get(i).getCategory().equals("Helm") && gearList.get(i).isOwned() ==  true) {
                Log.d("gear owned", gearList.get(i).getName());
                helmList.add(gearList.get(i));
            }
        }


        // checks if no item is eqquipped, set top item to equipped if so
        if(character.getActiveGear().get(0) == null) {
            character.equipItem(helmList.get(0));
        }


        TableLayout table = (TableLayout) findViewById(R.id.TableLayout);
        for (int i = 0; i < helmList.size(); i++) {

            // get item name
            TableRow newRow = new TableRow(this);
            TableRow.LayoutParams MPparam =
                    new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            newRow.setLayoutParams(MPparam);
            Button button = new Button(this);
            button.setId(i);
            final int index = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Gear eqquiped", helmList.get(index).getName());
                    character.equipItem(helmList.get(index));
                    mDataSource.updateCharacter(character);
                }
            });

            Log.d("Active gear", character.getActiveGear().get(0).getName());
            Log.d("Current GEar", helmList.get(i).getName());
            // sets the name of the button
            if(helmList.get(index).equals(character.getActiveGear().get(0)))
            {
                button.setText(helmList.get(index).getName() + " (Eq.)");
            }
            else
            {
                button.setText(helmList.get(i).getName());
            }

            newRow.addView(button);
            table.addView(newRow);


        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;


        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.5));

    }

}
