package com.tannerowens.healthandfitnessrpg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tanner on 3/11/2017.
 */

public class TilePopUp extends Activity{

    Tile tile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tile_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.5), (int)(height*0.5));

        this.tile = (Tile) getIntent().getSerializableExtra("tile");
        configureBackButton();
        configureExitButton();
        configurePurchaseButton();
        populateTemplate();
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
        //purchase building1
        ImageButton Button1 = (ImageButton) findViewById(R.id.purchaseBuilding1);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                purchaseBuilding("building1");
                Intent resultData = new Intent();
                resultData.putExtra("tile", tile);
                setResult(1, resultData);
                finish();
            }
        });
        //purchase building2
        ImageButton Button2 = (ImageButton) findViewById(R.id.purchaseBuilding2);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                purchaseBuilding("building2");
                Intent resultData = new Intent();
                resultData.putExtra("tile", tile);
                setResult(1, resultData);
                finish();
            }
        });
        //purchase building3
        ImageButton Button3 = (ImageButton) findViewById(R.id.purchaseBuilding3);
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                purchaseBuilding("building3");
                Intent resultData = new Intent();
                resultData.putExtra("tile", tile);
                setResult(1, resultData);
                finish();
            }
        });
    }

    private void populateTemplate(){
        //building1
        TextView building1Text = (TextView) findViewById(R.id.purchaseBuilding1Text);
        building1Text.setText("Building 1\nThis is building1!\nConstruction Cost: 100 currency");
        //building2
        TextView building2Text = (TextView) findViewById(R.id.purchaseBuilding2Text);
        building2Text.setText("Building 2\nThis is building2!\nConstruction Cost: 100 currency");
        //building3
        TextView building3Text = (TextView) findViewById(R.id.purchaseBuilding3Text);
        building3Text.setText("Building 3\nThis is building3!\nConstruction Cost: 100 currency");
    }


    private void purchaseBuilding(String buildingName){
        Building newBuilding;
        ArrayList<Currency> userCurrency = user.getCurrency();
        ArrayList<Currency> = new ArrayList<Currency>()
        if(buildingName == "buildingName1" && userCurrency > 100){
            newBuilding = new Building(buildingName);
            user.decreaseCurrency(newBuilding.getCost());
            //DECREASE USER CURRENCY
        }
        else if(buildingName == "buildingName2" && userCurrency > 1000){
            newBuilding = new Building(buildingName);
            user.decreaseCurrency(newBuilding.getCost());
            //DECREASE USER CURRENCY
        }
        else if(buildingName == "buildingName3" && userCurrency > 1000){
            newBuilding = new Building(buildingName);
            user.decreaseCurrency(newBuilding.getCost());
            //DECREASE USER CURRENCY
        }
        else {
            return;
        }
        tile.setMyBuilding(newBuilding);
    }

}
