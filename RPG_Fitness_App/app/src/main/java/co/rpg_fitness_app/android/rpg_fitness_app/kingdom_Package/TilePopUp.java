package co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by Tanner on 3/11/2017.
 */

public class TilePopUp extends Activity{

    Tile tile;
    Currency moneyChest;
    ArrayList<Building> buildings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tile_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.85), (int)(height*0.85));

        this.tile = (Tile) getIntent().getSerializableExtra("tile");
        this.moneyChest = (Currency) getIntent().getSerializableExtra("money chest");
        this.buildings = (ArrayList<Building>) getIntent().getSerializableExtra("buildings");
        configureExitButton();
        configurePurchaseButton();
        populateTemplate();
    }

    private void configureExitButton() {
        Button Button = (Button) findViewById(R.id.exitTilePopUp);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void configurePurchaseButton() {
        //purchase house
        ImageButton Button;
        Button = (ImageButton) findViewById(R.id.purchaseBuilding1);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseBuilding("house")) {
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
        //purchase wood bridge
        Button = (ImageButton) findViewById(R.id.purchaseBuilding2);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseBuilding("wood bridge")) {
                    Intent resultData = new Intent();
                    resultData.putExtra("tile", tile);
                    resultData.putExtra("money chest", moneyChest);
                    setResult(1, resultData);
                    finish();
                }
                else{
                    setResult(0,null);
                    finish();
                }
            }
        });
        //purchase cave
        Button = (ImageButton) findViewById(R.id.purchaseBuilding3);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseBuilding("cave")) {
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
        //purchase Tavern
        Button = (ImageButton) findViewById(R.id.purchaseBuilding4);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseBuilding("tavern")) {
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
        //purchase Fort
        Button = (ImageButton) findViewById(R.id.purchaseBuilding5);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseBuilding("fort")) {
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
        //purchase pond
        Button = (ImageButton) findViewById(R.id.purchaseBuilding6);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseBuilding("pond")) {
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

    private void populateTemplate(){
        //house
        ImageButton i;
        TextView t;
        i = (ImageButton) findViewById(R.id.purchaseBuilding1);
        i.setBackgroundResource(R.drawable.b_dwelling1);
        t = (TextView) findViewById(R.id.purchaseBuilding1Text);
        t.setText("House:\nA house will give you extra gold!\nConstruction Cost: 1 wood, 1 gold");
        //wood bridge
        i = (ImageButton) findViewById(R.id.purchaseBuilding2);
        i.setBackgroundResource(R.drawable.b_bridge1);
        t = (TextView) findViewById(R.id.purchaseBuilding2Text);
        t.setText("Wood Bridge:\nA wood bridge will give you extra wood!\nConstruction Cost: 1 wood, 1 gold");
        //cave
        i = (ImageButton) findViewById(R.id.purchaseBuilding3);
        i.setBackgroundResource(R.drawable.b_mining1);
        t = (TextView) findViewById(R.id.purchaseBuilding3Text);
        t.setText("Cave:\nA cave will give you extra stone!\nConstruction Cost: 1 wood, 1 gold");
        //tavern
        i = (ImageButton) findViewById(R.id.purchaseBuilding4);
        i.setBackgroundResource(R.drawable.b_hospitality1);
        t = (TextView) findViewById(R.id.purchaseBuilding4Text);
        t.setText("Tavern:\nA tavern will give you extra gold!\nConstruction Cost: 1 stone, 1 gold");
        //fort
        i = (ImageButton) findViewById(R.id.purchaseBuilding5);
        i.setBackgroundResource(R.drawable.b_military1);
        t = (TextView) findViewById(R.id.purchaseBuilding5Text);
        t.setText("Fort:\nA fort will give you extra wood!\nConstruction Cost: 1 wood, 1 gold");
        //pond
        i = (ImageButton) findViewById(R.id.purchaseBuilding6);
        i.setBackgroundResource(R.drawable.b_water1);
        t = (TextView) findViewById(R.id.purchaseBuilding6Text);
        t.setText("Pond:\nA pond will give you extra gold!\nConstruction Cost: 1 stone, 1 gold");
        t = (TextView) findViewById(R.id.userGold);
        t.setText("Gold: "+moneyChest.getGold());
        t = (TextView) findViewById(R.id.userWood);
        t.setText("Wood: "+moneyChest.getWood());
        t = (TextView) findViewById(R.id.userStone);
        t.setText("Stone: "+moneyChest.getStone());
    }


    private boolean purchaseBuilding(String buildingName){
        Building newBuilding = new Building(buildingName);
        Currency buildingCost = newBuilding.getCost();
        if (moneyChest.getWood()>=buildingCost.getWood() && moneyChest.getGold()>=buildingCost.getGold() && moneyChest.getStone()>=buildingCost.getStone() &&
                moneyChest.getMisc1()>=buildingCost.getMisc1() && moneyChest.getMisc2()>=buildingCost.getMisc2() && moneyChest.getMisc3()>=buildingCost.getMisc3() &&
                moneyChest.getMisc1()>=buildingCost.getMisc5() && moneyChest.getMisc1()>=buildingCost.getMisc5()) {
            moneyChest.updateResource(false, buildingCost.getWood(), buildingCost.getGold(), buildingCost.getStone(), buildingCost.getMisc1(),
                    buildingCost.getMisc2(), buildingCost.getMisc3(), buildingCost.getMisc4(), buildingCost.getMisc5());
            for (int i = 0; i < buildings.size(); i++) {
                if(buildingName.equals(buildings.get(i).getName())){
                    newBuilding = buildings.get(i);
                    tile.setMyBuilding(newBuilding);
                    return true;
                }
            }
            return false;
        }
       else{
            String s = "Insufficient funds!!! Obtain more resources!!!";
            Toast.makeText(this,s,Toast.LENGTH_LONG).show();
            return false;
        }
    }

}
