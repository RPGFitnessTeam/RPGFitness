package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

/**
 * Created by Austin on 3/11/2017.
 */

public class KingdomTable {

    public static final String TABLE_KINGDOM = "Kingdom";
    public static final String COLUMN_TILE_POS = "KingdomTilePos";
    public static final String COLUMN_TILE = "KingdomTile";

    public static final String[] ALL_COLUMNS = {COLUMN_TILE_POS, COLUMN_TILE};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_KINGDOM + "(" +
                    COLUMN_TILE_POS + " INTEGER," +
                    COLUMN_TILE + " INTEGER" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_KINGDOM;
}
