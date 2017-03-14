package co.rpg_fitness_app.android.rpg_fitness_app;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tanner on 3/12/2017.
 */
public class CurrencyTest {
    @Test
    public void updateResource() throws Exception {
        Currency currencyTest = new Currency(1, "wood");
        currencyTest.updateResource(1, true);
        assertEquals(2, currencyTest.getAmount());

    }

    @Test
    public void getAmount() throws Exception {
        Currency currencyTest = new Currency(1, "wood");
        assertEquals(1, currencyTest.getAmount());
    }

    @Test
    public void setAmount() throws Exception {
        Currency currencyTest = new Currency(1, "wood");
        currencyTest.setAmount(2);
        assertEquals(2, currencyTest.getAmount());
    }

    @Test
    public void getResource() throws Exception {
        Currency currencyTest = new Currency(1, "wood");
        assertEquals("wood", currencyTest.getResource());
    }

    @Test
    public void setResource() throws Exception {
        Currency currencyTest = new Currency(1, "wood");
        currencyTest.setResource("test");
        assertEquals("test", currencyTest.getResource());
    }

    @Test
    public void getId() throws Exception {
        Currency currencyTest = new Currency(1, "wood");
        whatistheid;
        assertEquals("test", currencyTest.getId());
    }

    @Test
    public void setId() throws Exception {
        Currency currencyTest = new Currency(1, "wood");
        currencyTest.setId("test");
        assertEquals("test", currencyTest.getId());
}