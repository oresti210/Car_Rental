package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    public static long calculateDaysBetween(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end);
    }
    public static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
