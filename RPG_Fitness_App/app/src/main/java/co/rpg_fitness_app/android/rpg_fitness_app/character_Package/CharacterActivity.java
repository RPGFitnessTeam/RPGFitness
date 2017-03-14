package co.rpg_fitness_app.android.rpg_fitness_app.character_Package;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by awhit on 3/13/2017.
 */

public class CharacterActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_screen);

        Button helm = (Button) findViewById(R.id.button_helm);
        Button chest = (Button) findViewById(R.id.button_chest);
        Button weapon = (Button) findViewById(R.id.button_Weapon);
        Button offHand = (Button) findViewById(R.id.button_offhand);
        Button legs = (Button) findViewById(R.id.button_Legs);

        helm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CharacterActivity.this, ItemPopUpHelm.class));
            }
        });

    }

}
