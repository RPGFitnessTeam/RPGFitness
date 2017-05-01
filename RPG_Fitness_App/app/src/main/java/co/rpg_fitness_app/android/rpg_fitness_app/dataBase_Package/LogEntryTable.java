package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

/**
 * Created by Austin on 3/11/2017.
 */

public class LogEntryTable {

    public static final String TABLE_LOG_ENTRY = "LogEntries";
    public static final String COLUMN_ID = "LogEntryID";
    public static final String COLUMN_DATE = "LogEntryDate";
    public static final String COLUMN_ACTIVITY = "LogEntryActivity";
    public static final String COLUMN_TYPE = "LogEntryType";
    public static final String COLUMN_SUB_TYPE = "LogEntrySubType";
    public static final String COLUMN_DURATION = "Duration";
    public static final String COLUMN_DISTANCE = "Distance";
    public static final String COLUMN_COUNT = "Count";
    public static final String COLUMN_INTENSITY = "Intensity";
    public static final String COLUMN_WEIGHT = "Weight";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_DATE, COLUMN_ACTIVITY, COLUMN_TYPE,
                    COLUMN_SUB_TYPE, COLUMN_DURATION, COLUMN_DISTANCE,
                    COLUMN_COUNT, COLUMN_INTENSITY, COLUMN_WEIGHT};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_LOG_ENTRY + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_DATE + " TEXT," +
                    COLUMN_ACTIVITY + " INTEGER," +
                    COLUMN_TYPE + " TEXT," +
                    COLUMN_SUB_TYPE + " INTEGER," +
                    COLUMN_DURATION + " INTEGER," +
                    COLUMN_DISTANCE + " INTEGER," +
                    COLUMN_COUNT + " INTEGER," +
                    COLUMN_INTENSITY + " INTEGER," +
                    COLUMN_WEIGHT + " INTEGER" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_LOG_ENTRY;
}

