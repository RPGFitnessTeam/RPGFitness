package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

/**
 * Created by Austin on 3/11/2017.
 */

public class CurrencyTable {

    public static final String TABLE_CURRENCY = "Currency";
    public static final String COLUMN_ID = "CurrencyID";
    public static final String COLUMN_GOLD = "Gold";
    public static final String COLUMN_WOOD = "Wood";
    public static final String COLUMN_STONE = "Stone";
    public static final String COLUMN_MISC1 = "Misc1";
    public static final String COLUMN_MISC2 = "Misc2";
    public static final String COLUMN_MISC3 = "Misc3";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_GOLD, COLUMN_WOOD,
                    COLUMN_STONE, COLUMN_MISC1, COLUMN_MISC2, COLUMN_MISC3};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_CURRENCY + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_GOLD + " INTEGER," +
                    COLUMN_WOOD + " INTEGER," +
                    COLUMN_STONE + " INTEGER," +
                    COLUMN_MISC1 + " INTEGER," +
                    COLUMN_MISC2 + " INTEGER," +
                    COLUMN_MISC3 + " INTEGER" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_CURRENCY;
}

