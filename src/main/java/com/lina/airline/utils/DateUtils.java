package com.lina.airline.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public final class DateUtils {

    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Get the current date in a specified format.
     *
     * @return Current date as a String.
     */
    public static String getCurrentDate() {
        return LocalDate.now().format(DEFAULT_DATE_FORMATTER);
    }

    /**
     * Get the current date-time in a specified format.
     *
     * @return Current date-time as a String.
     */
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * Parse a date string into a LocalDate.
     *
     * @param dateStr Date in string format (yyyy-MM-dd).
     * @return LocalDate object.
     */
    public static LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, DEFAULT_DATE_FORMATTER);
    }

    /**
     * Parse a date-time string into a LocalDateTime.
     *
     * @param dateTimeStr DateTime in string format (yyyy-MM-dd HH:mm:ss).
     * @return LocalDateTime object.
     */
    public static LocalDateTime parseDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * Format a LocalDate into a string with default format (yyyy-MM-dd).
     *
     * @param date LocalDate object.
     * @return Formatted date string.
     */
    public static String formatDate(LocalDate date) {
        return date.format(DEFAULT_DATE_FORMATTER);
    }

    /**
     * Format a LocalDateTime into a string with default format (yyyy-MM-dd HH:mm:ss).
     *
     * @param dateTime LocalDateTime object.
     * @return Formatted date-time string.
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * Get the number of days between two dates.
     *
     * @param startDate Start date.
     * @param endDate End date.
     * @return Number of days between the two dates.
     */
    public static long getDaysBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * Add days to a given date.
     *
     * @param date LocalDate object.
     * @param days Number of days to add.
     * @return New LocalDate with the added days.
     */
    public static LocalDate addDays(LocalDate date, int days) {
        return date.plusDays(days);
    }

    /**
     * Subtract days from a given date.
     *
     * @param date LocalDate object.
     * @param days Number of days to subtract.
     * @return New LocalDate with the subtracted days.
     */
    public static LocalDate subtractDays(LocalDate date, int days) {
        return date.minusDays(days);
    }

    /**
     * Get the start of the day (00:00:00) for a given LocalDate.
     *
     * @param date LocalDate object.
     * @return LocalDateTime representing the start of the day.
     */
    public static LocalDateTime startOfDay(LocalDate date) {
        return date.atStartOfDay();
    }

    /**
     * Get the end of the day (23:59:59.999) for a given LocalDate.
     *
     * @param date LocalDate object.
     * @return LocalDateTime representing the end of the day.
     */
    public static LocalDateTime endOfDay(LocalDate date) {
        return date.atTime(LocalTime.MAX);
    }

    /**
     * Convert LocalDate to Instant for time-zone related operations.
     *
     * @param localDate The LocalDate to be converted.
     * @param zoneId    The ZoneId for time zone conversion.
     * @return Instant representing the given LocalDate at the start of the day in the specified time zone.
     */
    public static Instant toInstant(LocalDate localDate, ZoneId zoneId) {
        return localDate.atStartOfDay(zoneId).toInstant();
    }

    /**
     * Get the current timestamp in milliseconds (Epoch time).
     *
     * @return Current timestamp in milliseconds.
     */
    public static long getCurrentTimestamp() {
        return Instant.now().toEpochMilli();
    }

}

