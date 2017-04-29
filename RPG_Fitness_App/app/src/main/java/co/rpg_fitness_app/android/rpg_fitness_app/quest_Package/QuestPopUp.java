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
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;

public class QuestPopUp extends Activity {

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

        //this.moneyChest = (Currency) getIntent().getSerializableExtra("money chest");
        this.quest = (Quest) getIntent().getSerializableExtra("quest");
        mdataSource = new DataSource(this);
        mdataSource.open();
        reward = mdataSource.getCurrency(quest.getRewardId());
        moneyChest = mdataSource.getCurrency("moneyChest");
        if (moneyChest == null) {
            moneyChest = new Currency();
        }

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

               Intent intent = new Intent();
                intent.putExtra("quest", quest);
                moneyChest.updateResource(true, reward.getWood(), reward.getGold(), reward.getStone(),
                        0, 0, 0, 0, 0);
                mdataSource.updateCurrency(moneyChest);
                quest.setIsQuestComplete(true);
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
                intent.putExtra("quest", quest);
                quest.setIsQuestSkipped(true);
                mdataSource.updateQuest(quest);
               setResult(Activity.RESULT_OK, intent);
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
        String rewards = "Reward: Stone - " + reward.getStone() +
                        " Wood - " + reward.getWood() +
                        " Gold - " + reward.getGold();
        parameters.setTextSize(15);
        parameters.setText(rewards);
    }

}
