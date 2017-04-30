package co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by Tanner on 3/9/2017.
 */

public class MysteryPopUp extends Activity {

    Tile tile;
    Currency moneyChest;

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
        this.moneyChest = (Currency) getIntent().getSerializableExtra("money chest");
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
        Currency unlockCost = tile.getTileCost();
        Button unlockButton = (Button) findViewById(R.id.unlockMysteryTile);
        unlockButton.setText("Unlock Cost:\n"+unlockCost.getGold()+" Gold\n"+unlockCost.getWood()+" Wood\n"+unlockCost.getStone()+" Stone");
        TextView name = (TextView) findViewById(R.id.mysteryTileName);
        name.setText("Mystery Tile");
        TextView description = (TextView) findViewById(R.id.mysteryTileDescription);
        description.setText("It's a Mystery Tile! Unlock to gain Special Resources, gear, and then start building!");
        TextView t;
        t = (TextView) findViewById(R.id.userGold);
        t.setText("Gold: "+moneyChest.getGold());
        t = (TextView) findViewById(R.id.userWood);
        t.setText("Wood: "+moneyChest.getWood());
        t = (TextView) findViewById(R.id.userStone);
        t.setText("Stone: "+moneyChest.getStone());
    }

    /**
     * @return true if user had sufficient funds to unlock the mystery tile
     *
     */
    private boolean unlockTile(){
        Currency cost = tile.getTileCost();
        if(moneyChest.getWood()>=cost.getWood() && moneyChest.getGold()>=cost.getGold() && moneyChest.getStone()>=cost.getStone()){
            moneyChest.updateResource(false, cost.getWood(), cost.getGold(), cost.getStone(),0,0,0,0,0);
            tile.setLocked(false);
            //Adding in special resources
            int tileNum = tile.getTileNumber();
            switch (tileNum){
                case 1: moneyChest.updateResource(true, 0,0,0,1,0,0,0,0);
                    break;
                case 2: moneyChest.updateResource(true, 0,0,0,0,1,0,0,0);
                    break;
                case 3: moneyChest.updateResource(true, 0,0,0,0,0,1,0,0);
                    break;
                case 4: moneyChest.updateResource(true, 0,0,0,0,0,0,1,0);
                    break;
                case 5: moneyChest.updateResource(true, 0,0,0,0,0,0,0,1);
                    break;
                case 6: moneyChest.updateResource(true, 0,0,0,1,0,0,0,0);
                    break;
                case 7: moneyChest.updateResource(true, 0,0,0,0,1,0,0,0);
                    break;
                case 8: moneyChest.updateResource(true, 0,0,0,0,0,1,0,0);
                    break;
                case 9: moneyChest.updateResource(true, 0,0,0,0,0,0,1,0);
                    break;
                case 10: moneyChest.updateResource(true, 0,0,0,0,0,0,0,1);
                    break;
                case 11: moneyChest.updateResource(true, 0,0,0,1,0,0,0,0);
                    break;
                case 12: moneyChest.updateResource(true, 0,0,0,0,1,0,0,0);
                    break;
                case 13: moneyChest.updateResource(true, 0,0,0,0,0,1,0,0);
                    break;
                case 14: moneyChest.updateResource(true, 0,0,0,0,0,0,1,0);
                    break;
                case 15: moneyChest.updateResource(true, 0,0,0,0,0,0,0,1);
                    break;
                case 16: moneyChest.updateResource(true, 0,0,0,1,0,0,0,0);
                    break;
                case 17: moneyChest.updateResource(true, 0,0,0,0,1,0,0,0);
                    break;
                case 18: moneyChest.updateResource(true, 0,0,0,0,0,1,0,0);
                    break;
                case 19: moneyChest.updateResource(true, 0,0,0,0,0,0,1,0);
                    break;
                case 0: moneyChest.updateResource(true, 0,0,0,0,0,0,0,1);
                    break;
                default: break;
            }
            return true;
        }
        else{
            String s = "Insufficient funds!!! Obtain more resources!!!";
            Toast.makeText(this,s,Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
