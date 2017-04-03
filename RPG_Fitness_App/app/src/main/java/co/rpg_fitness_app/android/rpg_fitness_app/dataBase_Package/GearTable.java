package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

/**
 * Created by Austin on 3/11/2017.
 */


//TODO: Add integers for isOwned and isEquipped
public class GearTable {

    public static final String TABLE_GEAR = "Gear";
    public static final String COLUMN_ID = "GearID";
    public static final String COLUMN_NAME = "GearName";
    public static final String COLUMN_CATEGORY = "GearCategory";
    public static final String COLUMN_COST = "GearCost";
    public static final String COLUMN_BOOST = "GearBoost";
    public static final String COLUMN_OWNED = "GearOwned";
    public static final String COLUMN_EQUIPPED = "GearEquipped";
    public static final String COLUMN_IMAGE = "GearImage";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_NAME, COLUMN_CATEGORY,
                    COLUMN_COST, COLUMN_BOOST, COLUMN_OWNED, COLUMN_EQUIPPED, COLUMN_IMAGE};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_GEAR + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_CATEGORY + " TEXT," +
                    COLUMN_COST + " TEXT," +
                    COLUMN_BOOST + " TEXT," +
                    COLUMN_OWNED + " INTEGER," +
                    COLUMN_EQUIPPED + " INTEGER," +
                    COLUMN_IMAGE + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_GEAR;
}

