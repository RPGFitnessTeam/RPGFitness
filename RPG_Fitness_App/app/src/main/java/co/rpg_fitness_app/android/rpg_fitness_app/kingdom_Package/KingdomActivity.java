package co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.CharacterActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.FitnessLogActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.GoalActive;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.TipMaster;
import co.rpg_fitness_app.android.rpg_fitness_app.quest_Package.QuestActivity;

/**
 * Created by Tanner on 3/9/2017.
 * KingdomActivity allows user to view and manipulate their kingdom.
 */

public class KingdomActivity extends Activity {

    Kingdom kingdom;
    ArrayList<Building> buildings;
    Currency moneyChest;
    DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kingdom_main);

        mDataSource = new DataSource(this);
        mDataSource.open();


        //this.kingdom = mDataSource.getAllKingdoms();
        kingdom = new Kingdom();
        this.buildings = mDataSource.getAllBuildings();
        //this.kingdom = (Kingdom) this.getIntent().getSerializableExtra("kingdom");
        //this.buildings = (ArrayList<Building>) this.getIntent().getSerializableExtra("buildings");
        this.moneyChest = (Currency) this.getIntent().getSerializableExtra("money chest");
        configureToolBarButtons();
        populateKingdomTiles();

    }

    //TODO: push moneyChest and kingdom to database when activity is destroyed
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mDataSource.updateKingdom(kingdom);
        mDataSource.updateCurrency(moneyChest);
        /*Intent i = new Intent();
        i.putExtra("kingdom", this.kingdom);
        i.putExtra("money chest", this.moneyChest);
        setResult(1, i);*/
        finish();
    }

    private void configureToolBarButtons() {
        ImageButton b;
        b = (ImageButton) findViewById(R.id.questFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KingdomActivity.this, QuestActivity.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.fitnessLogFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KingdomActivity.this, FitnessLogActivity.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.tipsFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KingdomActivity.this, TipMaster.class);
                startActivity(i);
                finish();
            }
        });
        //b = (ImageButton) findViewById(R.id.kingdomFooterButton);
        b = (ImageButton) findViewById(R.id.goalsFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KingdomActivity.this, GoalActive.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.characterFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KingdomActivity.this, CharacterActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void populateKingdomTiles() {
        ArrayList<Tile> myGrid = kingdom.getMyGrid();
        Tile tile;
        for (int i = 0; i<=19; i++){
            tile = myGrid.get(i);
            configureTileButton(i, tile);
        }
    }

    private void configureTileButton(int tileNumber, Tile tile){
        final Tile t = tile;
        ImageButton tileButton;
        final Building building = tile.getMyBuilding();
        tileButton = getTileButton(tileNumber);
        //CASE mystery tile
        if (tile.isLocked){
           tileButton.setBackgroundResource(R.drawable.lock_padlock);//set as mystery tile
            tileButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(KingdomActivity.this, MysteryPopUp.class);
                    intent.putExtra("tile", t);
                    intent.putExtra("money chest", moneyChest);
                    startActivityForResult(intent, 1);
                }
            });
        }
        //CASE empty tile
        else if(building == null){
            tileButton.setBackgroundResource(R.drawable.unlock_padlock);//set as open tile
            tileButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(KingdomActivity.this, TilePopUp.class);
                    intent.putExtra("tile", t);
                    intent.putExtra("money chest", moneyChest);
                    intent.putExtra("buildings", buildings);
                    startActivityForResult(intent, 2);
                }
            });

        }
        //CASE building tile
        else {
            String buildingName = building.getName();
            setBuildingImage(tileButton, buildingName);
            tileButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(KingdomActivity.this, BuildingPopUp.class);
                    intent.putExtra("tile", t);
                    intent.putExtra("money chest", moneyChest);
                    intent.putExtra("buildings", buildings);
                    startActivityForResult(intent, 3);
                }
            });
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //result code of 1 indicates successful transaction else do nothing
        final Tile tile;
        if(resultCode != 0) {
            tile = (Tile) data.getSerializableExtra("tile");//updated tile
            Log.d("TEST", "CLicked on tile: " +tile.getTileNumber()+"");
            moneyChest = (Currency) data.getSerializableExtra("money chest");//updated money chest
            configureTileButton(tile.getTileNumber(), tile);
            mDataSource.updateTile(tile);
            mDataSource.updateKingdom(kingdom);
        }
    }

    private ImageButton getTileButton(int tileNumber){
        ImageButton tileButton;
        switch (tileNumber) {
            case 0:
                tileButton = (ImageButton) findViewById(R.id.imageButton0);
                break;

            case 1:
                tileButton = (ImageButton) findViewById(R.id.imageButton1);
                break;

            case 2:
                tileButton = (ImageButton) findViewById(R.id.imageButton2);
                break;

            case 3:
                tileButton = (ImageButton) findViewById(R.id.imageButton3);
                break;
            case 4:
                tileButton = (ImageButton) findViewById(R.id.imageButton4);
                break;

            case 5:
                tileButton = (ImageButton) findViewById(R.id.imageButton5);
                break;

            case 6:
                tileButton = (ImageButton) findViewById(R.id.imageButton6);
                break;

            case 7:
                tileButton = (ImageButton) findViewById(R.id.imageButton7);
                break;

            case 8:
                tileButton = (ImageButton) findViewById(R.id.imageButton8);
                break;

            case 9:
                tileButton = (ImageButton) findViewById(R.id.imageButton9);
                break;

            case 10:
                tileButton = (ImageButton) findViewById(R.id.imageButton10);
                break;

            case 11:
                tileButton = (ImageButton) findViewById(R.id.imageButton11);
                break;

            case 12:
                tileButton = (ImageButton) findViewById(R.id.imageButton12);
                break;

            case 13:
                tileButton = (ImageButton) findViewById(R.id.imageButton13);
                break;

            case 14:
                tileButton = (ImageButton) findViewById(R.id.imageButton14);
                break;

            case 15:
                tileButton = (ImageButton) findViewById(R.id.imageButton15);
                break;

            case 16:
                tileButton = (ImageButton) findViewById(R.id.imageButton16);
                break;

            case 17:
                tileButton = (ImageButton) findViewById(R.id.imageButton17);
                break;

            case 18:
                tileButton = (ImageButton) findViewById(R.id.imageButton18);
                break;

            case 19:
                tileButton = (ImageButton) findViewById(R.id.imageButton19);
                break;

            default:
                tileButton = null;
                break;
        }
        return tileButton;
    }

    private void setBuildingImage(ImageButton tileButton, String buildingName){
        switch (buildingName) {
            case "house":
                tileButton.setBackgroundResource(R.drawable.b_dwelling1);
                break;
            case "wood bridge":
                tileButton.setBackgroundResource(R.drawable.b_bridge1);
                break;
            case "cave":
                tileButton.setBackgroundResource(R.drawable.b_mining1);
                break;
            case "tavern":
                tileButton.setBackgroundResource(R.drawable.b_hospitality1);
                break;
            case "fort":
                tileButton.setBackgroundResource(R.drawable.b_military1);
                break;
            case "pond":
                tileButton.setBackgroundResource(R.drawable.b_water1);
                break;
            case "castle":
                tileButton.setBackgroundResource(R.drawable.b_dwelling2);
                break;
            case "stone bridge":
                tileButton.setBackgroundResource(R.drawable.b_bridge2);
                break;
            case "mine":
                tileButton.setBackgroundResource(R.drawable.b_mining2);
                break;
            case "inn and tavern":
                tileButton.setBackgroundResource(R.drawable.b_hospitality2);
                break;
            case "fortress":
                tileButton.setBackgroundResource(R.drawable.b_military2);
                break;
            case "fountain":
                tileButton.setBackgroundResource(R.drawable.b_water2);
                break;
            default:
                tileButton.setBackgroundResource(R.drawable.knight);
                break;
        }
    }

}
