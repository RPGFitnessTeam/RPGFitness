package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_FILE_NAME = "RPGFitnessAPP.db";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("TEST", "CreatingDB");
        try {
            db.execSQL(BoostTable.SQL_CREATE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(BuildingTable.SQL_CREATE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(CharacterTable.SQL_CREATE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(CurrencyTable.SQL_CREATE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(GearTable.SQL_CREATE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(GoalTable.SQL_CREATE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(KingdomTable.SQL_CREATE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(LogEntryTable.SQL_CREATE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(QuestTable.SQL_CREATE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(SpeciesTable.SQL_CREATE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(TileTable.SQL_CREATE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(TipsTable.SQL_CREATE);
        } catch (SQLiteException e) {

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(BoostTable.SQL_DELETE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(BuildingTable.SQL_DELETE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(CharacterTable.SQL_DELETE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(CurrencyTable.SQL_DELETE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(GearTable.SQL_DELETE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(GoalTable.SQL_DELETE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(KingdomTable.SQL_DELETE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(LogEntryTable.SQL_DELETE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(QuestTable.SQL_DELETE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(SpeciesTable.SQL_DELETE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(TileTable.SQL_DELETE);
        } catch (SQLiteException e) {

        }
        try {
            db.execSQL(TipsTable.SQL_DELETE);
        } catch (SQLiteException e) {

        }
        onCreate(db);
    }
}
