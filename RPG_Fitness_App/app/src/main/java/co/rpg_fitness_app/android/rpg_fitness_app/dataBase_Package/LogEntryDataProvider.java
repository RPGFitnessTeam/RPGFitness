package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Austin on 3/14/2017.
 */

public class LogEntryDataProvider {
    public static ArrayList<LogEntry> logEntryList;
    public static Map<String, LogEntry> logEntryMap;

    static {
        logEntryList = new ArrayList<LogEntry>();
        logEntryMap = new HashMap<String, LogEntry>();

        // Below here is where we will add all items to the database
    }

    private static void addLogEntry(LogEntry logEntry) {
        logEntryList.add(logEntry);
        logEntryMap.put(logEntry.getID(), logEntry);
    }
}


