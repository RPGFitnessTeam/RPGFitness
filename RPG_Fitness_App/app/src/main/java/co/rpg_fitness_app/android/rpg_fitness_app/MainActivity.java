package co.rpg_fitness_app.android.rpg_fitness_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

//import javax.sql.DataSource;

import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.CharacterActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.FitnessLogActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.GoalActive;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.MainActivityFitness;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.TipMaster;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Kingdom;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.KingdomActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Tile;
import co.rpg_fitness_app.android.rpg_fitness_app.quest_Package.QuestActivity;

import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Kingdom kingdom;
    private Currency moneyChest;
    private DataSource mDataSource;
    private int KINGDOM_ACTIVITY_RETURN = 1;

    //Buttons on home_screen
    private ImageButton mfitnessLogMainButton;
    private ImageButton mkingdomMainButton;
    private ImageButton mtipsMainButton;
    private ImageButton mquestsMainButton;
    private ImageButton mgoalsMainButton;
    private ImageButton mcharacterMainButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mDataSource = new DataSource(this);
        //mDataSource.upgrade();
        mDataSource.open();
        mDataSource.seedDatabase();
        getKingdom();
        //mDataSource.upgrade();//FOR DB REDO: comment out above 4 lines

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        mfitnessLogMainButton = (ImageButton)findViewById(R.id.fitnessLogMainButton);
        mkingdomMainButton = (ImageButton)findViewById(R.id.kingdomMainButton);
        mtipsMainButton = (ImageButton)findViewById(R.id.tipsMainButton);
        mquestsMainButton = (ImageButton)findViewById(R.id.questsMainButton);
        mgoalsMainButton = (ImageButton)findViewById(R.id.goalsMainButton);
        mcharacterMainButton = (ImageButton)findViewById(R.id.characterMainButton);

        mkingdomMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getKingdom();
                Intent startIntent = new Intent(MainActivity.this, KingdomActivity.class);
                //startIntent.putExtra("kingdom", kingdom);
                //startIntent.putExtra("buildings", mDataSource.getAllBuildings());
                //TODO: startIntent.putExtra("money chest", mDataSource.getCharacter().getCurrency());
                Currency c = new Currency();//TESTING
                c.updateResource(true,10,10,10,1,1,1,1,1);//TESTING
                startIntent.putExtra("money chest", c);//TESTING
                startActivity(startIntent);
                //startActivityForResult(startIntent, KINGDOM_ACTIVITY_RETURN);
            }
        });

        mtipsMainButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(MainActivity.this, TipMaster.class);
                startActivity(startIntent);
            }
        });

        mgoalsMainButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(MainActivity.this, GoalActive.class);
                startActivity(startIntent);
            }
        });


        mcharacterMainButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(MainActivity.this, CharacterActivity.class);
                startActivity(startIntent);
            }
        });
        
        mquestsMainButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(MainActivity.this, QuestActivity.class);
                startActivity(startIntent);
            }
        });

        mfitnessLogMainButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(MainActivity.this, MainActivityFitness.class);
                startActivity(startIntent);
            }
        });

    }

    private void getKingdom() {
        this.kingdom = mDataSource.getAllKingdoms();
        if (this.kingdom == null) {
            this.kingdom = new Kingdom();
            mDataSource.insertKingdom(kingdom);
        }
    }

    /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == KINGDOM_ACTIVITY_RETURN) {
            //kingdom = (Kingdom) data.getSerializableExtra("kingdom");
            //moneyChest = (Currency) data.getSerializableExtra("money chest");
            //mDataSource.insertKingdom(kingdom)?????
            ArrayList<Tile> tiles = mDataSource.getAllTiles();
            for (int i = 0; i < tiles.size(); i++) {
                Log.d("onActivityResult","Tile number: "+tiles.get(i).getTileNumber());
                Log.d("onActivityResult","Tile Building: "+tiles.get(i).getMyBuilding());
                Log.d("onActivityResult","Tile ID: "+tiles.get(i).getId());
            }
        }
    }*/

}
