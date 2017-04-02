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

public class MysteryPopUp extends Activity {

    Tile tile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mystery_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.75), (int)(height*0.75));

        this.tile = (Tile) getIntent().getSerializableExtra("tile");
        configureExitButton();
        configureUnlockButton();
        populateTemplate();
    }

    private void configureExitButton() {
        Button Button = (Button) findViewById(R.id.exitMysteryTilePopUp);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void configureUnlockButton() {
        Button Button = (Button) findViewById(R.id.unlockMysteryTile);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(unlockTile()) {
                    Intent resultData = new Intent();
                    resultData.putExtra("tile", tile);
                    setResult(1, resultData);
                    finish();
                }
                else {
                    finish();
                }
            }
        });
    }

    private void populateTemplate(){
        Currency unlockCost = tile.getTileCost();
        Button unlockButton = (Button) findViewById(R.id.unlockMysteryTile);
        unlockButton.setText("Unlock Cost:\n"+unlockCost.getGold()+" Gold\n"+unlockCost.getWood()+" Wood\n"+unlockCost.getStone()+" Stone");
        TextView name = (TextView) findViewById(R.id.mysteryTileName);
        name.setText("Mystery Tile");
        TextView description = (TextView) findViewById(R.id.mysteryTileDescription);
        description.setText("It's a Mystery Tile!");
    }

    /**
     * @return true if user had sufficient funds to unlock the mystery tile
     *
     * STILL NEED TO GET USERS CURRENCY AND CHECK IF SUFFICIENT
     */
    //TODO decrease user currency if they have sufficient funds
    private boolean unlockTile(){
        Currency cost = tile.getTileCost();
        tile.setLocked(false);
        return true;
    }
}
