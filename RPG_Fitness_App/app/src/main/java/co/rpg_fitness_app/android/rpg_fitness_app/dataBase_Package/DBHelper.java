package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_FILE_NAME = "RPGFitnessAPP.db";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BoostTable.SQL_CREATE);
        db.execSQL(BuildingTable.SQL_CREATE);
        db.execSQL(CharacterTable.SQL_CREATE);
        db.execSQL(CurrencyTable.SQL_CREATE);
        db.execSQL(GearTable.SQL_CREATE);
        db.execSQL(GoalTable.SQL_CREATE);
        db.execSQL(KingdomTable.SQL_CREATE);
        db.execSQL(LogEntryTable.SQL_CREATE);
        db.execSQL(QuestTable.SQL_CREATE);
        db.execSQL(SpeciesTable.SQL_CREATE);
        db.execSQL(TileTable.SQL_CREATE);
        db.execSQL(TipsTable.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(BoostTable.SQL_DELETE);
        db.execSQL(BuildingTable.SQL_DELETE);
        db.execSQL(CharacterTable.SQL_DELETE);
        db.execSQL(CurrencyTable.SQL_DELETE);
        db.execSQL(GearTable.SQL_DELETE);
        db.execSQL(GoalTable.SQL_DELETE);
        db.execSQL(KingdomTable.SQL_DELETE);
        db.execSQL(LogEntryTable.SQL_DELETE);
        db.execSQL(QuestTable.SQL_DELETE);
        db.execSQL(SpeciesTable.SQL_DELETE);
        db.execSQL(TileTable.SQL_DELETE);
        db.execSQL(TipsTable.SQL_DELETE);
        onCreate(db);
    }
}
