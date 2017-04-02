package co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by Tanner on 3/9/2017.
 */

public class BuildingPopUp extends Activity {

    Tile tile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.75), (int)(height*0.75));
        this.tile = (Tile) getIntent().getSerializableExtra("tile");
        
        configureExitButton();
        configureUpgradeButton();
        populateTemplate();
    }

    private void configureExitButton() {
        Button Button = (Button) findViewById(R.id.exitBuildingPopUp);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void configureUpgradeButton() {
        Button Button = (Button) findViewById(R.id.upgradeBuildingButton);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(upgradeBuilding(tile)){
                    Intent resultData = new Intent();
                    resultData.putExtra("tile", tile);
                    setResult(1, resultData);
                }
                finish();
            }
        });
    }


    //TODO fix this method to match data base
    private boolean upgradeBuilding(Tile tile){
        /*Building building = tile.getMyBuilding();
        if(user.getCurrency() > tile.getTileCost()){
            //MAKE FUNCTION TO UPGRADE BUILDING AND KEEP TRACK OF UPGRADES AND STATS
            //THIS FUNCTION SHOULD PROBABLY BE IN BUILDING CLASS
            building.upgradeBuilding();
            user.decreaseCurrency(building.getCost());
            return true;
        } */
        return false;
    }

    //TODO: fix method to reflect changes in the database structure
    private void populateTemplate(){
        Building building = tile.getMyBuilding();
        Currency upgradeCost = tile.getTileCost();
        //String upgradeResource = tile.getTileCost().getResource();
        Button upgradeButton = (Button) findViewById(R.id.upgradeBuildingButton);
        //upgradeButton.setText("Upgrade Cost: "+upgradeCost+" "+upgradeResource);
        TextView name = (TextView) findViewById(R.id.buildingName);
        name.setText(tile.getMyBuilding().getName());
        TextView description = (TextView) findViewById(R.id.buildingDescription);
        description.setText("Tier: "+building.getTier()+"\nBoost: "+building.getBoost()+"\nCategory: "+building.getCategory());
    }
}
