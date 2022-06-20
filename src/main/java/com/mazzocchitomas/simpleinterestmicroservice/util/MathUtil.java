package com.mazzocchitomas.simpleinterestmicroservice.util;

public class MathUtil {

    public static Double getAmountPerWeek(Double amount, Double rate, Integer terms) {
        return (amount  + (amount * rate / 100)) / terms;
    }
}
