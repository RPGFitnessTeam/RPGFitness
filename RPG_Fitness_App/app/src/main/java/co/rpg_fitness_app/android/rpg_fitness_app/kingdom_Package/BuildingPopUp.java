package co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Boost;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;

/**
 * Created by Tanner on 3/9/2017.
 */

public class BuildingPopUp extends Activity {

    Tile tile;
    Currency moneyChest;
    ArrayList<Building> buildings;
    DataSource mDataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        mDataSource = new DataSource(this);
        mDataSource.open();

        getWindow().setLayout((int)(width*0.75), (int)(height*0.75));
        this.tile = (Tile) getIntent().getSerializableExtra("tile");
        this.moneyChest = (Currency) getIntent().getSerializableExtra("money chest");
        this.buildings = (ArrayList<Building>) getIntent().getSerializableExtra("buildings");
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
                    resultData.putExtra("money chest", moneyChest);
                    setResult(1, resultData);
                    finish();
                }
                else {
                    setResult(0,null);
                    finish();
                }
            }
        });
    }

    private boolean upgradeBuilding(Tile tile){
        /////////HARDCODING///////////////
        String name; Currency cost = new Currency(); String category; int tier; Boost goldBoost = new Boost(); Boost woodBoost = new Boost(); Boost stoneBoost = new Boost();
        Building house, castle, woodBridge, stoneBridge, cave, mine, tavern, innAndTavern, fort, fortress, pond, fountain;
        goldBoost.setBoostType("gold"); woodBoost.setBoostType("wood");stoneBoost.setBoostType("stone");
        //////////////////////////////////
        Building newBuilding;
        String newBuildingName;
        Building building = tile.getMyBuilding();
        Currency buildingCost = building.getCost();
        switch (building.getName()){
            case "house": newBuildingName =  "castle";
                /////////HARDCODING///////////////
                name = "castle";
                cost = new Currency();
                cost.updateResource(true,5,0,0,0,0,0,0,0);
                category = "dwelling";
                tier = 2;
                goldBoost.setAmount(2);
                woodBoost.setAmount(0);
                stoneBoost.setAmount(0);
                /////////////////////////////////
                break;
            case "wood bridge": newBuildingName =  "stone bridge";
                break;
            case "cave": newBuildingName =  "mine";
                break;
            case "tavern": newBuildingName =  "inn and tavern";
                break;
            case "fort": newBuildingName =  "fortress";
                break;
            case "pond": newBuildingName =  "fountain";
                break;
            default: return false;
        }
        //////////////TEMP FIX FOR DB PROBLEMS/////////////
        newBuilding = new Building(newBuildingName);
        buildingCost = newBuilding.getCost();
        ///////////////////////////////////////////////////
        if(moneyChest.getWood()>=buildingCost.getWood() && moneyChest.getGold()>=buildingCost.getGold() && moneyChest.getStone()>=buildingCost.getStone() &&
                moneyChest.getMisc1()>=buildingCost.getMisc1() && moneyChest.getMisc2()>=buildingCost.getMisc2() && moneyChest.getMisc3()>=buildingCost.getMisc3() &&
                moneyChest.getMisc1()>=buildingCost.getMisc5() && moneyChest.getMisc1()>=buildingCost.getMisc5()) {
            moneyChest.updateResource(false, buildingCost.getWood(), buildingCost.getGold(), buildingCost.getStone(), buildingCost.getMisc1(),
                    buildingCost.getMisc2(), buildingCost.getMisc3(), buildingCost.getMisc4(), buildingCost.getMisc5());
            for (int i = 0; i < buildings.size(); i++) {
                if(newBuildingName.equals(buildings.get(i).getName())){
                    newBuilding = buildings.get(i);
                    tile.setMyBuilding(newBuilding);
                    return true;
                }
            }
        }
        return false;
    }

    private void populateTemplate(){
        Building building = tile.getMyBuilding();
        Currency upgradeCost = building.getCost();
        Button upgradeButton = (Button) findViewById(R.id.upgradeBuildingButton);
        String specialResource = "";
        if(upgradeCost.getMisc1() == 1){
            specialResource = "Sorcerer's Hat";
        }
        else if(upgradeCost.getMisc2() == 1){
            specialResource = "Magic Lamp";
        }
        else if(upgradeCost.getMisc3() == 1){
            specialResource = "Abacus";
        }
        else if(upgradeCost.getMisc5() == 1){
            specialResource = "Excalibur";
        }
        else if(upgradeCost.getMisc5() == 1){
            specialResource = "Pentagram Charm";
        }
        upgradeButton.setText("Upgrade Cost: \n"+upgradeCost.getGold()+" Gold\n"+upgradeCost.getWood()+" Wood\n"+upgradeCost.getStone()+" Stone"
            +"\nSpecial Resource: "+specialResource);
        TextView name = (TextView) findViewById(R.id.buildingName);
        name.setText(building.getName());
        TextView description = (TextView) findViewById(R.id.buildingDescription);
        description.setText("Tier: "+building.getTier()+"\nGold Boost: "+building.getGoldBoost().getAmount()+
                "\nWood Boost: "+building.getWoodBoost().getAmount()+"\nStone Boost"+building.getStoneBoost().getAmount()
                +"\nCategory: "+building.getCategory());
    }
}
