package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

/**
 * Created by Austin on 3/11/2017.
 */

public class BoostTable {
    public static final String TABlE_BOOSTS = "Boosts";
    public static final String COLUMN_ID = "BoostID";
    public static final String COLUMN_AMOUNT = "BoostAmount";
    public static final String COLUMN_TYPE = "BoostType";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_AMOUNT, COLUMN_TYPE};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABlE_BOOSTS + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_AMOUNT + " REAL," +
                    COLUMN_TYPE + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABlE_BOOSTS;
}
