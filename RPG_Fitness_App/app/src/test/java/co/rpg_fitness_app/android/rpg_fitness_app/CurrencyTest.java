package co.rpg_fitness_app.android.rpg_fitness_app;

import org.junit.Test;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Currency;

import static org.junit.Assert.*;

/**
 * Created by Tanner on 3/12/2017.
 */
public class CurrencyTest {
    @Test
    public void updateResource() throws Exception {
        Currency currencyTest = new Currency();
        //currencyTest.updateResource(1, true);
        //assertEquals(2, currencyTest.getAmount());
    }



    @Test
    public void getId() throws Exception {
        Currency currencyTest = new Currency();
        //whatistheid;
        assertEquals("test", currencyTest.getId());
    }

    @Test
    public void setId() throws Exception {
        Currency currencyTest = new Currency();
        currencyTest.setId("test");
        assertEquals("test", currencyTest.getId());
    }
}
