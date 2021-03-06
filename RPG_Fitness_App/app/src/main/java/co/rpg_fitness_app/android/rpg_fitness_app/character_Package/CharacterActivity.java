package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.textservice.SpellCheckerInfo;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.FitnessLogActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.GoalActive;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.TipMaster;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.KingdomActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.quest_Package.QuestActivity;

/**
 * Created by awhit on 3/13/2017.
 */

public class CharacterActivity extends Activity{

    TextView nameText;
    TextView goldText;
    TextView stoneText;
    TextView woodText;
    AlertDialog enterName;
    EditText editName;
    DataSource mDataSource;
    ArrayList<String> speciesList;
    ArrayList<Species> speciesAL;
    Character character;
    int rogueSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_screen);

        mDataSource = new DataSource(this);
        mDataSource.open();

        // retrieve character from data source
        character = mDataSource.getAllCharacters().get(0);

        // set character name view to proper name
        nameText = (TextView) findViewById(R.id.textView_charName);
        nameText.setText(character.getName());

        // sets up enter name pop up
        enterName = new AlertDialog.Builder(this).create();
        editName = new EditText(this);

        // sets title of dialogue
        enterName.setTitle("Enter your Character's name");
        enterName.setView(editName);

        rogueSpinner = 0;

        goldText = (TextView) findViewById(R.id.textGold);
        goldText.setText(""+character.getCurrency().getGold());

        woodText = (TextView) findViewById(R.id.textWood);
        woodText.setText(""+character.getCurrency().getWood());

        stoneText = (TextView) findViewById(R.id.textRock);
        stoneText.setText(""+character.getCurrency().getStone());






        // sets up the proper components of the species drop down menu
        final Spinner speciesSpinner = (Spinner) findViewById(R.id.spinnerSpecies);

        // sets name of species for spinner
        speciesAL = mDataSource.getAllSpecies();
        speciesAL.add(0, null);
        speciesList = new ArrayList<String>();

        if(character.getSpecies() == null) {
            character.setSpecies(speciesAL.get(1));
        }

        speciesList.add("Species: " + character.getSpecies().getName());


        for(int i = 1; i < speciesAL.size(); i++) {
            speciesList.add(speciesAL.get(i).getName());
        }


        ImageView charImg = (ImageView) findViewById(R.id.characterImage);
        if(character.getSpecies().getName().equals("Elf")) {
            charImg.setImageResource(R.drawable.c_elf);
        }
        else if(character.getSpecies().getName().equals("Orc")) {
            charImg.setImageResource(R.drawable.c_orc);
        }
        else if(character.getSpecies().getName().equals("Human")) {
            charImg.setImageResource(R.drawable.c_anime);
        }
        else if(character.getSpecies().getName().equals("Dwarf")) {
            charImg.setImageResource(R.drawable.c_dwarf);
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
            final ImageView charImg = (ImageView) findViewById(R.id.characterImage);
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long ID) {
                if(rogueSpinner != 0) {
                    if(pos != 0) {
                        character.setSpecies(speciesAL.get(pos));
                        if (character.getSpecies().getName().equals("Elf")) {
                            charImg.setImageResource(R.drawable.c_elf);
                        } else if (character.getSpecies().getName().equals("Orc")) {
                            charImg.setImageResource(R.drawable.c_orc);
                        } else if (character.getSpecies().getName().equals("Human")) {
                            charImg.setImageResource(R.drawable.c_anime);
                        } else if (character.getSpecies().getName().equals("Dwarf")) {
                            charImg.setImageResource(R.drawable.c_dwarf);
                        }

                        Log.d("string", speciesAL.get(pos).getName());
                        mDataSource.updateCharacter(character);
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                }
                else {
                    rogueSpinner++;
                }

            }

            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }

        });

        configureToolBarButtons();
    }

    private void configureToolBarButtons() {
        ImageButton b;
        b = (ImageButton) findViewById(R.id.questFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CharacterActivity.this, QuestActivity.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.fitnessLogFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CharacterActivity.this, FitnessLogActivity.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.tipsFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CharacterActivity.this, TipMaster.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.kingdomFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CharacterActivity.this, KingdomActivity.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.goalsFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CharacterActivity.this, GoalActive.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.characterFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CharacterActivity.this, CharacterActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}
