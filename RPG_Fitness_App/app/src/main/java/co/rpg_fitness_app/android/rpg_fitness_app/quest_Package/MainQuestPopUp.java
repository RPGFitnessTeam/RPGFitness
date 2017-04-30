package co.rpg_fitness_app.android.rpg_fitness_app.quest_Package;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.UUID;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.Goal;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.GoalAdapter;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.LogEntry;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;

public class MainQuestPopUp extends Activity {

    private Quest master;
    private Goal masterGoal;
    DataSource mdataSource;
    private ArrayList<Goal> goalList = new ArrayList<>();
    private Currency moneyChest;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_quest_pop_up);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

       // getWindow().setLayout((int)(width*0.75), (int)(height*0.75));
        mdataSource = new DataSource(this);
        mdataSource.open();
        master = (Quest) getIntent().getSerializableExtra("master");
        masterGoal = master.getGoal();
        moneyChest = mdataSource.getCurrency("moneyChest");

        configureCompleteButton();
        configureText();
        configureExitButton();
    }



    private void configureExitButton() {
        Button Button = (Button) findViewById(R.id.exitMainQuestPopUp);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void configureCompleteButton() {
        Button Button = (Button) findViewById(R.id.completeMaster);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(masterGoal != null) {
                    if (masterGoal.getCurrentValue() >= masterGoal.getEndValue()) {
                        Currency reward = mdataSource.getCurrency(master.getRewardId());
                        moneyChest.updateResource(true, reward.getWood(), reward.getGold(), reward.getStone(),
                                0, 0, 0, 0, 0);
                        mdataSource.updateCurrency(moneyChest);
                        LogEntry lg = new LogEntry(UUID.randomUUID().toString(), 0);
                        Goal goal = new Goal(lg, UUID.randomUUID().toString(), 0, 0, 25, false, true, true);
                        master.setGoal(goal);
                        mdataSource.updateQuest(master);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Parameters Not Met!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Parameters Not Met!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void configureText() {
        TextView name = (TextView) findViewById(R.id.MasterName);
        name.setTextSize(22);
        name.setTextColor(Color.BLACK);
        name.setText(master.getName());

        TextView description = (TextView) findViewById(R.id.MasterDescription);
        description.setTextColor(Color.BLUE);
        description.setHorizontallyScrolling(false);
        description.setTextSize(20);
        description.setText(master.getDescription());

       goalList.add(masterGoal);
        GoalAdapter glAdapt = new GoalAdapter(goalList, this, false);
        ListView listView = (ListView)findViewById(R.id.main_listview);
        listView.setAdapter(glAdapt);
    }
}
