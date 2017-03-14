package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

/**
 * Created by Austin on 3/11/2017.
 */

public class CharacterTable {

    public static final String TABLE_CHARACTER = "Character";
    public static final String COLUMN_ID = "CharacterID";
    public static final String COLUMN_NAME = "CharacterName";
    public static final String COLUMN_SPECIES = "CharacterSpecies";
    public static final String COLUMN_CURRENCY = "CharacterCurrency";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_NAME, COLUMN_SPECIES, COLUMN_CURRENCY};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_CHARACTER + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_SPECIES + " TEXT," +
                    COLUMN_CURRENCY + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_CHARACTER;
}


