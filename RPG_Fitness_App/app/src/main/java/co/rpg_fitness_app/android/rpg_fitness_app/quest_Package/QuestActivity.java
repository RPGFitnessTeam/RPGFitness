package co.rpg_fitness_app.android.rpg_fitness_app.quest_Package;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.CharacterActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.FitnessLogActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.GoalActive;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.TipMaster;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.KingdomActivity;


public class QuestActivity extends AppCompatActivity {

    private ArrayList<Quest> quests = new ArrayList<>();
    private ArrayList<Integer> finishedQuests;
    private Button MasterButton;
    private Button questButton1;
    private Button questButton2;
    private Button questButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest_main);

        //Todo: set Quests From Database
        quests.add(new Quest(false, null, "quest1", "Description1", "parameters1"));
        quests.add(new Quest(false, null, "quest2", "Description2", "parameters2"));
        quests.add(new Quest(false, null, "quest3", "Description3", "parameters3"));
        finishedQuests = checkFinishedQuests(quests);
        if (!finishedQuests.isEmpty()) {
            for (int i = 0; i < finishedQuests.size(); i++) {
                quests.set(finishedQuests.get(i), replaceQuest());
            }
        }

        MasterButton = (Button)findViewById(R.id.masterButton);
        questButton1 = (Button)findViewById(R.id.questButton1);
        questButton2 = (Button)findViewById(R.id.questButton2);
        questButton3 = (Button)findViewById(R.id.questButton3);

        applyButtonText();
        configureMasterButton();
        configureQuestButtons();
        configureToolBarButtons();

    }

    private void configureMasterButton() {
        MasterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(QuestActivity.this, MainQuestPopUp.class);
                startActivity(startIntent);
            }
        });
    }

    private void configureQuestButtons() {
        questButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(QuestActivity.this, QuestPopUp.class);
                startIntent.putExtra("quest", quests.get(0));
                startActivity(startIntent);
            }
        });

        questButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(QuestActivity.this, QuestPopUp.class);
                startIntent.putExtra("quest", quests.get(1));
                startActivity(startIntent);
            }
        });

        questButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(QuestActivity.this, QuestPopUp.class);
                startIntent.putExtra("quest", quests.get(2));
                startActivity(startIntent);
            }
        });
    }

    private void applyButtonText() {
        int[] quest1Time = quests.get(0).getTimeRemains();
        int[] quest2Time = quests.get(1).getTimeRemains();
        int[] quest3Time = quests.get(2).getTimeRemains();

        questButton1.setText(quests.get(0).getName() + "\n\nTime Remaining:" +
                "       Days: " + quest1Time[0] + "\n" +
                "                                       Hours: " + quest1Time[1] + "  \n" +
                "                                Minutes: " + quest1Time[2]);
        questButton2.setText(quests.get(1).getName() + "\n\nTime Remaining:" +
                "       Days: " + quest2Time[0] + "\n" +
                "                                       Hours: " + quest2Time[1] + "  \n" +
                "                                Minutes: " + quest2Time[2]);
        questButton3.setText(quests.get(2).getName() + "\n\nTime Remaining:" +
                "       Days: " + quest3Time[0] + "\n" +
                "                                       Hours: " + quest3Time[1] + "  \n" +
                "                                Minutes: " + quest3Time[2]);

    }

    private ArrayList<Integer> checkFinishedQuests (ArrayList<Quest> quests) {
        ArrayList<Integer> finishedQuests = new ArrayList<Integer>();
        for (int i = 0; i < quests.size(); i++) {
            Quest curr = quests.get(i);
            if(curr.getIsQuestExpired() || curr.getQuestComplete() || curr.getQuestSkipped()) {
                finishedQuests.add(i);
            }
        }
        return finishedQuests;
    }

    private Quest replaceQuest() {
        //TODO pull new quest from database
        Quest newQuest = new Quest(false, null, "quest4", "Description4", "parameters");
        return newQuest;
    }

    private void configureToolBarButtons() {
        ImageButton b;
        b = (ImageButton) findViewById(R.id.questFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QuestActivity.this, QuestActivity.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.fitnessLogFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QuestActivity.this, FitnessLogActivity.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.tipsFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QuestActivity.this, TipMaster.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.kingdomFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QuestActivity.this, KingdomActivity.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.goalsFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QuestActivity.this, GoalActive.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.characterFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QuestActivity.this, CharacterActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}
