package co.rpg_fitness_app.android.rpg_fitness_app.quest_Package;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import java.util.ArrayList;
import java.util.Calendar;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.CharacterActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.FitnessLogActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.GoalActive;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.TipMaster;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.KingdomActivity;


public class QuestActivity extends AppCompatActivity {

    private ArrayList<Quest> quests;
    private ArrayList<Integer> finishedQuests;
    private ArrayList<Quest> allQuests;
    private Button MasterButton;
    private Button questButton1;
    private Button questButton2;
    private Button questButton3;
    private DataSource mdataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest_main);

        mdataSource = new DataSource(this);
        mdataSource.open();


        MasterButton = (Button)findViewById(R.id.masterButton);
        questButton1 = (Button)findViewById(R.id.questButton1);
        questButton2 = (Button)findViewById(R.id.questButton2);
        questButton3 = (Button)findViewById(R.id.questButton3);

        configureQuests();
        applyButtonText();
        configureMasterButton();
        configureQuestButtons();
        configureToolBarButtons();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK) {
            configureQuests();
            //replaceQuest();
            applyButtonText();
        }
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
                startActivityForResult(startIntent, 1);
            }
        });

        questButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(QuestActivity.this, QuestPopUp.class);
                startIntent.putExtra("quest", quests.get(1));
                startActivityForResult(startIntent, 1);
            }
        });

        questButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(QuestActivity.this, QuestPopUp.class);
                startIntent.putExtra("quest", quests.get(2));
                startActivityForResult(startIntent, 1);
            }
        });
    }

    private void applyButtonText() {
        int[] quest1Time = quests.get(0).getTimeRemaining();
        int[] quest2Time = quests.get(1).getTimeRemaining();
        int[] quest3Time = quests.get(2).getTimeRemaining();

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
            if(curr.getQuestComplete() || curr.getQuestSkipped()) {
                finishedQuests.add(i);
            }
        }
        return finishedQuests;
    }

    private void configureQuests() {
        quests = new ArrayList<>();
        allQuests = mdataSource.getAllQuests();
        int questFilled = 0;
        int curr = 0;
        boolean done = false;
        while(!done) {
            if(curr == allQuests.size()) {
                for (int i = 0; i < allQuests.size(); i++) {
                    if(!quests.contains(allQuests.get(i))) {
                        allQuests.get(i).setHoursRemaining(100);
                        allQuests.get(i).setIsQuestComplete(false);
                        allQuests.get(i).setIsQuestSkipped(false);
                        allQuests.get(i).setIsQuestExpired(false);
                        mdataSource.updateQuest(allQuests.get(i));
                    }
                }
                curr = 0;
            }
            if(!allQuests.get(curr).getQuestSkipped() && !allQuests.get(curr).getQuestComplete() &&
                    !quests.contains(allQuests.get(curr))) {
                if(allQuests.get(curr).getHoursRemaining().equals("100")) {
                    Quest quest = allQuests.get(curr);
                    quest.setHoursRemaining(72);
                    Calendar cal = Calendar.getInstance();
                    String date = cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_YEAR) + "/"
                            + cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.HOUR_OF_DAY) +
                            "/" + cal.get(Calendar.MINUTE);
                    quest.setStartDate(date);
                    mdataSource.updateQuest(quest);
                    quests.add(quest);
                    questFilled += 1;
                }
                else {
                    Quest quest = allQuests.get(curr);
                    if (!quest.getIsQuestExpired()) {
                        quests.add(quest);
                        questFilled += 1;
                    }
                }
            }
            curr += 1;
            if (questFilled > 2) {
                done = true;
            }
        }
    }

    private void replaceQuest() {
        //TODO pull new quest from database
        Quest newQuest = new Quest(false, new Currency(), "quest4", "Description4");
        quests.set(0, newQuest);
        applyButtonText();
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
