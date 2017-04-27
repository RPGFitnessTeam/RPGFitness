package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.style.ParagraphStyle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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
public class ItemPopUpChest extends Activity {

    Character character;
    DataSource mDataSource;
    ArrayList<Gear> chestList;
    ArrayList<Button> buttons;
    Gear equipped;
    int indexOfEquipped;

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


        // retrieve all chests from the DB
        chestList = new ArrayList<Gear>();
        for (int i = 0; i < gearList.size(); i++) {
            if (gearList.get(i).getCategory().equals("Chest") && gearList.get(i).isOwned() ==  true) {
                if(gearList.get(i).isEquipped() == true) {
                    Log.d("index 0", "equipped chest : " + gearList.get(i).getName());
                    indexOfEquipped = i;
                    chestList.add(0,gearList.get(i));
                }
                else {
                    Log.d("index not 0", "not equipped chest : " + gearList.get(i).getName());
                    chestList.add(gearList.get(i));
                }
            }
        }


        // checks if no item is eqquipped, set top item to equipped if so
        if(character.getActiveGear().get(0) == null) {
            indexOfEquipped = 0;
            character.equipItem(chestList.get(0));
            mDataSource.updateGear(gearList.get(0));
            equipped = gearList.get(0);
        }


        TableLayout table = (TableLayout) findViewById(R.id.TableLayout);
        for (int i = 0; i < chestList.size(); i++) {

            // get item name
            TableRow newRow = new TableRow(this);
            TableRow.LayoutParams MPparam =
                    new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
            newRow.setLayoutParams(MPparam);

            // set up item button
            Button button = new Button(this);
            button.setId(i);

            final int index = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    character.equipItem(chestList.get(index));
                    mDataSource.updateGear(chestList.get(indexOfEquipped));
                    mDataSource.updateGear(chestList.get(index));
                    mDataSource.updateCharacter(character);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);

                }
            });


            // sets the name of the button
            if(i == 0)
            {
                Log.d("change button text", "set text " + chestList.get(index).getName());
                button.setText(chestList.get(index).getName() + " (Eq.)");
            }
            else
            {
                button.setText(chestList.get(i).getName());
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
