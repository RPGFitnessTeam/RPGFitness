package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

/**
 * Created by Austin on 3/11/2017.
 */

public class BuildingTable {

    public static final String TABLE_BUILDINGS = "Buildings";
    public static final String COLUMN_ID = "BuildingID";
    public static final String COLUMN_NAME = "BuildingName";
    public static final String COLUMN_COST = "BuildingCost";
    public static final String COLUMN_CATEGORY = "BuildingCategory";
    public static final String COLUMN_TIER = "BuildingTier";
    public static final String COLUMN_GOLD_BOOST = "BuildingGoldBoost";
    public static final String COLUMN_WOOD_BOOST = "BuildingWoodBoost";
    public static final String COLUMN_STONE_BOOST = "BuildingStoneBoost";
    public static final String COLUMN_IMAGE = "BuildingImage";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_NAME, COLUMN_COST, COLUMN_CATEGORY, COLUMN_TIER,
                    COLUMN_GOLD_BOOST, COLUMN_WOOD_BOOST, COLUMN_STONE_BOOST, COLUMN_IMAGE};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_BUILDINGS + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_COST + " TEXT," +
                    COLUMN_CATEGORY + " TEXT," +
                    COLUMN_TIER + " INTEGER," +
                    COLUMN_GOLD_BOOST + " TEXT," +
                    COLUMN_WOOD_BOOST + " TEXT," +
                    COLUMN_STONE_BOOST + " TEXT," +
                    COLUMN_IMAGE + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_BUILDINGS;
}

