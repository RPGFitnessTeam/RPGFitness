package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.content.Intent;
import android.view.ViewGroup;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;
import java.util.ArrayList;
import java.util.Calendar;


public class FitnessLog {

    DataSource mDataSource;

    public FitnessLog()
    {
        mDataSource = new DataSource(this);
        mDataSource.open();
    }

    public static ArrayList<LogEntry> retrieveLogEntries()
    {
        return mDataSource.getAllLogEntries();
    }
    public static void addNewLogEntry(LogEntry newLog)
    {
        mDataSource.insertLogEntry(newLog);

    }

}
