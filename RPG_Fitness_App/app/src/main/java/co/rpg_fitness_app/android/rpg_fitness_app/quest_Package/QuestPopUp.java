package co.rpg_fitness_app.android.rpg_fitness_app.quest_Package;


import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;

public class QuestPopUp extends Activity {

    Currency moneyChest;
    Quest quest;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest_pop_up);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.75), (int)(height*0.75));

        //this.moneyChest = (Currency) getIntent().getSerializableExtra("money chest");
        this.quest = (Quest) getIntent().getSerializableExtra("quest");

        configureText();
        configureCompleteButton();
        configureSkipButton();
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


    //TODO
    private void configureCompleteButton() {
        Button Button = (Button) findViewById(R.id.completeQuest);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void configureSkipButton() {
        Button Button = (Button)  findViewById(R.id.skipQuest);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void configureText() {
        TextView name = (TextView) findViewById(R.id.QuestName);
        name.setText(quest.getName());

        TextView description = (TextView) findViewById(R.id.QuestDescription);
        description.setText(quest.getDescription());

        TextView parameters = (TextView) findViewById(R.id.QuestParameters);
        parameters.setText(quest.getParameters());
    }

}
