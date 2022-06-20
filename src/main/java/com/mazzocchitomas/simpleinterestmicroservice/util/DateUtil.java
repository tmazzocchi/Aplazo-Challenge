package com.mazzocchitomas.simpleinterestmicroservice.util;

import java.time.LocalDate;

public class DateUtil {

    public static LocalDate getDate() {
        return LocalDate.now();
    }

    public static LocalDate getDatePlusWeek(LocalDate date, Integer week) {
        return date.plusWeeks(week);
    }
}
