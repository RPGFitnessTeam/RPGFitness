package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

/**
 * Created by Austin on 3/11/2017.
 */

public class TipsTable {

    public static final String TABLE_TIPS = "Tips";
    public static final String COLUMN_ID = "TipID";
    public static final String COLUMN_ACTIVITY = "TipActivity";
    public static final String COLUMN_VISITED = "TipVisited";
    public static final String COLUMN_THUMBS_UP = "ThumbsUp";
    public static final String COLUMN_THUMBS_DOWN = "ThumbsDown";
    public static final String COLUMN_URL = "URL";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_ACTIVITY, COLUMN_VISITED,
                    COLUMN_THUMBS_UP, COLUMN_THUMBS_DOWN, COLUMN_URL};

    public static final String SQL_CREATE =
            "CREATE TABLE" + TABLE_TIPS + ")" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_ACTIVITY + " TEXT," +
                    COLUMN_VISITED + " INTEGER," +
                    COLUMN_THUMBS_UP + " INTEGER," +
                    COLUMN_THUMBS_DOWN + " INTEGER," +
                    COLUMN_URL + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_TIPS;
}
