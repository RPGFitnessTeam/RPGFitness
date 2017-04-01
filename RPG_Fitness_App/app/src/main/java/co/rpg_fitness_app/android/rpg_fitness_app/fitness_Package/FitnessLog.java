package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;


/**
 * Created by duya on 3/14/17.
 */

import java.util.ArrayList;
import java.util.List;


public class FitnessLog {

    private static List<LogEntry> activities;

    public FitnessLog()
    {
        this.activities = new ArrayList<LogEntry>();
    }

    public List<LogEntry> retrieveLogEntries()
    {
        return this.activities;
    }
    public void addNewLogEntry(LogEntry newLog)
    {
        this.activities.add(newLog);
    }

}

