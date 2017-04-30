package co.rpg_fitness_app.android.rpg_fitness_app.quest_Package;

import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.Goal;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.LogEntry;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.io.Serializable;


public class Quest implements Serializable {

    private String name;
    private String description;
    //private String parameters;
    private int hoursRemaining;
    private Currency reward;
    private String rewardId;
    private Calendar questStartDate;
    private String questStart;
    private boolean isQuestComplete;
    private boolean isQuestSkipped;
    private boolean isQuestExpired;
    private Goal questGoal;
    private String id;


    public Quest() {
        this.id = "";
        this.description = "";
        this.reward = null;
        this.questStartDate = Calendar.getInstance();
        this.isQuestComplete = false;
        this.isQuestSkipped = false;
        this.isQuestExpired = false;
        this.questGoal = null;

    }


    public Quest(boolean isMasterQuest, Currency reward, String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.reward = reward;
        this.rewardId = reward.getId();
        this.isQuestComplete = false;
        this.isQuestSkipped = false;
        this.isQuestExpired = false;
        this.questStartDate = Calendar.getInstance();
        questStartDate.setTime(new Date());
        this.questStart = questStartDate.get(Calendar.MONTH) + "/" + questStartDate.get(Calendar.DAY_OF_YEAR) + "/"
                + questStartDate.get(Calendar.YEAR) + "/" + questStartDate.get(Calendar.HOUR_OF_DAY) +
                "/" + questStartDate.get(Calendar.MINUTE);
        //this.parameters = Parameters;

        if (!isMasterQuest) {
            this.questGoal = null;
            this.hoursRemaining = 100;
        }
        else {
            this.hoursRemaining = 200;
            LogEntry lg = new LogEntry(UUID.randomUUID().toString(), 0);
            Goal goal = new Goal(lg, UUID.randomUUID().toString(), 0 , 0 , 25, false, true, true);
            this.questGoal = goal;
        }
    }





    public String getTimeRemains() {
       /* int[] TimeRemaining = getTimeRemaining();
        String time;
        time = TimeRemaining[0] + "/" + TimeRemaining[1] + "/" + TimeRemaining[2];
        return time;*/
       return this.getHoursRemaining();
    }

    public int[] getTimeRemaining() {
        int[] TimeRemaining = new int[3];
        Calendar questEndDate = Calendar.getInstance();
        questEndDate.setTime(getStartCal().getTime());
        questEndDate.add(Calendar.DAY_OF_YEAR, 3);
        long difference = questEndDate.getTimeInMillis() - getStartCal().getTimeInMillis();
        int days = (int) difference / (24*60*60*1000);
        int hours = (int) (difference / (60*60*1000)) %24;
        int minutes = (int) (difference / (60*1000)) %60;
        TimeRemaining[0] = days;
        TimeRemaining[1] = hours;
        TimeRemaining[2] = minutes;
        return TimeRemaining;
    }




    public boolean setQuestExpired() {
        if (getHoursRemaining().equals("100")) {
            setIsQuestExpired(false);
            return false;
        }

        Calendar questEndDate = getStartCal();
        questEndDate.add(Calendar.DAY_OF_YEAR, 3);
        Calendar currDate = Calendar.getInstance();
        currDate.setTime(new Date());
        if (currDate.after(questEndDate)) {
            setIsQuestExpired(true);
            return true;
        }
        setIsQuestExpired(false);
        return false;
    }

    public void setIsQuestSkipped(boolean questSkipped) {
        this.isQuestSkipped = questSkipped;
    }

    public void setIsQuestComplete(boolean questComplete) {
        this.isQuestComplete = questComplete;
    }

    public void setIsQuestExpired(boolean questExpired) { this.isQuestExpired = questExpired; }

    public void setGoal(Goal goal) {this.questGoal = goal; }

    public void setStartDate(String questStart) {this.questStart = questStart;}

    public void setHoursRemaining(int hoursRemaining) {this.hoursRemaining = hoursRemaining;}

    public void setName (String name) {this.name = name;}

    public void setDescription (String description) {this.description = description;}

    //public void setParameters (String parameters) {this.parameters = parameters;}

    public void setID (String id) {this.id = id;}

    public void setReward (String rewardId) {this.rewardId = rewardId;}

    //public Currency getRewards() { return reward;}

    public boolean getQuestComplete() {
        return this.isQuestComplete;
    }

    public boolean getQuestSkipped() {
        return this.isQuestSkipped;
    }

    public boolean getQuestExpired() { return this.isQuestExpired; }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    //public String getParameters() {return this.parameters;}

    public String getId() { return this.id; }

    public Goal getGoal() { return this.questGoal; }

    public Currency getReward() { return this.reward; }

    public String getRewardId() { return this.rewardId; }

    public String getQuestStart() { return this.questStart;}

    public String getHoursRemaining() { return "" + this.hoursRemaining; }

    public Calendar getStartCal() {
        questStartDate = Calendar.getInstance();
        String date = getQuestStart();
        String num = "";
        int curr = 0;
        int month = 1;
        int day = 1;
        int year = 1;
        int hour = 1;
        int minute = 1;
        for (int i = 0; i < date.length(); i++) {
            if (date.charAt(i) == '/' || i == date.length()) {
                int d = Integer.parseInt(num);
                switch (curr) {
                    case 0: month = d;
                        break;
                    case 1: day = d;
                        break;
                    case 2: year = d;
                        break;
                    case 3: hour = d;
                        break;
                    case 4: minute = d;
                        break;
                }
                curr += 1;
                num = "";
            }
            else {
                num = num + date.charAt(i);
            }
        }
        questStartDate.set(year, month, day, hour, minute);
        return questStartDate;
    }





}
