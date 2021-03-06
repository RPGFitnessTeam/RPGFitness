package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

/**
 * Created by Austin on 3/11/2017.
 */

public class TileTable {

    public static final String TABLE_TILE = "Tiles";
    public static final String COLUMN_ID = "TileID";
    public static final String COLUMN_POSITION = "TilePosition";
    public static final String COLUMN_LOCKED = "IsLocked";
    public static final String COLUMN_BUILDING = "TileBuilding";
    public static final String COLUMN_COST = "TileCost";
    public static final String COLUMN_IMAGE = "TileImage";

    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_POSITION, COLUMN_LOCKED, COLUMN_BUILDING, COLUMN_COST, COLUMN_IMAGE};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_TILE + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_POSITION + " INTEGER," +
                    COLUMN_LOCKED + " INTEGER," +
                    COLUMN_BUILDING + " TEXT," +
                    COLUMN_COST + " TEXT," +
                    COLUMN_IMAGE + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_TILE;
}

