package com.tannerowens.healthandfitnessrpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by Tanner on 3/9/2017.
 * KingdomActivity allows user to view and manipulate their kingdom.
 */

public class KingdomActivity extends Activity {

    Kingdom kingdom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kingdom_view);

        this.kingdom = (Kingdom) getIntent().getSerializableExtra("kingdom");
        configureBackButton();
        populateKingdomTiles();
    }

    private void configureBackButton() {
        Button backButton = (Button) findViewById(R.id.home);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        Building building = tile.getMyBuilding();
        tileButton = getTileButton(tileNumber);
        //CASE mystery tile
        if (tile.isLocked){
            tileButton.setBackgroundResource(R.drawable);
            tileButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(KingdomActivity.this, TilePopUp.class);
                    intent.putExtra("tile", t);
                    startActivityForResult(intent, 1);
                }
            });
        }
        //CASE empty tile
        else if(building == null){
            tileButton.setBackgroundResource(R.drawable);
            tileButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(KingdomActivity.this, MysteryPopUp.class);
                    intent.putExtra("tile", t);
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
                    startActivityForResult(intent, 3);
                }
            });
        }
    }

    /**
     * function changes image of tiles to corresponding tile, mystery, building based on users changes
     * after a tile has been clicked on (ie upgrades, unlocks, new buildings)
     * @param requestCode
     * @param resultCode
     * @param data
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //result code of 1 indicates successful transaction else do nothing
        ImageButton tileButton;
        if(resultCode == 1) {
            Tile tile = (Tile) data.getSerializableExtra("tile");
            int tileNumber = tile.getTileNumber();
            Building building = tile.getMyBuilding();
            tileButton = getTileButton(tileNumber);
            if (requestCode == 1) {
                tileButton.setBackgroundResource(R.drawable);//set as open tile
            }
            else {
                String buildingName = building.getName();
                setBuildingImage(tileButton, buildingName);
                ////ONLY NEED THESE IF WE ARE CHANGING BUILDING IMAGE ON UPGRADE///
                if (requestCode == 2) {

                }
                else if (requestCode == 3) {

                }
            }
        }
    }

    private ImageButton getTileButton(int tileNumber){
        ImageButton tileButton;
        switch (tileNumber) {
            case 1:
                tileButton = (ImageButton) findViewById(R.id.tileButton1);
                break;

            case 2:
                tileButton = (ImageButton) findViewById(R.id.tileButton2);
                break;

            case 3:
                tileButton = (ImageButton) findViewById(R.id.tileButton3);
                break;
            case 4:
                tileButton = (ImageButton) findViewById(R.id.tileButton4);
                break;

            default:
                tileButton = null;
                break;
        }
        return tileButton;
    }

    private void setBuildingImage(ImageButton tileButton, String buildingName){
        switch (buildingName) {
            case "building1":
                tileButton.setBackgroundResource(R.drawable);
                break;

            case "building2":
                tileButton.setBackgroundResource(R.drawable);
                break;

            case "building3":
                tileButton.setBackgroundResource(R.drawable);
                break;

            default:
                tileButton.setBackgroundResource(R.drawable);
                break;
        }
    }

    /*private void configureMysteryButton(int tileNumber, Tile tile){
        final Tile t = tile;
        ImageButton mysteryButton;
        switch (tileNumber) {
            case 1:
                mysteryButton = (ImageButton) findViewById(R.id.mysteryButton1);
                break;

            case 2:
                mysteryButton = (ImageButton) findViewById(R.id.mysteryButton2);
                break;

            case 3:
                mysteryButton = (ImageButton) findViewById(R.id.mysteryButton3);
                break;
            case 4:
                mysteryButton = (ImageButton) findViewById(R.id.mysteryButton4);
                break;

            default:
                mysteryButton = null;
                break;
        }
        mysteryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(KingdomActivity.this, MysteryPopUp.class);
                intent.putExtra("tile", t);
                startActivity(intent);
            }
        });
    }

    private void configureBuildingButton(int tileNumber, Tile tile){
        final Tile t = tile;
        ImageButton buildingButton;
        switch (tileNumber) {
            case 1:
                buildingButton = (ImageButton) findViewById(R.id.buildingButton1);
                break;

            case 2:
                buildingButton = (ImageButton) findViewById(R.id.buildingButton2);
                break;

            case 3:
                buildingButton = (ImageButton) findViewById(R.id.buildingButton3);
                break;
            case 4:
                buildingButton = (ImageButton) findViewById(R.id.buildingButton4);
                break;

            default:
                buildingButton = null;
                break;
        }
        buildingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(KingdomActivity.this, BuildingPopUp.class);
                intent.putExtra("tile", t);
                startActivity(intent);
            }
        });
    }*/

}
