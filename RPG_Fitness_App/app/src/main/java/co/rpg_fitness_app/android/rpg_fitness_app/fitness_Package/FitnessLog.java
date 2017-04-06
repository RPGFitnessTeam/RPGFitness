package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;
import java.util.ArrayList;
import java.util.Calendar;


public class FitnessLog {

    static DataSource mDataSource;

    public FitnessLog(Context context)
    {
        mDataSource = new DataSource(context);
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
