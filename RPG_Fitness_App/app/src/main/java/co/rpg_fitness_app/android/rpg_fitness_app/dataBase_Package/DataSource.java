package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Boost;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Character;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Gear;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.Species;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.Goal;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.LogEntry;
import co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package.Tips;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Building;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Kingdom;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Tile;
import co.rpg_fitness_app.android.rpg_fitness_app.quest_Package.Quest;

// TODO: Start Building Unit Tests
// TODO: Add sample objects to the database

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSource(Context context) {
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open() {
        Log.d("open", "Opening DB!");
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }

    public void upgrade() {
        mDbHelper.onUpgrade(mDatabase, mDatabase.getVersion(), mDatabase.getVersion() + 1);
    }

    public void seedDatabase() {
        Log.d("seedDatabase", "Seeding DB!");
        if (DatabaseUtils.queryNumEntries(mDatabase, BoostTable.TABlE_BOOSTS) == 0
                && BoostDataProvider.boostList != null) {
            for (Boost boost :
                    BoostDataProvider.boostList) {
                try {
                    insertBoost(boost);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

        if (DatabaseUtils.queryNumEntries(mDatabase, BuildingTable.TABLE_BUILDINGS) == 0
                && BuildingDataProvider.buildingList != null) {
            for (Building building :
                    BuildingDataProvider.buildingList) {
                try {
                    insertBuilding(building);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

        if (DatabaseUtils.queryNumEntries(mDatabase, CharacterTable.TABLE_CHARACTER) == 0
                && CharacterDataProvider.characterList != null) {
            for (Character character :
                    CharacterDataProvider.characterList) {
                try {
                    insertCharacter(character);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

        if (DatabaseUtils.queryNumEntries(mDatabase, CurrencyTable.TABLE_CURRENCY) == 0
                && CurrencyDataProvider.currencyList != null) {
            for (Currency currency :
                    CurrencyDataProvider.currencyList) {
                try {
                    insertCurrency(currency);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

        if (DatabaseUtils.queryNumEntries(mDatabase, GearTable.TABLE_GEAR) == 0
                && GearDataProvider.gearList != null) {
            for (Gear gear :
                    GearDataProvider.gearList) {
                try {
                    insertGear(gear);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

        if (DatabaseUtils.queryNumEntries(mDatabase, GoalTable.TABLE_GOAL) == 0
                && GoalDataProvider.goalList != null) {
            for (Goal goal :
                    GoalDataProvider.goalList) {
                try {
                    insertGoal(goal);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

        if (DatabaseUtils.queryNumEntries(mDatabase, KingdomTable.TABLE_KINGDOM) == 0
                && KingdomDataProvider.kingdomList != null) {
            for (Kingdom kingdom :
                    KingdomDataProvider.kingdomList) {
                try {
                    insertKingdom(kingdom);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

       if (DatabaseUtils.queryNumEntries(mDatabase, LogEntryTable.TABLE_LOG_ENTRY) == 0
                && LogEntryDataProvider.logEntryList != null) {
            for (LogEntry logEntry :
                    LogEntryDataProvider.logEntryList) {
                try {
                    insertLogEntry(logEntry);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
        // TODO Still don't have quests
        /*
        if (DatabaseUtils.queryNumEntries(mDatabase, QuestTable.TABLE_QUEST) == 0
                && QuestDataProvider.questList != null) {
            for (Quest quest :
                    QuestDataProvider.questList) {
                try {
                    insertQuest(quest);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
        */
        if (DatabaseUtils.queryNumEntries(mDatabase, SpeciesTable.TABLE_SPECIES) == 0
                && SpeciesDataProvider.speciesList != null) {
            for (Species species :
                    SpeciesDataProvider.speciesList) {
                try {
                    insertSpecies(species);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

        if (DatabaseUtils.queryNumEntries(mDatabase, TileTable.TABLE_TILE) == 0
                && TileDataProvider.tileList != null) {
            for (Tile tile :
                    TileDataProvider.tileList) {
                try {
                    insertTile(tile);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

        if (DatabaseUtils.queryNumEntries(mDatabase, TipsTable.TABLE_TIPS) == 0
                && TipsDataProvider.tipsList != null) {
            for (Tips tips :
                    TipsDataProvider.tipsList) {
                try {
                    insertTip(tips);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean insertBoost(Boost boost) {
        if (boost == null) return false;

        String compare[] = {boost.getID()};
        Cursor cursor = mDatabase.query(BoostTable.TABlE_BOOSTS, BoostTable.ALL_COLUMNS,
                BoostTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(3);
        values.put(BoostTable.COLUMN_ID, boost.getID());
        values.put(BoostTable.COLUMN_AMOUNT, boost.getAmount());
        values.put(BoostTable.COLUMN_TYPE, boost.getBoostType());

        mDatabase.insert(BoostTable.TABlE_BOOSTS, null, values);
        cursor.close();
        return true;
    }

    public boolean insertBuilding(Building building) {
        if (building == null) return false;

        String compare[] = {building.getId()};
        Cursor cursor = mDatabase.query(BuildingTable.TABLE_BUILDINGS, BuildingTable.ALL_COLUMNS,
                BuildingTable.COLUMN_ID + "=?", compare, null, null, null);
        if (cursor.getCount() != 0) {
            Log.d("insertBuilding", "Duplicate ID Found");
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(9);
        values.put(BuildingTable.COLUMN_ID, building.getId());
        values.put(BuildingTable.COLUMN_NAME, building.getName());

        if (building.getCost() == null)
            values.put(BuildingTable.COLUMN_COST, "");
        else
            values.put(BuildingTable.COLUMN_COST, building.getCost().getId());

        values.put(BuildingTable.COLUMN_CATEGORY, building.getCategory());
        values.put(BuildingTable.COLUMN_TIER, building.getTier());

        if (building.getGoldBoost() == null)
            values.put(BuildingTable.COLUMN_GOLD_BOOST, "");
        else
            values.put(BuildingTable.COLUMN_GOLD_BOOST, building.getGoldBoost().getID());

        if (building.getWoodBoost() == null)
            values.put(BuildingTable.COLUMN_WOOD_BOOST, "");
        else
            values.put(BuildingTable.COLUMN_WOOD_BOOST, building.getWoodBoost().getID());

        if (building.getStoneBoost() == null)
            values.put(BuildingTable.COLUMN_STONE_BOOST, "");
        else
            values.put(BuildingTable.COLUMN_STONE_BOOST, building.getStoneBoost().getID());

        values.put(BuildingTable.COLUMN_IMAGE, building.getImageName());

        mDatabase.insert(BuildingTable.TABLE_BUILDINGS, null, values);
        insertCurrency(building.getCost());
        insertBoost(building.getGoldBoost());
        insertBoost(building.getWoodBoost());
        insertBoost(building.getStoneBoost());

        cursor.close();
        return true;
    }

    public boolean insertCharacter(Character character) {
        if (character == null) return false;

        String compare[] = {character.getID()};
        Cursor cursor = mDatabase.query(CharacterTable.TABLE_CHARACTER, CharacterTable.ALL_COLUMNS,
                CharacterTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(4);
        values.put(CharacterTable.COLUMN_ID, character.getID());
        values.put(CharacterTable.COLUMN_NAME, character.getName());

        if (character.getSpecies() == null)
            values.put(CharacterTable.COLUMN_SPECIES, "");
        else
            values.put(CharacterTable.COLUMN_SPECIES, character.getSpecies().getID());

        if (character.getCurrency() == null)
            values.put(CharacterTable.COLUMN_CURRENCY, "");
        else
            values.put(CharacterTable.COLUMN_CURRENCY, character.getCurrency().getId());

        mDatabase.insert(CharacterTable.TABLE_CHARACTER, null, values);
        insertCurrency(character.getCurrency());
        insertSpecies(character.getSpecies());

        cursor.close();
        return true;
    }

    public boolean insertCurrency(Currency currency) {
        if (currency == null) return false;

        String compare[] = {currency.getId()};
        Cursor cursor = mDatabase.query(CurrencyTable.TABLE_CURRENCY, CurrencyTable.ALL_COLUMNS,
                CurrencyTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(7);
        values.put(CurrencyTable.COLUMN_ID, currency.getId());
        values.put(CurrencyTable.COLUMN_GOLD, currency.getGold());
        values.put(CurrencyTable.COLUMN_WOOD, currency.getWood());
        values.put(CurrencyTable.COLUMN_STONE, currency.getStone());
        values.put(CurrencyTable.COLUMN_MISC1, currency.getMisc1());
        values.put(CurrencyTable.COLUMN_MISC2, currency.getMisc2());
        values.put(CurrencyTable.COLUMN_MISC3, currency.getMisc3());

        mDatabase.insert(CurrencyTable.TABLE_CURRENCY, null, values);
        cursor.close();
        return true;
    }

    public boolean insertGear(Gear gear) {
        if (gear == null) return false;

        String compare[] = {gear.getID()};
        Cursor cursor = mDatabase.query(GearTable.TABLE_GEAR, GearTable.ALL_COLUMNS,
                GearTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() != 0) {
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(8);
        values.put(GearTable.COLUMN_ID, gear.getID());
        values.put(GearTable.COLUMN_NAME, gear.getName());
        values.put(GearTable.COLUMN_CATEGORY, gear.getCategory());

        if (gear.getCost() == null)
            values.put(GearTable.COLUMN_COST, "");
        else
            values.put(GearTable.COLUMN_COST, gear.getCost().getId());

        if (gear.getBoost() == null)
            values.put(GearTable.COLUMN_BOOST, "");
        else
            values.put(GearTable.COLUMN_BOOST, gear.getBoost().getID());

        values.put(GearTable.COLUMN_OWNED, gear.isOwned() ? 1 : 0);
        values.put(GearTable.COLUMN_EQUIPPED, gear.isEquipped() ? 1 : 0);
        values.put(GearTable.COLUMN_IMAGE, gear.getImageName());

        mDatabase.insert(GearTable.TABLE_GEAR, null, values);
        insertCurrency(gear.getCost());
        insertBoost(gear.getBoost());

        cursor.close();
        return true;
    }

    public boolean insertGoal(Goal goal) {
        if (goal == null) return false;

        String compare[] = {goal.getGoalId()};
        Cursor cursor = mDatabase.query(GoalTable.TABLE_GOAL, GoalTable.ALL_COLUMNS,
                GoalTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(8);
        values.put(GoalTable.COLUMN_ID, goal.getGoalId());

        if (goal.getGoalActivity() == null)
            values.put(GoalTable.COLUMN_ACTIVITY, "");
        else
            values.put(GoalTable.COLUMN_ACTIVITY, goal.getGoalActivity().getID());

        values.put(GoalTable.COLUMN_START_VALUE, goal.getStartValue());
        values.put(GoalTable.COLUMN_CURRENT_VALUE, goal.getCurrentValue());
        values.put(GoalTable.COLUMN_END_VALUE, goal.getEndValue());
        values.put(GoalTable.COLUMN_CONSISTENCY, goal.isConsistencyGoal() ? 1 : 0);
        values.put(GoalTable.COLUMN_GAPS, goal.doesAllowGaps() ? 1 : 0);
        values.put(GoalTable.COLUMN_MASTER, goal.isMasterQuest() ? 1 : 0);

        mDatabase.insert(GoalTable.TABLE_GOAL, null, values);
        insertLogEntry(goal.getGoalActivity());

        cursor.close();
        return true;
    }

    public boolean insertKingdom(Kingdom kingdom) {
        if (kingdom == null) return false;

        Cursor cursor = null;
        ArrayList<Tile> grid = kingdom.getMyGrid();

        if (grid == null) {
            for (int i = 0; i < 20; i++) {
                grid.add(i, new Tile(i));
            }
        }

        for (int i = 0; i < grid.size(); i++) {
            Log.d("TEST", "Insert Kingdom iteration "+i);
            String compare[] = {""+i};
            cursor = mDatabase.query(KingdomTable.TABLE_KINGDOM, KingdomTable.ALL_COLUMNS,
                    KingdomTable.COLUMN_TILE_POS + "=?", compare, null, null, null);

            if (cursor.getCount() == 0) {
                ContentValues values = new ContentValues(2);
                values.put(KingdomTable.COLUMN_TILE_POS, grid.get(i).getTileNumber());
                values.put(KingdomTable.COLUMN_TILE, grid.get(i).getId());

                mDatabase.insert(KingdomTable.TABLE_KINGDOM, null, values);
                insertTile(grid.get(i));
            }
        }

        cursor.close();
        return true;
    }

    public boolean insertLogEntry(LogEntry logEntry) {
        if (logEntry == null) return false;

        String compare[] = {logEntry.getID()};
        Cursor cursor = mDatabase.query(LogEntryTable.TABLE_LOG_ENTRY, LogEntryTable.ALL_COLUMNS,
                LogEntryTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() != 0) {
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(9);
        values.put(LogEntryTable.COLUMN_ID, logEntry.getID());
        values.put(LogEntryTable.COLUMN_DATE, logEntry.getDate());
        values.put(LogEntryTable.COLUMN_ACTIVITY, logEntry.getActivity());
        values.put(LogEntryTable.COLUMN_SUB_TYPE, logEntry.getSubType());
        values.put(LogEntryTable.COLUMN_DURATION, logEntry.getDuration());
        values.put(LogEntryTable.COLUMN_DISTANCE, logEntry.getDistance());
        values.put(LogEntryTable.COLUMN_COUNT, logEntry.getCount());
        values.put(LogEntryTable.COLUMN_INTENSITY, logEntry.getIntensity());
        values.put(LogEntryTable.COLUMN_WEIGHT, logEntry.getWeight());

        mDatabase.insert(LogEntryTable.TABLE_LOG_ENTRY, null, values);

        cursor.close();
        return true;
    }
    /*
    public boolean insertQuest(Quest quest) {

        String compare[] = {quest.getQ()};
        Cursor cursor = mDatabase.query(QuestTable.TABLE_QUEST, QuestTable.ALL_COLUMNS,
                QuestTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(10);
        values.put(QuestTable.COLUMN_ID, quest.getId());
        values.put(QuestTable.COLUMN_NAME, quest.getName());
        values.put(QuestTable.COLUMN_DESCRIPTION, quest.getDescription());
        values.put(QuestTable.COLUMN_REWARD, quest.getReward().getId());
        values.put(QuestTable.COLUMN_TIME_REMAINING, quest.getTimeRemains());
        values.put(QuestTable.COLUMN_START, quest.getQuestStart());
        values.put(QuestTable.COLUMN_COMPLETE, quest.isQuestComplete() ? 1 : 0);
        values.put(QuestTable.COLUMN_SKIPPED, quest.isQuestSkipped() ? 1 : 0);
        values.put(QuestTable.COLUMN_EXPIRED, quest.isQuestExpired() ? 1 : 0);
        values.put(QuestTable.COLUMN_GOAL, quest.getGoal().getID());

        mDatabase.insert(QuestTable.TABLE_QUEST, null, values);
        insertCurrency(quest.getReward());
        if (quest.getGoal() != null) {
            insertGoal(quest.getGoal());
        }

        cursor.close();
        return true;
    }
    */
    public boolean insertSpecies(Species species) {
        if (species == null) return false;

        String compare[] = {species.getID()};
        Cursor cursor = mDatabase.query(SpeciesTable.TABLE_SPECIES, SpeciesTable.ALL_COLUMNS,
                SpeciesTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() != 0) {
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(4);
        values.put(SpeciesTable.COLUMN_ID, species.getID());
        values.put(SpeciesTable.COLUMN_NAME, species.getName());
        values.put(SpeciesTable.COLUMN_DESCRIPTION, species.getDescription());
        values.put(SpeciesTable.COLUMN_IMAGE, species.getImageName());

        mDatabase.insert(SpeciesTable.TABLE_SPECIES, null, values);

        cursor.close();
        return true;
    }

    public boolean insertTile(Tile tile) {
        if (tile == null) {
            Log.d("TEST", "FAILED TO INSERT TILE");
            return false;
        }
        Log.d("TEST", "Inserting Tile");
        String compare[] = {tile.getId()};
        Cursor cursor = mDatabase.query(TileTable.TABLE_TILE, TileTable.ALL_COLUMNS,
                TileTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.close();
            Log.d("TEST", "Duplicate Tile ID found when inserting tile");
            return false;
        }

        ContentValues values = new ContentValues(6);
        values.put(TileTable.COLUMN_ID, tile.getId());
        values.put(TileTable.COLUMN_POSITION, tile.getTileNumber());
        values.put(TileTable.COLUMN_LOCKED, tile.isLocked() ? 1 : 0);

        if (tile.getMyBuilding() == null)
            values.put(TileTable.COLUMN_BUILDING, "");
        else
            values.put(TileTable.COLUMN_BUILDING, tile.getMyBuilding().getId());

        if (tile.getTileCost() == null)
            values.put(TileTable.COLUMN_COST, "");
        else
            values.put(TileTable.COLUMN_COST, tile.getTileCost().getId());

        values.put(TileTable.COLUMN_IMAGE, tile.getImageName());

        mDatabase.insert(TileTable.TABLE_TILE, null, values);
        insertBuilding(tile.getMyBuilding());
        insertCurrency(tile.getTileCost());

        cursor.close();
        return true;
    }

    public boolean insertTip(Tips tip) {
        if (tip == null) return false;

        String compare[] = {tip.getId()};
        Cursor cursor = mDatabase.query(TipsTable.TABLE_TIPS, TipsTable.ALL_COLUMNS,
                TipsTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() != 0) {
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(6);
        values.put(TipsTable.COLUMN_ID, tip.getId());
        values.put(TipsTable.COLUMN_ACTIVITY, tip.getActivity().getID());
        values.put(TipsTable.COLUMN_VISITED, tip.isBeenVisited() ? 1 : 0);
        values.put(TipsTable.COLUMN_THUMBS_UP, tip.isThumbsUp() ? 1 : 0);
        values.put(TipsTable.COLUMN_THUMBS_DOWN, tip.isThumbsDown() ? 1 : 0);

        mDatabase.insert(TipsTable.TABLE_TIPS, null, values);

        cursor.close();
        return true;
    }

    public ArrayList<Boost> getAllBoosts() {
        ArrayList<Boost> boosts = new ArrayList<Boost>();

        Cursor cursor = null;
        cursor = mDatabase.query(BoostTable.TABlE_BOOSTS, BoostTable.ALL_COLUMNS,
                null, null, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        }

        while (cursor.moveToNext()) {
            Boost boost = new Boost();
            boost.setID(cursor.getString(
                    cursor.getColumnIndex(BoostTable.COLUMN_ID)));
            boost.setAmount(cursor.getDouble(
                    cursor.getColumnIndex(BoostTable.COLUMN_AMOUNT)));
            boost.setBoostType(cursor.getString(
                    cursor.getColumnIndex(BoostTable.COLUMN_TYPE)));
            boosts.add(boost);
        }
        cursor.close();
        return boosts;
    }

    public ArrayList<Building> getAllBuildings() {
        ArrayList<Building> buildings = new ArrayList<Building>();

        Cursor cursor = null;
        cursor = mDatabase.query(BuildingTable.TABLE_BUILDINGS, BuildingTable.ALL_COLUMNS,
                null, null, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        }

        while (cursor.moveToNext()) {
            Building building = new Building();
            building.setId(cursor.getString(
                    cursor.getColumnIndex(BuildingTable.COLUMN_ID)));
            building.setName(cursor.getString(
                    cursor.getColumnIndex(BuildingTable.COLUMN_NAME)));
            building.setCost(getCurrency(cursor.getString(
                    cursor.getColumnIndex(BuildingTable.COLUMN_COST))));
            building.setCategory(cursor.getString(
                    cursor.getColumnIndex(BuildingTable.COLUMN_CATEGORY)));
            building.setTier(cursor.getInt(
                    cursor.getColumnIndex(BuildingTable.COLUMN_TIER)));
            building.setGoldBoost(getBoost(cursor.getString(
                    cursor.getColumnIndex(BuildingTable.COLUMN_GOLD_BOOST))));
            building.setWoodBoost(getBoost(cursor.getString(
                    cursor.getColumnIndex(BuildingTable.COLUMN_WOOD_BOOST))));
            building.setStoneBoost(getBoost(cursor.getString(
                    cursor.getColumnIndex(BuildingTable.COLUMN_STONE_BOOST))));
            building.setImageName(cursor.getString(
                    cursor.getColumnIndex(BuildingTable.COLUMN_IMAGE)));
            buildings.add(building);
        }
        cursor.close();
        return buildings;
    }

    public ArrayList<Character> getAllCharacters() {
        ArrayList<Character> characters = new ArrayList<Character>();

        Cursor cursor = null;
        cursor = mDatabase.query(CharacterTable.TABLE_CHARACTER, CharacterTable.ALL_COLUMNS,
                null, null, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        }

        while (cursor.moveToNext()) {
            Character character = new Character();
            character.setID(cursor.getString(
                    cursor.getColumnIndex(CharacterTable.COLUMN_ID)));
            character.setName(cursor.getString(
                    cursor.getColumnIndex(CharacterTable.COLUMN_NAME)));
            character.setSpecies(getSpecies(cursor.getString(
                    cursor.getColumnIndex(CharacterTable.COLUMN_SPECIES))));
            character.setCurrency(getCurrency(cursor.getString(
                    cursor.getColumnIndex(CharacterTable.COLUMN_CURRENCY))));
            characters.add(character);
        }
        cursor.close();
        return characters;
    }

    public ArrayList<Currency> getAllCurrency() {
        ArrayList<Currency> currencies = new ArrayList<Currency>();

        Cursor cursor = null;
        cursor = mDatabase.query(CurrencyTable.TABLE_CURRENCY, CurrencyTable.ALL_COLUMNS,
                null, null, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        }

        while (cursor.moveToNext()) {
            Currency currency = new Currency();
            currency.setId(cursor.getString(
                    cursor.getColumnIndex(CurrencyTable.COLUMN_ID)));
            currency.setGold(cursor.getInt(
                    cursor.getColumnIndex(CurrencyTable.COLUMN_GOLD)));
            currency.setWood(cursor.getInt(
                    cursor.getColumnIndex(CurrencyTable.COLUMN_WOOD)));
            currency.setStone(cursor.getInt(
                    cursor.getColumnIndex(CurrencyTable.COLUMN_STONE)));
            currency.setMisc1(cursor.getInt(
                    cursor.getColumnIndex(CurrencyTable.COLUMN_MISC1)));
            currency.setMisc2(cursor.getInt(
                    cursor.getColumnIndex(CurrencyTable.COLUMN_MISC2)));
            currency.setMisc3(cursor.getInt(
                    cursor.getColumnIndex(CurrencyTable.COLUMN_MISC3)));
            currencies.add(currency);
        }
        cursor.close();
        return currencies;
    }

    public ArrayList<Gear> getAllGear() {
        ArrayList<Gear> gears = new ArrayList<Gear>();

        Cursor cursor = null;
        cursor = mDatabase.query(GearTable.TABLE_GEAR, GearTable.ALL_COLUMNS,
                null, null, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        }

        while (cursor.moveToNext()) {
            Gear gear = new Gear();
            gear.setID(cursor.getString(
                    cursor.getColumnIndex(GearTable.COLUMN_ID)));
            gear.setName(cursor.getString(
                    cursor.getColumnIndex(GearTable.COLUMN_NAME)));
            gear.setCategory(cursor.getString(
                    cursor.getColumnIndex(GearTable.COLUMN_CATEGORY)));
            gear.setCost(getCurrency(cursor.getString(
                    cursor.getColumnIndex(GearTable.COLUMN_COST))));
            gear.setBoost(getBoost(cursor.getString(
                    cursor.getColumnIndex(GearTable.COLUMN_BOOST))));
            gear.setOwned(cursor.getInt(
                    cursor.getColumnIndex(GearTable.COLUMN_OWNED)) == 1);
            gear.setEquipped(cursor.getInt(
                    cursor.getColumnIndex(GearTable.COLUMN_EQUIPPED)) == 1);
            gear.setImageName(cursor.getString(
                    cursor.getColumnIndex(GearTable.COLUMN_IMAGE)));
            gears.add(gear);
        }
        cursor.close();
        return gears;
    }

    public ArrayList<Goal> getAllGoals() {
        ArrayList<Goal> goals = new ArrayList<Goal>();

        Cursor cursor = null;
        cursor = mDatabase.query(GoalTable.TABLE_GOAL, GoalTable.ALL_COLUMNS,
                null, null, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        }

        while (cursor.moveToNext()) {
            Goal goal = new Goal();
            goal.setGoalId(cursor.getString(
                    cursor.getColumnIndex(GoalTable.COLUMN_ID)));
            goal.setGoalActivity(getLogEntry(cursor.getString(
                    cursor.getColumnIndex(GoalTable.COLUMN_ACTIVITY))));
            goal.setStartValue(cursor.getInt(
                    cursor.getColumnIndex(GoalTable.COLUMN_START_VALUE)));
            goal.setCurrentValue(cursor.getInt(
                    cursor.getColumnIndex(GoalTable.COLUMN_CURRENT_VALUE)));
            goal.setEndValue(cursor.getInt(
                    cursor.getColumnIndex(GoalTable.COLUMN_END_VALUE)));
            goal.setConsistencyGoal(cursor.getInt(
                    cursor.getColumnIndex(GoalTable.COLUMN_CONSISTENCY)) == 1);
            goal.setDoesAllowGaps(cursor.getInt(
                    cursor.getColumnIndex(GoalTable.COLUMN_GAPS)) == 1);
            goal.setMasterQuest(cursor.getInt(
                    cursor.getColumnIndex(GoalTable.COLUMN_MASTER)) == 1);
            goals.add(goal);
        }
        cursor.close();
        return goals;
    }

    public Kingdom getAllKingdoms() {
        Log.d("getAllKingdoms", "Getting Kingdom");
        Kingdom kingdom = new Kingdom();

        Cursor cursor = null;
        Cursor cursor2 = null;
        cursor = mDatabase.query(KingdomTable.TABLE_KINGDOM, KingdomTable.ALL_COLUMNS,
                null, null, null, null, KingdomTable.COLUMN_TILE_POS);
        Log.d("getAllKingdoms", "Cursor count in kingdom get "+cursor.getCount());

        if (cursor.getCount() == 0) {
            Log.d("getAllKingdoms", "Could not find kingdom");
            cursor.close();
            return null;
        }

        ArrayList<Tile> tempGrid = new ArrayList<Tile>();
        int pos = 0;
        while (cursor.moveToNext()) {
            Log.d("getAllKingdoms", "Get kingdom iteration count: " + pos);
            String compare[] = {cursor.getString(
                    cursor.getColumnIndex(KingdomTable.COLUMN_TILE))};

            cursor2 = mDatabase.query(TileTable.TABLE_TILE, TileTable.ALL_COLUMNS,
                    TileTable.COLUMN_ID + "=?", compare, null, null, null);

            if (cursor2.getCount() == 1) {
                Log.d("getAllKingdoms", "Found tile!");
                Tile tile = new Tile();

                cursor2.moveToFirst();

                tile.setId(cursor2.getString(
                        cursor2.getColumnIndex(TileTable.COLUMN_ID)));
                tile.setTileNumber(cursor2.getInt(
                        cursor2.getColumnIndex(TileTable.COLUMN_POSITION)));
                tile.setLocked(cursor2.getInt(
                        cursor2.getColumnIndex(TileTable.COLUMN_LOCKED)) == 1);
                tile.setMyBuilding(getBuilding(cursor2.getString(
                        cursor2.getColumnIndex(TileTable.COLUMN_BUILDING))));
                tile.setTileCost(getCurrency(cursor2.getString(
                        cursor2.getColumnIndex(TileTable.COLUMN_COST))));
                tile.setImageName(cursor2.getString(
                        cursor2.getColumnIndex(TileTable.COLUMN_IMAGE)));
                tempGrid.add(tile);
            } else {
                Tile newTile = new Tile(pos);
                tempGrid.add(newTile);
            }
            pos++;
        }
        kingdom.setMyGrid(tempGrid);
        cursor.close();
        cursor2.close();
        return kingdom;
    }

    public ArrayList<LogEntry> getAllLogEntries() {
        ArrayList<LogEntry> logEntries = new ArrayList<LogEntry>();

        Cursor cursor = null;
        cursor = mDatabase.query(LogEntryTable.TABLE_LOG_ENTRY, LogEntryTable.ALL_COLUMNS,
                null, null, null, null, null);

        while (cursor.moveToNext()) {
            LogEntry logEntry = new LogEntry(cursor.getInt(
                    cursor.getColumnIndex(LogEntryTable.COLUMN_ACTIVITY)));

            logEntry.setID(cursor.getString(
                    cursor.getColumnIndex(LogEntryTable.COLUMN_ID)));
            logEntry.setDate(cursor.getInt(
                    cursor.getColumnIndex(LogEntryTable.COLUMN_DATE)));
            logEntry.setSubType(cursor.getInt(
                    cursor.getColumnIndex(LogEntryTable.COLUMN_SUB_TYPE)));
            logEntry.setDuration(cursor.getInt(
                    cursor.getColumnIndex(LogEntryTable.COLUMN_DURATION)));
            logEntry.setDistance(cursor.getInt(
                    cursor.getColumnIndex(LogEntryTable.COLUMN_DISTANCE)));
            logEntry.setCount(cursor.getInt(
                    cursor.getColumnIndex(LogEntryTable.COLUMN_COUNT)));
            logEntry.setIntensity(cursor.getInt(
                    cursor.getColumnIndex(LogEntryTable.COLUMN_INTENSITY)));
            logEntry.setWeight(cursor.getInt(
                    cursor.getColumnIndex(LogEntryTable.COLUMN_WEIGHT)));
            logEntries.add(logEntry);
        }
        cursor.close();
        return logEntries;
    }
    // TODO We don't have quests yet
    /*
    public ArrayList<Quest> getAllQuests() {
        ArrayList<Quest> quests = new ArrayList<Quest>();

        Cursor cursor = null;
        cursor = mDatabase.query(QuestTable.TABLE_QUEST, QuestTable.ALL_COLUMNS,
                null, null, null, null, null);

        while (cursor.moveToNext()) {
            Quest quest = new Quest();
            quest.setID(cursor.getString(
                    cursor.getColumnIndex(QuestTable.COLUMN_ID)));
            quest.setName(cursor.getString(
                    cursor.getColumnIndex(QuestTable.COLUMN_NAME)));
            quest.setDescription(cursor.getString(
                    cursor.getColumnIndex(QuestTable.COLUMN_DESCRIPTION)));
            quest.setReward(cursor.getString(
                    cursor.getColumnIndex(QuestTable.COLUMN_REWARD)));
            quest.setHoursRemaining(cursor.getInt(
                    cursor.getColumnIndex(QuestTable.COLUMN_TIME_REMAINING)));
            quest.setStartDate(cursor.getString(
                    cursor.getColumnIndex(QuestTable.COLUMN_START)));
            quest.setIsQuestComplete(cursor.getInt(
                    cursor.getColumnIndex(QuestTable.COLUMN_COMPLETE)) == 1);
            quest.setIsQuestSkipped(cursor.getInt(
                    cursor.getColumnIndex(QuestTable.COLUMN_SKIPPED)) == 1);
            quest.setIsQuestExpired(cursor.getInt(
                    cursor.getColumnIndex(QuestTable.COLUMN_EXPIRED)) == 1);
            quest.setGoal(getGoal(cursor.getString(
                    cursor.getColumnIndex(QuestTable.COLUMN_GOAL))));
            quests.add(quest);
        }
        cursor.close();
        return quests;
    }
    */

    public ArrayList<Species> getAllSpecies() {
        ArrayList<Species> speciesList = new ArrayList<Species>();

        Cursor cursor = null;
        cursor = mDatabase.query(SpeciesTable.TABLE_SPECIES, SpeciesTable.ALL_COLUMNS,
                null, null, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        }

        while (cursor.moveToNext()) {
            Species species = new Species();
            species.setID(cursor.getString(
                    cursor.getColumnIndex(SpeciesTable.COLUMN_ID)));
            species.setName(cursor.getString(
                    cursor.getColumnIndex(SpeciesTable.COLUMN_NAME)));
            species.setDescription(cursor.getString(
                    cursor.getColumnIndex(SpeciesTable.COLUMN_DESCRIPTION)));
            species.setImageName(cursor.getString(
                    cursor.getColumnIndex(SpeciesTable.COLUMN_IMAGE)));
            speciesList.add(species);
        }
        cursor.close();
        return speciesList;
    }

    public ArrayList<Tile> getAllTiles() {
        ArrayList<Tile> tiles = new ArrayList<Tile>();

        Cursor cursor = null;
        cursor = mDatabase.query(TileTable.TABLE_TILE, TileTable.ALL_COLUMNS,
                null, null, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        }

        while (cursor.moveToNext()) {
            Log.d("getAllTiles", "Tile found");
            Tile tile = new Tile();
            tile.setId(cursor.getString(
                    cursor.getColumnIndex(TileTable.COLUMN_ID)));
            tile.setTileNumber(cursor.getInt(
                    cursor.getColumnIndex(TileTable.COLUMN_POSITION)));
            tile.setLocked(cursor.getInt(
                    cursor.getColumnIndex(TileTable.COLUMN_LOCKED)) == 1);
            tile.setMyBuilding(getBuilding(cursor.getString(
                    cursor.getColumnIndex(TileTable.COLUMN_BUILDING))));
            tile.setTileCost(getCurrency(cursor.getString(
                    cursor.getColumnIndex(TileTable.COLUMN_COST))));
            tile.setImageName(cursor.getString(
                    cursor.getColumnIndex(TileTable.COLUMN_IMAGE)));
            tiles.add(tile);
        }
        cursor.close();
        return tiles;
    }

    public ArrayList<Tips> getAllTips() {
        ArrayList<Tips> tips = new ArrayList<Tips>();

        Cursor cursor = null;
        cursor = mDatabase.query(TipsTable.TABLE_TIPS, TipsTable.ALL_COLUMNS,
                null, null, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        }

        while (cursor.moveToNext()) {
            Tips tip = new Tips();
            tip.setId(cursor.getString(
                    cursor.getColumnIndex(TipsTable.COLUMN_ID)));
            tip.setActivity(getLogEntry(cursor.getString(
                    cursor.getColumnIndex(TipsTable.COLUMN_ACTIVITY))));
            tip.setBeenVisited(cursor.getInt(
                    cursor.getColumnIndex(TipsTable.COLUMN_VISITED)) == 1);
            tip.setThumbsUp(cursor.getInt(
                    cursor.getColumnIndex(TipsTable.COLUMN_THUMBS_UP)) == 1);
            tip.setThumbsDown(cursor.getInt(
                    cursor.getColumnIndex(TipsTable.COLUMN_THUMBS_DOWN)) == 1);
            tips.add(tip);
        }
        cursor.close();
        return tips;
    }

    public Boost getBoost(String ID) {

        String compare[] = {ID};
        Cursor cursor = mDatabase.query(BoostTable.TABlE_BOOSTS, BoostTable.ALL_COLUMNS,
                BoostTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+ID);
            return null;
        }

        cursor.moveToFirst();
        Boost boost = new Boost();
        boost.setID(cursor.getString(
                cursor.getColumnIndex(BoostTable.COLUMN_ID)));
        boost.setAmount(cursor.getDouble(
                cursor.getColumnIndex(BoostTable.COLUMN_AMOUNT)));
        boost.setBoostType(cursor.getString(
                cursor.getColumnIndex(BoostTable.COLUMN_TYPE)));

        return boost;
    }

    public Building getBuilding(String ID) {

        String compare[] = {ID};
        Cursor cursor = mDatabase.query(BuildingTable.TABLE_BUILDINGS, BuildingTable.ALL_COLUMNS,
                BuildingTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+ID);
            return null;
        }

        cursor.moveToFirst();
        Building building = new Building();
        building.setId(cursor.getString(
                cursor.getColumnIndex(BuildingTable.COLUMN_ID)));
        building.setName(cursor.getString(
                cursor.getColumnIndex(BuildingTable.COLUMN_NAME)));
        building.setCost(getCurrency(cursor.getString(
                cursor.getColumnIndex(BuildingTable.COLUMN_COST))));
        building.setCategory(cursor.getString(
                cursor.getColumnIndex(BuildingTable.COLUMN_CATEGORY)));
        building.setTier(cursor.getInt(
                cursor.getColumnIndex(BuildingTable.COLUMN_TIER)));
        building.setGoldBoost(getBoost(cursor.getString(
                cursor.getColumnIndex(BuildingTable.COLUMN_GOLD_BOOST))));
        building.setWoodBoost(getBoost(cursor.getString(
                cursor.getColumnIndex(BuildingTable.COLUMN_WOOD_BOOST))));
        building.setStoneBoost(getBoost(cursor.getString(
                cursor.getColumnIndex(BuildingTable.COLUMN_STONE_BOOST))));
        building.setImageName(cursor.getString(
                cursor.getColumnIndex(BuildingTable.COLUMN_IMAGE)));

        return building;
    }

    public Character getCharacter(String ID) {

        String compare[] = {ID};
        Cursor cursor = mDatabase.query(CharacterTable.TABLE_CHARACTER, CharacterTable.ALL_COLUMNS,
                CharacterTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+ID);
            return null;
        }

        cursor.moveToFirst();
        Character character = new Character();
        character.setID(cursor.getString(
                cursor.getColumnIndex(CharacterTable.COLUMN_ID)));
        character.setName(cursor.getString(
                cursor.getColumnIndex(CharacterTable.COLUMN_NAME)));
        character.setSpecies(getSpecies(cursor.getString(
                cursor.getColumnIndex(CharacterTable.COLUMN_SPECIES))));
        character.setCurrency(getCurrency(cursor.getString(
                cursor.getColumnIndex(CharacterTable.COLUMN_CURRENCY))));

        return character;
    }

    public Currency getCurrency(String ID){

        String compare[] = {ID};
        Cursor cursor = mDatabase.query(CurrencyTable.TABLE_CURRENCY, CurrencyTable.ALL_COLUMNS,
                CurrencyTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+ID);
            return null;
        }

        cursor.moveToFirst();
        Currency currency = new Currency();
        currency.setId(cursor.getString(
                cursor.getColumnIndex(CurrencyTable.COLUMN_ID)));
        currency.setGold(cursor.getInt(
                cursor.getColumnIndex(CurrencyTable.COLUMN_GOLD)));
        currency.setWood(cursor.getInt(
                cursor.getColumnIndex(CurrencyTable.COLUMN_WOOD)));
        currency.setStone(cursor.getInt(
                cursor.getColumnIndex(CurrencyTable.COLUMN_STONE)));
        currency.setMisc1(cursor.getInt(
                cursor.getColumnIndex(CurrencyTable.COLUMN_MISC1)));
        currency.setMisc2(cursor.getInt(
                cursor.getColumnIndex(CurrencyTable.COLUMN_MISC2)));
        currency.setMisc3(cursor.getInt(
                cursor.getColumnIndex(CurrencyTable.COLUMN_MISC3)));

        return currency;
    }

    public Gear getGear(String ID){

        String compare[] = {ID};
        Cursor cursor = mDatabase.query(GearTable.TABLE_GEAR, GearTable.ALL_COLUMNS,
                GearTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+ID);
            return null;
        }

        cursor.moveToFirst();
        Gear gear = new Gear();
        gear.setID(cursor.getString(
                cursor.getColumnIndex(GearTable.COLUMN_ID)));
        gear.setName(cursor.getString(
                cursor.getColumnIndex(GearTable.COLUMN_NAME)));
        gear.setCategory(cursor.getString(
                cursor.getColumnIndex(GearTable.COLUMN_CATEGORY)));
        gear.setCost(getCurrency(cursor.getString(
                cursor.getColumnIndex(GearTable.COLUMN_COST))));
        gear.setBoost(getBoost(cursor.getString(
                cursor.getColumnIndex(GearTable.COLUMN_BOOST))));
        gear.setOwned(cursor.getInt(
                cursor.getColumnIndex(GearTable.COLUMN_OWNED)) == 1);
        gear.setEquipped(cursor.getInt(
                cursor.getColumnIndex(GearTable.COLUMN_EQUIPPED)) == 1);
        gear.setImageName(cursor.getString(
                cursor.getColumnIndex(GearTable.COLUMN_IMAGE)));

        return gear;
    }

    public Goal getGoal(String ID){

        String compare[] = {ID};
        Cursor cursor = mDatabase.query(GoalTable.TABLE_GOAL, GoalTable.ALL_COLUMNS,
                GoalTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+ID);
            return null;
        }

        cursor.moveToFirst();
        Goal goal = new Goal();
        goal.setGoalId(cursor.getString(
                cursor.getColumnIndex(GoalTable.COLUMN_ID)));
        goal.setGoalActivity(getLogEntry(cursor.getString(
                cursor.getColumnIndex(GoalTable.COLUMN_ACTIVITY))));
        goal.setStartValue(cursor.getInt(
                cursor.getColumnIndex(GoalTable.COLUMN_START_VALUE)));
        goal.setCurrentValue(cursor.getInt(
                cursor.getColumnIndex(GoalTable.COLUMN_CURRENT_VALUE)));
        goal.setEndValue(cursor.getInt(
                cursor.getColumnIndex(GoalTable.COLUMN_END_VALUE)));
        goal.setConsistencyGoal(cursor.getInt(
                cursor.getColumnIndex(GoalTable.COLUMN_CONSISTENCY)) == 1);
        goal.setDoesAllowGaps(cursor.getInt(
                cursor.getColumnIndex(GoalTable.COLUMN_GAPS)) == 1);
        goal.setMasterQuest(cursor.getInt(
                cursor.getColumnIndex(GoalTable.COLUMN_MASTER)) == 1);

        return goal;
    }

    public LogEntry getLogEntry(String ID){

        String compare[] = {ID};
        Cursor cursor = mDatabase.query(LogEntryTable.TABLE_LOG_ENTRY, LogEntryTable.ALL_COLUMNS,
                LogEntryTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+ID);
            return null;
        }

        cursor.moveToFirst();
        LogEntry logEntry = new LogEntry(cursor.getInt(
                cursor.getColumnIndex(LogEntryTable.COLUMN_ACTIVITY)));

        logEntry.setID(cursor.getString(
                cursor.getColumnIndex(LogEntryTable.COLUMN_ID)));
        logEntry.setDate(cursor.getInt(
                cursor.getColumnIndex(LogEntryTable.COLUMN_DATE)));
        logEntry.setSubType(cursor.getInt(
                cursor.getColumnIndex(LogEntryTable.COLUMN_SUB_TYPE)));
        logEntry.setDuration(cursor.getInt(
                cursor.getColumnIndex(LogEntryTable.COLUMN_DURATION)));
        logEntry.setDistance(cursor.getInt(
                cursor.getColumnIndex(LogEntryTable.COLUMN_DISTANCE)));
        logEntry.setCount(cursor.getInt(
                cursor.getColumnIndex(LogEntryTable.COLUMN_COUNT)));
        logEntry.setIntensity(cursor.getInt(
                cursor.getColumnIndex(LogEntryTable.COLUMN_INTENSITY)));
        logEntry.setWeight(cursor.getInt(
                cursor.getColumnIndex(LogEntryTable.COLUMN_WEIGHT)));

        return logEntry;
    }
    // TODO Still don't have quests
    /*
    public Quest getQuest(String ID){

        String compare[] = {ID};
        Cursor cursor = mDatabase.query(QuestTable.TABLE_QUEST, QuestTable.ALL_COLUMNS,
                QuestTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+ID);
            return null;
        }

        cursor.moveToFirst();

        Quest quest = new Quest();
        quest.setID(cursor.getString(
                cursor.getColumnIndex(QuestTable.COLUMN_ID)));
        quest.setName(cursor.getString(
                cursor.getColumnIndex(QuestTable.COLUMN_NAME)));
        quest.setDescription(cursor.getString(
                cursor.getColumnIndex(QuestTable.COLUMN_DESCRIPTION)));
        quest.setReward(cursor.getString(
                cursor.getColumnIndex(QuestTable.COLUMN_REWARD)));
        quest.setHoursRemaining(cursor.getInt(
                cursor.getColumnIndex(QuestTable.COLUMN_TIME_REMAINING)));
        quest.setStartDate(cursor.getString(
                cursor.getColumnIndex(QuestTable.COLUMN_START)));
        quest.setIsQuestComplete(cursor.getInt(
                cursor.getColumnIndex(QuestTable.COLUMN_COMPLETE)) == 1);
        quest.setIsQuestSkipped(cursor.getInt(
                cursor.getColumnIndex(QuestTable.COLUMN_SKIPPED)) == 1);
        quest.setIsQuestExpired(cursor.getInt(
                cursor.getColumnIndex(QuestTable.COLUMN_EXPIRED)) == 1);
        quest.setGoal(getGoal(cursor.getString(
                cursor.getColumnIndex(QuestTable.COLUMN_GOAL))));

        return quest;
    }
    */
    public Species getSpecies(String ID){

        String compare[] = {ID};
        Cursor cursor = mDatabase.query(SpeciesTable.TABLE_SPECIES, SpeciesTable.ALL_COLUMNS,
                SpeciesTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+ID);
            return null;
        }

        cursor.moveToFirst();

        Species species = new Species();
        species.setID(cursor.getString(
                cursor.getColumnIndex(SpeciesTable.COLUMN_ID)));
        species.setName(cursor.getString(
                cursor.getColumnIndex(SpeciesTable.COLUMN_NAME)));
        species.setDescription(cursor.getString(
                cursor.getColumnIndex(SpeciesTable.COLUMN_DESCRIPTION)));
        species.setImageName(cursor.getString(
                cursor.getColumnIndex(SpeciesTable.COLUMN_IMAGE)));

        return species;
    }

    public Tile getTile(String ID){

        String compare[] = {ID};
        Cursor cursor = mDatabase.query(TileTable.TABLE_TILE, TileTable.ALL_COLUMNS,
                TileTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() <= 0) {
            Log.d("getTile", "TILE NOT FOUND IN GET TILE");
            cursor.close();
            return null;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+ID);
            return null;
        }
        cursor.moveToFirst();
        Tile tile = new Tile();
        tile.setId(cursor.getString(
                cursor.getColumnIndex(TileTable.COLUMN_ID)));
        tile.setTileNumber(cursor.getInt(
                cursor.getColumnIndex(TileTable.COLUMN_POSITION)));
        tile.setLocked(cursor.getInt(
                cursor.getColumnIndex(TileTable.COLUMN_LOCKED)) == 1);
        tile.setMyBuilding(getBuilding(cursor.getString(
                cursor.getColumnIndex(TileTable.COLUMN_BUILDING))));
        tile.setTileCost(getCurrency(cursor.getString(
                cursor.getColumnIndex(TileTable.COLUMN_COST))));
        tile.setImageName(cursor.getString(
                cursor.getColumnIndex(TileTable.COLUMN_IMAGE)));

        return tile;
    }

    public Tips getTips(String ID){

        String compare[] = {ID};
        Cursor cursor = mDatabase.query(TipsTable.TABLE_TIPS, TipsTable.ALL_COLUMNS,
                TipsTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+ID);
            return null;
        }

        cursor.moveToFirst();

        Tips tip = new Tips();
        tip.setId(cursor.getString(
                cursor.getColumnIndex(TipsTable.COLUMN_ID)));
        tip.setActivity(getLogEntry(cursor.getString(
                cursor.getColumnIndex(TipsTable.COLUMN_ACTIVITY))));
        tip.setBeenVisited(cursor.getInt(
                cursor.getColumnIndex(TipsTable.COLUMN_VISITED)) == 1);
        tip.setThumbsUp(cursor.getInt(
                cursor.getColumnIndex(TipsTable.COLUMN_THUMBS_UP)) == 1);
        tip.setThumbsDown(cursor.getInt(
                cursor.getColumnIndex(TipsTable.COLUMN_THUMBS_DOWN)) == 1);

        return tip;
    }

    public boolean updateCharacter(Character character) {
        if (character == null)
            return false;

        String compare[] = {character.getID()};
        Cursor cursor = mDatabase.query(CharacterTable.TABLE_CHARACTER, CharacterTable.ALL_COLUMNS,
                CharacterTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() <= 0) {
            insertCharacter(character);
            cursor.close();
            return false;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+character.getID());
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(4);
        values.put(CharacterTable.COLUMN_ID, character.getID());
        values.put(CharacterTable.COLUMN_NAME, character.getName());
        values.put(CharacterTable.COLUMN_SPECIES, character.getSpecies().getID());
        values.put(CharacterTable.COLUMN_CURRENCY, character.getCurrency().getId());

        mDatabase.update(CharacterTable.TABLE_CHARACTER, values, CharacterTable.COLUMN_ID+"=?",
                new String[]{character.getID()});
        updateCurrency(character.getCurrency());

        cursor.close();
        return true;
    }

    public boolean updateGoal(Goal goal) {
        if (goal == null)
            return false;

        String compare[] = {goal.getGoalId()};
        Cursor cursor = mDatabase.query(GoalTable.TABLE_GOAL, GoalTable.ALL_COLUMNS,
                GoalTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() <= 0) {
            insertGoal(goal);
            cursor.close();
            return false;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+goal.getGoalId());
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(8);
        values.put(GoalTable.COLUMN_ID, goal.getGoalId());
        values.put(GoalTable.COLUMN_ACTIVITY, goal.getGoalActivity().getID());
        values.put(GoalTable.COLUMN_START_VALUE, goal.getStartValue());
        values.put(GoalTable.COLUMN_CURRENT_VALUE, goal.getCurrentValue());
        values.put(GoalTable.COLUMN_END_VALUE, goal.getEndValue());
        values.put(GoalTable.COLUMN_CONSISTENCY, goal.isConsistencyGoal() ? 1 : 0);
        values.put(GoalTable.COLUMN_GAPS, goal.doesAllowGaps() ? 1 : 0);
        values.put(GoalTable.COLUMN_MASTER, goal.isMasterQuest() ? 1 : 0);

        mDatabase.update(GoalTable.TABLE_GOAL, values, GoalTable.COLUMN_ID+"=?", new String[]{goal.getGoalId()});

        cursor.close();
        return true;
    }

    public boolean updateCurrency(Currency currency) {
        if (currency == null)
            return false;

        String compare[] = {currency.getId()};
        Cursor cursor = mDatabase.query(CurrencyTable.TABLE_CURRENCY, CurrencyTable.ALL_COLUMNS,
                CurrencyTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() <= 0) {
            insertCurrency(currency);
            cursor.close();
            return false;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+currency.getId());
            return false;
        }

        ContentValues values = new ContentValues(7);
        values.put(CurrencyTable.COLUMN_ID, currency.getId());
        values.put(CurrencyTable.COLUMN_GOLD, currency.getGold());
        values.put(CurrencyTable.COLUMN_WOOD, currency.getWood());
        values.put(CurrencyTable.COLUMN_STONE, currency.getStone());
        values.put(CurrencyTable.COLUMN_MISC1, currency.getMisc1());
        values.put(CurrencyTable.COLUMN_MISC2, currency.getMisc2());
        values.put(CurrencyTable.COLUMN_MISC3, currency.getMisc3());

        mDatabase.update(CurrencyTable.TABLE_CURRENCY, values, CurrencyTable.COLUMN_ID+"=?",
                new String[]{currency.getId()});
        cursor.close();
        return true;
    }

    public boolean updateGear(Gear gear) {
        if (gear == null)
            return false;

        String compare[] = {gear.getID()};
        Cursor cursor = mDatabase.query(GearTable.TABLE_GEAR, GearTable.ALL_COLUMNS,
                GearTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() <= 0) {
            cursor.close();
            insertGear(gear);
            return false;
        } else if (cursor.getCount() > 1) {
            System.out.println("Duplicated ID found! "+gear.getID());
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(8);
        values.put(GearTable.COLUMN_ID, gear.getID());
        values.put(GearTable.COLUMN_NAME, gear.getName());
        values.put(GearTable.COLUMN_CATEGORY, gear.getCategory());
        values.put(GearTable.COLUMN_COST, gear.getCost().getId());
        values.put(GearTable.COLUMN_BOOST, gear.getBoost().getID());
        values.put(GearTable.COLUMN_OWNED, gear.isOwned() ? 1 : 0);
        values.put(GearTable.COLUMN_EQUIPPED, gear.isEquipped() ? 1 : 0);
        values.put(GearTable.COLUMN_IMAGE, gear.getImageName());

        mDatabase.update(GearTable.TABLE_GEAR, values, GearTable.COLUMN_ID+"=?", new String[]{gear.getID()});
        updateCurrency(gear.getCost());

        cursor.close();
        return true;
    }

    public boolean updateTile(Tile tile) {
        Log.d("updateTile", "Updating Tile!");

        if (tile == null) {
            Log.d("updateTile", "Tile reference null!!");
            return false;
        }

        String compare[] = {tile.getId()};
        Cursor cursor = mDatabase.query(TileTable.TABLE_TILE, TileTable.ALL_COLUMNS,
                TileTable.COLUMN_ID + "=?", compare, null, null, null);

        if (cursor.getCount() <= 0) {
            Log.d("updateTile", "Tile doesn't exist, insert");
            insertTile(tile);
            cursor.close();
            return false;
        } else if (cursor.getCount() > 1) {
            Log.d("updateTile", "Duplicate Tile Pos");
            cursor.close();
            return false;
        }

        ContentValues values = new ContentValues(6);
        values.put(TileTable.COLUMN_ID, tile.getId());
        values.put(TileTable.COLUMN_POSITION, tile.getTileNumber());
        values.put(TileTable.COLUMN_LOCKED, tile.isLocked() ? 1 : 0);
        if (tile.getMyBuilding() != null) {
            values.put(TileTable.COLUMN_BUILDING, tile.getMyBuilding().getId());
            Log.d("updateTile", "Tile has building");
        } else {
            values.put(TileTable.COLUMN_BUILDING, "");
            Log.d("updateTile", "Tile doesn't have building");
        }
        values.put(TileTable.COLUMN_COST, tile.getTileCost().getId());
        values.put(TileTable.COLUMN_IMAGE, tile.getImageName());

        mDatabase.update(TileTable.TABLE_TILE, values, TileTable.COLUMN_ID+"=?", new String[]{tile.getId()});
        updateCurrency(tile.getTileCost());

        Tile tempTile = getTile(tile.getId());
        if (tempTile == null) {
            Log.d("updateTile", "Couldn't find tile!");
        } else {
            Log.d("updateTile", tempTile.getTileNumber()+"");
            Log.d("updateTile", tempTile.getId());
            if (tempTile.getMyBuilding() != null) {
                Log.d("updateTile", tempTile.getMyBuilding().getName());
            }
            else {
                Log.d("updateTile", "null");
            }
        }

        cursor.close();
        return true;
    }

    public boolean updateKingdom(Kingdom kingdom) {
        Log.d("updateKingdom", "Updating Kingdom!");
        if (kingdom == null) {
            Log.d("updateKingdom", "Kingdom Reference Null!!");
            return false;
        }

        Cursor cursor = null;
        cursor = mDatabase.query(KingdomTable.TABLE_KINGDOM, KingdomTable.ALL_COLUMNS,
            null, null, null, null, KingdomTable.COLUMN_TILE_POS);

        if (cursor.getCount() <= 0) {
            insertKingdom(kingdom);
            return false;
        }

        for (int i = 0; i < kingdom.getMyGrid().size(); i++) {
            Tile tempTile = kingdom.getMyGrid().get(i);
            if (tempTile != null) {
                Log.d("updateKingdom", "Temp Tile Found!");
                ContentValues values = new ContentValues(2);
                values.put(KingdomTable.COLUMN_TILE_POS, tempTile.getTileNumber());
                values.put(KingdomTable.COLUMN_TILE, tempTile.getId());

                mDatabase.update(KingdomTable.TABLE_KINGDOM, values, KingdomTable.COLUMN_TILE_POS+"=?",
                        new String[]{tempTile.getTileNumber() + ""});
                updateTile(tempTile);
            } else {
                Tile newTile = new Tile(i);
                ContentValues values = new ContentValues(2);
                values.put(KingdomTable.COLUMN_TILE_POS, newTile.getTileNumber());
                values.put(KingdomTable.COLUMN_TILE, newTile.getId());

                mDatabase.update(KingdomTable.TABLE_KINGDOM, values, KingdomTable.COLUMN_TILE_POS+"=?",
                        new String[]{newTile.getTileNumber() + ""});
                insertTile(newTile);
            }
        }

        cursor.close();
        return true;
    }
}


