package com.cst2335.exercises.utils;

public class PriceCalculator {

    static private final Double MARKUP_FACTOR = 1.5;
    /**
     * @return the final price of the product to show in the UI.
     * @param basePrice the base price of the [Product].
     */
    public Double finalPrice(Double basePrice) {
        if (basePrice >= 0.0) {
            return basePrice * MARKUP_FACTOR;
        }
        else
            return 0.0;
    }

}
