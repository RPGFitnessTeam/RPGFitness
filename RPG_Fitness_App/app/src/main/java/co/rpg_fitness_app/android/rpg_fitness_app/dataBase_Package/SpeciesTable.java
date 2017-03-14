package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

/**
 * Created by Austin on 3/11/2017.
 */

public class SpeciesTable {

    public static final String TABLE_SPECIES = "Species";
    public static final String COLUMN_ID = "SpeciesID";
    public static final String COLUMN_NAME = "SpeciesName";
    public static final String COLUMN_DESCRIPTION = "SpeciesDescription";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_NAME, COLUMN_DESCRIPTION};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_SPECIES + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_DESCRIPTION + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_SPECIES;
}
