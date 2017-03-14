package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

/**
 * Created by Austin on 3/11/2017.
 */

public class QuestTable {

    public static final String TABLE_QUEST = "Quests";
    public static final String COLUMN_ID = "QuestID";
    public static final String COLUMN_NAME = "QuestName";
    public static final String COLUMN_DESCRIPTION = "QuestDescription";
    public static final String COLUMN_REWARD = "QuestReward";
    public static final String COLUMN_TIME_REMAINING = "QuestHoursRemaining";
    public static final String COLUMN_START = "QuestStartDate";
    public static final String COLUMN_COMPLETE = "IsQuestComplete";
    public static final String COLUMN_SKIPPED = "IsQuestSkipped";
    public static final String COLUMN_EXPIRED = "IsQuestExpired";
    public static final String COLUMN_GOAL = "QuestGoal";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_NAME, COLUMN_DESCRIPTION,
                    COLUMN_REWARD, COLUMN_TIME_REMAINING, COLUMN_START,
                    COLUMN_COMPLETE, COLUMN_SKIPPED, COLUMN_EXPIRED, COLUMN_GOAL};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_QUEST + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_DESCRIPTION + " TEXT," +
                    COLUMN_REWARD + " TEXT," +
                    COLUMN_TIME_REMAINING + " INTEGER," +
                    COLUMN_START + " TEXT," +
                    COLUMN_COMPLETE + " INTEGER," +
                    COLUMN_SKIPPED + " INTEGER," +
                    COLUMN_EXPIRED + " INTEGER," +
                    COLUMN_GOAL + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_QUEST;
}
