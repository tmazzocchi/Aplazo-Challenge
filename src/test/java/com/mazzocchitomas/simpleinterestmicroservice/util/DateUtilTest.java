package com.mazzocchitomas.simpleinterestmicroservice.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateUtilTest {
    @Test
    void getLocalDate_success() {
        var now = LocalDate.now();
        var date = DateUtil.getDate();
        assertEquals(now, date);
    }

    @Test
    void getLocalDate_error() {
        var yesterday = LocalDate.now().minusDays(1);
        assertNotEquals(yesterday, DateUtil.getDate());
    }

    @Test
    void getDatePlusWeek_success(){
        var now = LocalDate.now();
        var moreWeeks = 1;
        var nextWeek = DateUtil.getDatePlusWeek(now, moreWeeks);
        assertEquals(now.plusWeeks(moreWeeks), nextWeek);
    }

    @Test
    void error(){
        var now = LocalDate.now();
        var moreWeeks = 2;
        var nextWeek = DateUtil.getDatePlusWeek(now, moreWeeks);
        assertNotEquals(now, nextWeek);
    }

    @Test
    void whenNowIsNull_NullPointerExpected() {
        var moreWeeks = 2;
        final Executable executable = () -> DateUtil.getDatePlusWeek(null, moreWeeks);
        assertThrows(
                NullPointerException.class,
                executable,
                "Passing a null argument must throw a NullPointerException."
        );
    }

    @Test
    void whenMoreWeeksIsNull_NullPointerExpected() {
        var now = LocalDate.now();
        final Executable executable = () -> DateUtil.getDatePlusWeek(now, null);
        assertThrows(
                NullPointerException.class,
                executable,
                "Passing a null argument must throw a NullPointerException."
        );
    }

    @Test
    void whenAllIsNull_NullPointerExpected() {
        final Executable executable = () -> DateUtil.getDatePlusWeek(null, null);
        assertThrows(
                NullPointerException.class,
                executable,
                "Passing a null argument must throw a NullPointerException."
        );
    }
}
