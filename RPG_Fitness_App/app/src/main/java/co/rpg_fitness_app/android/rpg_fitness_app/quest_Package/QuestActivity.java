package co.rpg_fitness_app.android.rpg_fitness_app.quest_Package;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.R;



public class QuestActivity extends AppCompatActivity {

    private ArrayList<Quest> quests = new ArrayList<>();
    private Button MasterButton;
    private Button questButton1;
    private Button questButton2;
    private Button questButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest_main);


        quests.add(new Quest(false, null, "quest1", "asda"));
        quests.add(new Quest(false, null, "quest2", "asdfff"));
        quests.add(new Quest(false, null, "quest3", "asdff"));

        MasterButton = (Button)findViewById(R.id.masterButton);
        questButton1 = (Button)findViewById(R.id.questButton1);
        questButton2 = (Button)findViewById(R.id.questButton2);
        questButton3 = (Button)findViewById(R.id.questButton3);

        ArrayList<Integer> expiredQuests = checkExpiredQuests(quests);
        if (!expiredQuests.isEmpty()) {
            for(int i = 0; i < expiredQuests.size(); i++) {

            }
        }
        applyButtonText();
        configureMasterButton();
        configureQuestButtons();


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
                startActivity(startIntent);
            }
        });

        questButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(QuestActivity.this, QuestPopUp.class);
                startActivity(startIntent);
            }
        });

        questButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(QuestActivity.this, QuestPopUp.class);
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

    private ArrayList<Integer> checkExpiredQuests (ArrayList<Quest> quests) {
        ArrayList<Integer> expiredQuests = new ArrayList<Integer>();
        for (int i = 0; i < quests.size(); i++) {
            if(quests.get(i).getIsQuestExpired()) {
                expiredQuests.add(i);
            }
        }
        return expiredQuests;
    }

    private Quest getNewQuest() {
        //TODO: UPDATE QUEST
        Quest newQuest = new Quest(false, null, "quest4", "asdfsdasdff");
        return newQuest;
    }

}







