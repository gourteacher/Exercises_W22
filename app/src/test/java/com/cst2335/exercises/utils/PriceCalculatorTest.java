package com.cst2335.exercises.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PriceCalculatorTest {

    private PriceCalculator priceCalculator;

    @Before
    public void setUp() throws Exception {
        priceCalculator = new PriceCalculator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void finalPrice_Equals() {

        Double expectedProductPrice = 1.5;
        Double  finalProductPrice = priceCalculator.finalPrice( 1.0);

        assertEquals(
                expectedProductPrice,
                finalProductPrice,
                0.001);         // for number precision
    }

    @Test
    public void finalPrice_NotEquals() {

        Double expectedProductPrice = 1.5;
        Double  finalProductPrice = priceCalculator.finalPrice( 0.0);

        assertNotEquals(
                expectedProductPrice,
                finalProductPrice);
    }


    @Test
    public void finalPrice_NotNegative() {

        Double expectedProductPrice = 0.0;
        Double  finalProductPrice = priceCalculator.finalPrice( -1.0);

        assertTrue(
                expectedProductPrice.equals(finalProductPrice) );

    }
}
