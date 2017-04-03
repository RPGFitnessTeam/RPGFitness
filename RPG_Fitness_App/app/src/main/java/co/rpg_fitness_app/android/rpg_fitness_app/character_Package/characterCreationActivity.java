package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import java.lang.*;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by Adikan on 3/13/2017.
 * Allows users to customize their name, gear and species for their character. These activities are
 * used in conjunction with the Character class.
 * Code Suggestions from: Android Studio Website, Stack Exchange and tutorials Point
 */

public class characterCreationActivity extends Activity implements AdapterView.OnItemSelectedListener{

    // Creates a Character object that will store the information gathered at launch
    Character playerChar;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /**
         * sets up the spinner and populates the arraylist with the different species
         * the player can choose from. A listener for onItemSelected action is established as well.
         */
        Spinner speciesDropDown = (Spinner) findViewById(R.id.spinner_species);
        speciesDropDown.setOnItemSelectedListener(this);


        // array of species used to populate drop down menu
        String[] speciesList = new String[]{"Female Human", "Male Human", "Female Orc", "Male Orc",
                "Female Dwarf", "Male Dwarf", "Female Elf", "Male Elf"};

        // create an array adapter to place speciesList info into the drop down menu
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item, speciesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speciesDropDown.setAdapter(adapter);


        /**
         * sets up the EditText that will take user input for their character's name.
         * Uses the setName method to change the players name from null to the string chosen
         * by the character
         */

        final EditText charName = (EditText) findViewById(R.id.EditText_charName);
        charName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                playerChar.setName(charName.toString());
                return true;
            }
        });


        Button nextButton = (Button) findViewById(R.id.Button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent characterIntent = new Intent(view.getContext(), CharacterActivity.class);
                startActivityForResult(characterIntent, 0);
            }
        });
    }

    @Override
    // sets the players species based off their selection for the spinner
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String speciesName = parent.getItemAtPosition(position).toString();

        //TODO: retreive species from data base based off the drop down menu selection
        //playerChar.setMySpecies();

    }

    // if nothing is selected set the species to human female.
    public void onNothingSelected(AdapterView<?> arg0) {
        //TODO: retreive default species and set the characters attributes to match
    }




}
