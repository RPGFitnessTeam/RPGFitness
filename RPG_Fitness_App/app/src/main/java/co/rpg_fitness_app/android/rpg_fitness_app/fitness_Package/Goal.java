package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import java.util.UUID;

/**
 * Created by Arthur on 3/14/2017.
 */

public class Goal {
    private LogEntry goalActivity;
    private String goalId;
    private int startValue;
    private int currentValue;
    private int endValue;
    private boolean isConsistencyGoal;
    private boolean isMasterQuest;
    private boolean doesAllowGaps;

    public Goal() {
        goalActivity = goalActivity;
        goalId = UUID.randomUUID().toString();
    }

    public Goal (LogEntry goalActivity, String goalId, int startValue, int currentValue,
                 int endValue, boolean isConsistencyGoal, boolean doesAllowGaps, boolean isMasterQuest) {
        this.goalActivity = goalActivity;
        // TODO Need to rectify the goal id
        this.goalId = UUID.randomUUID().toString();
        this.startValue = startValue;
        this.currentValue = currentValue;
        this.endValue = endValue;
        this.isConsistencyGoal = isConsistencyGoal;
        this.doesAllowGaps = doesAllowGaps;
        this.isMasterQuest = isMasterQuest;
    }

    public LogEntry getGoalActivity() {return goalActivity; }

    public void setGoalActivity(LogEntry goalActivity) {this.goalActivity = goalActivity;}

    public String getGoalId() {
        return goalId;
    }

    public void setGoalId(String goalId) {
        this.goalId = goalId;
    }

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getEndValue() {
        return endValue;
    }

    public void setEndValue(int endValue) {
        this.endValue = endValue;
    }

    public boolean isConsistencyGoal() {
        return isConsistencyGoal;
    }

    public void setConsistencyGoal(boolean consistencyGoal) {
        isConsistencyGoal = consistencyGoal;
    }

    public boolean isMasterQuest() {
        return isMasterQuest;
    }

    public void setMasterQuest(boolean masterQuest) {
        isMasterQuest = masterQuest;
    }

    public boolean doesAllowGaps() { return doesAllowGaps; }

    public void setDoesAllowGaps(boolean bool) { doesAllowGaps = bool; }

}
