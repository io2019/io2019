package pl.jtat.logger.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class DateFormatter {

    private static final String STANDARD_DATE_LOG_FORMAT = "dd-MM-yyyy'T'HH:mm:ss:SSS";

    public static String getCurrentTime() {
        return formatToStandardDate(Calendar.getInstance().getTime());
    }

    public static String formatToStandardDate(Date date) {
        return format(date, STANDARD_DATE_LOG_FORMAT);
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.getDefault());
        return formatter.format(date);
    }
}
