package net.io.kino.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateFormatter {

    private static final String STANDARD_DATE_LOG_FORMAT = "dd-MM-yyyy'T'HH:mm:ss:SSS";

    public static String formatToStandardDate(LocalDateTime date) {
        return format(date, STANDARD_DATE_LOG_FORMAT);
    }

    public static String format(LocalDateTime date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(date);
    }
}
