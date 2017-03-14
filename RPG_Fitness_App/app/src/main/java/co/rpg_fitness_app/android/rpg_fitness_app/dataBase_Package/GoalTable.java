package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

/**
 * Created by Austin on 3/11/2017.
 */

public class GoalTable {

    public static final String TABLE_GOAL = "Goals";
    public static final String COLUMN_ID = "GoalID";
    public static final String COLUMN_ACTIVITY = "GoalActivity";
    public static final String COLUMN_START_VALUE = "GoalStartValue";
    public static final String COLUMN_CURRENT_VALUE = "GoalCurrentValue";
    public static final String COLUMN_END_VALUE = "GoalEndValue";
    public static final String COLUMN_CONSISTENCY = "IsConsistencyGoal";
    public static final String COLUMN_GAPS = "AllowsGaps";
    public static final String COLUMN_MASTER = "IsMasterQuest";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_ACTIVITY, COLUMN_START_VALUE,
                    COLUMN_CURRENT_VALUE, COLUMN_END_VALUE, COLUMN_CONSISTENCY,
                    COLUMN_GAPS, COLUMN_MASTER};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_GOAL + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_ACTIVITY + " TEXT," +
                    COLUMN_START_VALUE + " INTEGER," +
                    COLUMN_CURRENT_VALUE + " INTEGER," +
                    COLUMN_END_VALUE + " INTEGER," +
                    COLUMN_CONSISTENCY + " INTEGER," +
                    COLUMN_GAPS + " INTEGER," +
                    COLUMN_MASTER + " INTEGER" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE" + TABLE_GOAL;
}
