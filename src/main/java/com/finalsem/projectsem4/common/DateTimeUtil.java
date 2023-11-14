package com.finalsem.projectsem4.common;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateTimeUtil {

    private DateTimeUtil() {
        throw new IllegalStateException("Utility Class");
    }

    public static String format(LocalDateTime localDateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

    public static String defaultFormat(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_FORMAT);
        return localDateTime.format(formatter);
    }

    public static String isoDateTimeFormat(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public static Date parseIsoDateTime(String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
        return Date.from(localDateTime.atZone(ZoneId.of("UTC")).toInstant());
    }

    public static Date tryParseIsoDateTime(String date) {
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
            return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static LocalDateTime tryParseIsoLocalDateTime(String date) {
        try {
            return LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static Date convertString2Date(String formatDate, String value) {
        try {
            return new SimpleDateFormat(formatDate).parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String convertDate2String(String formatDate, Date value) {
        try {
            return new SimpleDateFormat(formatDate).format(value);
        } catch (Exception e) {
            return null;
        }
    }

    public static String dateFormatter(String formatDate, String value) {
        try {
            Date dateString = convertString2Date(formatDate, value);
            return convertDate2String(ddMMyyyy, dateString);
        } catch (Exception e) {
            return null;
        }
    }

    public static String timeStamp2String(String pattern, Long value) {
        try {
            Date date = new Date(value);
            Format format = new SimpleDateFormat(pattern);
            return format.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static final String DEFAULT_FORMAT = "yyyyMMddHHmmss";
    public static final String ORACLE_FORMAT = "yyyy-MM-dd HH:mm:ss.s";
    public static final String OBVAM_FORMAT = "yyyy-MM-dd";
    public static final String ddMMyyyy = "dd/MM/yyyy";
    public static final String ddMMyyyyHyphen = "dd-MM-yyyy";
    public static final String ddMMyyyyHHmmss = "dd/MM/yyyy hh:mm:ss";
    public static final String ddMMyyyyKKmmss = "dd/MM/yyyy kk:mm:ss";
    public static final String shortddMMyyyyhh = "ddMMyyyyhh";
    public static final String shortyyyyMMdd = "yyyyMMdd";
    public static final String shortyyMMdd = "yyMMdd";
}