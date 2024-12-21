package org.example.utils;

import java.time.LocalDateTime;
import java.util.Date;

import static java.time.ZoneOffset.UTC;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

public class DateUtil {

    public static Date parseDate(final String date) {
        return Date.from(LocalDateTime
                .parse(date, ISO_DATE_TIME).toInstant(UTC));
    }
}
