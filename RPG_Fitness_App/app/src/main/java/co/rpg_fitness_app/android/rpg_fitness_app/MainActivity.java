package co.rpg_fitness_app.android.rpg_fitness_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
//import javax.sql.DataSource;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.CharacterActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.GoalActive;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.TipMaster;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Kingdom;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.KingdomActivity;

//import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;

//import javax.sql.DataSource;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Kingdom kingdom;
    //private DataSource mDataSource;

    //Buttons on home_screen
    private ImageButton mfitnessLogMainButton;
    private ImageButton mkingdomMainButton;
    private ImageButton mtipsMainButton;
    private ImageButton mquestsMainButton;
    private ImageButton mgoalsMainButton;
    private ImageButton mcharacterMainButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //TODO: uncomment once DB is implemented
        /*mDataSource = new DataSource(this);
        mDataSource.open();
        mDataSource.seedDatabase();
        for(int i = 0; i< BuildingDataProvider.buildingList.size(); i++) {
            mDataSource.insertBuilding(BuildingDataProvider.buildingList.get(i));
        }*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        mfitnessLogMainButton = (ImageButton)findViewById(R.id.fitnessLogMainButton);
        mkingdomMainButton = (ImageButton)findViewById(R.id.kingdomMainButton);
        mtipsMainButton = (ImageButton)findViewById(R.id.tipsMainButton);
        mquestsMainButton = (ImageButton)findViewById(R.id.questsMainButton);
        mgoalsMainButton = (ImageButton)findViewById(R.id.goalsMainButton);
        mcharacterMainButton = (ImageButton)findViewById(R.id.characterMainButton);

        kingdom = new Kingdom();//TESTING
        mkingdomMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO start the kingdom activity to create the view
                Intent startIntent = new Intent(MainActivity.this, KingdomActivity.class);
                startIntent.putExtra("kingdom", kingdom);
                startActivity(startIntent);
            }
        });

        //TODO kingdom code
        //getKingdom();
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

    }

    private void getKingdom() {
        //this.kingdom = mDataSource.getAllKingdoms();
        if (this.kingdom == null) {
            this.kingdom = new Kingdom();
        }
    }


}
