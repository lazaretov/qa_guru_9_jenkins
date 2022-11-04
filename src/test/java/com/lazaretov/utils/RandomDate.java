package com.lazaretov.utils;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDate {
    static LocalDate startDate = LocalDate.of(1900, 1, 1); //start date
    static long start = startDate.toEpochDay();
    static LocalDate endDate = LocalDate.now(); //end date
    static long end = endDate.toEpochDay();
    static long randomEpochDay = ThreadLocalRandom.current().nextLong(start, end);

    public static int generateDay() {
        LocalDate localDate = LocalDate.ofEpochDay(randomEpochDay);
        int dayOfMonth = localDate.getDayOfMonth();
        return dayOfMonth;
    }

    public static String generateMonth() {
        LocalDate localDate = LocalDate.ofEpochDay(randomEpochDay);
        return String.valueOf(localDate.getMonth());
    }

    public static String generateYear() {
        LocalDate localDate = LocalDate.ofEpochDay(randomEpochDay);
        return String.valueOf(localDate.getYear());
    }
}
