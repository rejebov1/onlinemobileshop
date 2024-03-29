package org.myproject.service.formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.myproject.service.serviceUtil.StringUtil.isNotEmpty;

public class LocalDateFormatter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate format(String value) {
        LocalDate result = null;
        if (isNotEmpty(value)) {
            result = LocalDate.parse(value, FORMATTER);
        }

        return result;
    }
}
