package com.mazzocchitomas.simpleinterestmicroservice.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilTest {
    @Test
    void getAmountPerWeek() {
        var amount = 100.0;
        var rate = 10.0;
        var terms = 5;
        var amountPerWeek = MathUtil.getAmountPerWeek(amount, rate, terms);
        assertEquals(22.0, amountPerWeek);
    }

    @Test
    void whenAmountIsNull_NullPointerExpected() {
        var rate = 10.0;
        var terms = 5;
        final Executable executable = () -> MathUtil.getAmountPerWeek(null, rate, terms);
        assertThrows(
                NullPointerException.class,
                executable,
                "Passing a null argument must throw a NullPointerException."
        );
    }

    @Test
    void whenRateIsNull_NullPointerExpected() {
        var terms = 5;
        var amount = 500.00;
        final Executable executable = () -> MathUtil.getAmountPerWeek(amount, null, terms);
        assertThrows(
                NullPointerException.class,
                executable,
                "Passing a null argument must throw a NullPointerException."
        );
    }

    @Test
    void whenTermIsNull_NullPointerExpected() {
        var rate = 10.00;
        var amount = 500.00;
        final Executable executable = () -> MathUtil.getAmountPerWeek(amount, rate, null);
        assertThrows(
                NullPointerException.class,
                executable,
                "Passing a null argument must throw a NullPointerException."
        );
    }

    @Test
    void whenAllIsNull_NullPointerExpected() {
        final Executable executable = () -> MathUtil.getAmountPerWeek(null, null, null);
        assertThrows(
                NullPointerException.class,
                executable,
                "Passing a null argument must throw a NullPointerException."
        );
    }
}
