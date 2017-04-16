package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;

/**
 * Created by awhit on 3/13/2017.
 */

public class CharacterActivity extends Activity{

    TextView nameText;
    AlertDialog enterName;
    EditText editName;
    DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_screen);

        mDataSource = new DataSource(this);
        mDataSource.open();

        // retrieve character from data source
        final Character character = mDataSource.getAllCharacters().get(0);

        // set character name view to proper name
        nameText = (TextView) findViewById(R.id.textView_charName);
        nameText.setText(character.getName());

        // sets up enter name pop up
        enterName = new AlertDialog.Builder(this).create();
        editName = new EditText(this);

        // sets title of dialogue
        enterName.setTitle("Enter your Character's name");
        enterName.setView(editName);


        // sets up the proper components of the species drop down menu
        final Spinner speciesSpinner = (Spinner) findViewById(R.id.spinnerSpecies);

        // get species from DB
        final ArrayList<Species> speciesAL = mDataSource.getAllSpecies();
        String[] speciesList = new String[speciesAL.size()];
        for(int i = 0; i < speciesAL.size(); i++) {
            speciesList[i] = speciesAL.get(i).getName();
        }

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, speciesList);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speciesSpinner.setAdapter(myAdapter);




        Button helm = (Button) findViewById(R.id.button_helm);
        Button chest = (Button) findViewById(R.id.button_chest);
        Button weapon = (Button) findViewById(R.id.button_Weapon);
        Button offHand = (Button) findViewById(R.id.button_offhand);
        Button legs = (Button) findViewById(R.id.button_Legs);



        helm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CharacterActivity.this, ItemPopUpHelm.class));
            }
        });

        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CharacterActivity.this, ItemPopUpChest.class));
            }
        });

        weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CharacterActivity.this, ItemPopUpWeapon.class));
            }
        });

        offHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CharacterActivity.this, ItemPopUpOffHand.class));
            }
        });

        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CharacterActivity.this, ItemPopUpLegs.class));
            }
        });



        // allows the user to enter there name at any time, with a max of 20 char
        enterName.setButton(DialogInterface.BUTTON_POSITIVE, "SAVE TEXT",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //checks the names length and adjusts it down to 20 characters
                        String name = editName.getText().toString();
                        if(name.length() > 20) {
                            name = name.substring(0, 20);
                        }
                        nameText.setText(name);

                        // sets the character name in the DB
                        character.setName(name);

                        mDataSource.updateCharacter(character);
                    }

        });

        // listener for edit name text box, brings up dialog box
        nameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viw) {
                editName.setText(nameText.getText());
                enterName.show();
            }
        });


        //listener for the species drop down menu
        speciesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long ID) {
                character.setSpecies(speciesAL.get(pos));
                // TODO update char breaks app
                // mDataSource.updateCharacter(character);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }

        });
    }

}
