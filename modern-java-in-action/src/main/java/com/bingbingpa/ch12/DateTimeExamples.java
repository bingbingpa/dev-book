package com.bingbingpa.ch12;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class DateTimeExamples {

    private static final ThreadLocal<DateFormat> formatters = new ThreadLocal<DateFormat>() {

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("dd-MMM-yyyy");
        }
    };

    public static void main(String... args) {
        useOldDate();
        useLocalDate();
        useTemporalAdjuster();
        useDateFormatter();
    }

    private static void useOldDate() {
        Date date = new Date(114, 2, 18);
        System.out.println(date);

        System.out.println(formatters.get().format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.FEBRUARY, 18);
        System.out.println(calendar);
    }

    private static void useLocalDate() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        System.out.println(date);

        int y = date.get(ChronoField.YEAR);
        int m = date.get(ChronoField.MONTH_OF_YEAR);
        int d = date.get(ChronoField.DAY_OF_MONTH);

        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println(time);

        LocalDateTime dt1 = LocalDateTime.of(2014,Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println("dt1 ===== " + dt1);

        LocalDate date1 = dt1.toLocalDate();
        System.out.println("date1===== " +date1);
        LocalTime time1 = dt1.toLocalTime();
        System.out.println("time1 ===== " +time1);

        Instant instant = Instant.ofEpochSecond(44 * 365 * 86400);
        System.out.println("instant =============== " + instant);
        Instant now = Instant.now();
        System.out.println("instant.now =============== " + now);

        Duration d1 = Duration.between(LocalTime.of(13, 14, 10), time);
        Duration d2 = Duration.between(instant, now);
        System.out.println("d1 ============== " + d1.getSeconds());
        System.out.println("d2======================" + d2.getSeconds());

        Duration threeMinutes = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println("threeMinutes============== " +threeMinutes);

    }

    private static void useTemporalAdjuster() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        date = date.with(nextOrSame(DayOfWeek.SUNDAY));
        System.out.println("nextOrSame==================== " + date);
        date = date.with(lastDayOfMonth());
        System.out.println("lastDayOfMonth ================= " + date);

        date = date.with(new NextWorkingDay());
        System.out.println("NextWorkingDay =============== "+ date);
        date = date.with(nextOrSame(DayOfWeek.FRIDAY));
        System.out.println("NextWorkingDay nextOrSame =============== "+ date);
        date = date.with(new NextWorkingDay());
        System.out.println("NextWorkingDay date =============== "+ date);

        date = date.with(nextOrSame(DayOfWeek.FRIDAY));
        System.out.println(date);
        date = date.with(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            }
            if (dow == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
        System.out.println("NextWorkingDay lambda ============= " + date);
    }

    private static class NextWorkingDay implements TemporalAdjuster {
        @Override
        public Temporal adjustInto(Temporal temporal) {
            TemporalField temporalField;
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            }
            if (dow == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }

            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        }
    }

    private static void useDateFormatter() {
        LocalDate date = LocalDate.of(2020, 5, 18);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.KOREAN);

        System.out.println("ISO_LOCAL_DATE ================== " +date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("formatter ================ " + date.format(formatter));
        System.out.println("italianFormatter===================== " +date.format(italianFormatter));

        DateTimeFormatter complexFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(", ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.KOREAN);

        System.out.println("complexFormatter ========================= " + date.format(complexFormatter));
    }

}
