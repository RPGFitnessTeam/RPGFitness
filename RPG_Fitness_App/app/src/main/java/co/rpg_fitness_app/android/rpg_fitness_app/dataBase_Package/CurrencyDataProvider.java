package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;

/**
 * Created by Austin on 3/14/2017.
 */

public class CurrencyDataProvider {
    public static ArrayList<Currency> currencyList;
    public static Map<String, Currency> currencyMap;

    static {
        currencyList = new ArrayList<Currency>();
        currencyMap = new HashMap<String, Currency>();

        // Below here is where we will add all items to the database
    }

    //TODO Currency needs getID method
    private static void addCurrency(Currency currency) {
        currencyList.add(currency);
        //currencyMap.put(currency.getID(), currency);
    }
}

