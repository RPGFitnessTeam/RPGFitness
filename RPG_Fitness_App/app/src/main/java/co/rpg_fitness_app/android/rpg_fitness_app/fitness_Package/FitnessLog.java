package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;
import java.util.ArrayList;
import java.util.Calendar;


public class FitnessLog {


    private static ArrayList<LogEntry> logEntries;

    public FitnessLog(ArrayList<LogEntry> data)
    {
        logEntries = data;
    }

    public static ArrayList<LogEntry> retrieveLogEntries()
    {
        return logEntries;
    }

    public static void update(ArrayList<LogEntry> newdata)
    {
        logEntries = newdata;
    }

}
