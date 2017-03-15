package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

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

//    public Goal() {
//        this.goal
//    }

    public Goal (LogEntry goalActivity, String goalId, int startValue, int currentValue,
                 int endValue, boolean isConsistencyGoal, boolean isMasterQuest) {
        this.goalActivity = goalActivity;
        this.goalId = goalId;
        this.startValue = startValue;
        this.currentValue = currentValue;
        this.endValue = endValue;
        this.isConsistencyGoal = isConsistencyGoal;
        this.isMasterQuest = isMasterQuest;
    }

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
}
