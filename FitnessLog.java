package fitnessrpg.fitnessrpg;

import android.content.Intent;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;


public class FitnessLog {

    private static ArrayList<LogEntry> activities;

    public FitnessLog()
    {
        /* Todo: retrieve activities from Data Base */
        activities = new ArrayList<LogEntry>();
        //Todo: initialization
        LogEntry initial = new LogEntry("ID", 0);
        initial.setDate((Calendar.getInstance().getTimeInMillis()));
        activities.add(initial);
        initial = new LogEntry("1", 1);
        initial.setDate(Calendar.getInstance().getTimeInMillis());
        activities.add(initial);


    }

    public static ArrayList<LogEntry> retrieveLogEntries()
    {
        return activities;
    }
    public static void addNewLogEntry(LogEntry newLog)
    {
        activities.add(newLog);

    }

}
