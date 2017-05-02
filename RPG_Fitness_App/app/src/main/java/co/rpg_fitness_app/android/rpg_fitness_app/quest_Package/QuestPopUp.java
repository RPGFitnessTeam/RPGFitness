package co.rpg_fitness_app.android.rpg_fitness_app.quest_Package;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Boost;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;

public class QuestPopUp extends Activity {
//// TODO: 4/29/2017  add boosts
    private Currency reward;
    private Currency moneyChest;
    private Quest quest;
    private DataSource mdataSource;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest_pop_up);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.75), (int)(height*0.75));

        this.quest = (Quest) getIntent().getSerializableExtra("quest");
        mdataSource = new DataSource(this);
        mdataSource.open();
        reward = mdataSource.getCurrency(quest.getRewardId());
        moneyChest = mdataSource.getCurrency("moneyChest");

        configureBoosts();
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


    private void configureCompleteButton() {
        Button Button = (Button) findViewById(R.id.completeQuest);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent();
                //intent.putExtra("quest", quest);
                moneyChest.updateResource(true, reward.getWood(), reward.getGold(), reward.getStone(),
                        0, 0, 0, 0, 0);
                mdataSource.updateCurrency(moneyChest);
                quest.setIsQuestComplete(true);
                quest.setHoursRemaining(100);
                mdataSource.updateQuest(quest);
               setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    private void configureSkipButton() {
        Button Button = (Button)  findViewById(R.id.skipQuest);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent();
               // intent.putExtra("quest", quest);
                quest.setIsQuestSkipped(true);
                quest.setHoursRemaining(100);
                mdataSource.updateQuest(quest);
               setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    private void configureText() {
        TextView name = (TextView) findViewById(R.id.QuestName);
        name.setTextSize(22);
        name.setTextColor(Color.BLACK);
        name.setText(quest.getName());

        TextView description = (TextView) findViewById(R.id.QuestDescription);
        description.setTextColor(Color.BLUE);
        description.setHorizontallyScrolling(false);
        description.setTextSize(15);
        description.setText(quest.getDescription());

        TextView parameters = (TextView) findViewById(R.id.QuestParameters);
        String rewards = "\n\nReward: Stone - " + reward.getStone() +
                        " Wood - " + reward.getWood() +
                        " Gold - " + reward.getGold();
        parameters.setTextSize(15);
        parameters.setTextColor(Color.RED);
        parameters.setText(rewards);
    }


    private void configureBoosts() {
        ArrayList<Boost> boosts = mdataSource.getAllBoosts();
        for (int i = 0; i < boosts.size(); i++) {
            Boost boost = boosts.get(i);
            if (boost.getBoostType() != null) {
                if(boost.getBoostType().equals("Wood")) {
                    reward.setWood((int)(reward.getWood() + boost.getAmount()));
                }
                if(boost.getBoostType().equals("Stone")) {
                    reward.setStone((int)(reward.getStone() + boost.getAmount()));
                }
                if(boost.getBoostType().equals("Gold")) {
                    reward.setGold((int)(reward.getGold() + boost.getAmount()));
                }
            }
        }
    }

}
