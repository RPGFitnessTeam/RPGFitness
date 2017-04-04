package co.rpg_fitness_app.android.rpg_fitness_app.quest_Package;


import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.Goal;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.lang.Math;


public class Quest {

    private String name;
    private String description;
    private ArrayList<Currency> reward;
    private Calendar questEndDate;
    private boolean isQuestComplete;
    private boolean isQuestSkipped;
    private boolean isQuestExpired;
    private Goal questGoal;
    private String id;



    public Quest(boolean isMasterQuest, ArrayList<Currency> reward, String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.reward = reward;
        this.isQuestComplete = false;
        this.isQuestSkipped = false;
        this.isQuestExpired = false;

        if (!isMasterQuest) {
            this.questGoal = null;
            this.questEndDate = Calendar.getInstance();
            questEndDate.setTime(new Date());
            questEndDate.add(Calendar.DAY_OF_YEAR, 3);
        }
        else {

        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int[] getTimeRemains() {
        int[] TimeRemaining = new int[3];
        Calendar currDate = Calendar.getInstance();
        currDate.setTime(new Date());
        TimeRemaining[0] = Math.abs(questEndDate.get(Calendar.DAY_OF_YEAR) -
                currDate.get(Calendar.DAY_OF_YEAR));
        TimeRemaining[1] = Math.abs(questEndDate.get(Calendar.HOUR_OF_DAY) -
                currDate.get(Calendar.HOUR_OF_DAY));
        TimeRemaining[2] = Math.abs(questEndDate.get(Calendar.HOUR_OF_DAY) -
                currDate.get(Calendar.HOUR_OF_DAY));
        return TimeRemaining;
    }

    public boolean getQuestComplete() {
        return isQuestComplete;
    }

    public boolean getQuestSkipped() {
        return isQuestSkipped;
    }

    public boolean getIsQuestExpired() {
        Calendar currDate = Calendar.getInstance();
        if (currDate.after(questEndDate)) {
            this.isQuestExpired = true;
        }
        return isQuestExpired;
    }





}