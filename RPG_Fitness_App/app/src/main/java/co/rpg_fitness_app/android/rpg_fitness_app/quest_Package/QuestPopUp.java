package co.rpg_fitness_app.android.rpg_fitness_app.quest_Package;


import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;

public class QuestPopUp extends Activity {

    Currency moneyChest;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest_pop_up);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.75), (int)(height*0.75));

        this.moneyChest = (Currency) getIntent().getSerializableExtra("money chest");


        configureExitButton();
    }



    private void configureExitButton() {
        Button Button = (Button) findViewById(R.id.exitQuestPopUp);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void configureCompleteButton() {
        Button Button = (Button) findViewById(R.id.completeQuest);
        Button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if()
            }
        });

    }
}