package com.rjt.training.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.TimeZone;

public class DateCalculation {
    public static void main(String[] args) {
        DateCalculation dateCalculation = new DateCalculation();
//        dateCalculation.durationForDateAndToday();

//        dateCalculation.durationForTwoDates();
//        dateCalculation.getExpireDate();
        dateCalculation.testTimeZoneFunction();
    }

    private void testTimeZoneFunction() {
        printTimeWithZoneId("America/New_York");
        printTimeWithZoneId("Europe/London");
        printTimeWithZoneId("Asia/Tokyo");
        printTimeWithZoneId("US/Pacific");
        printTimeWithZoneId("Africa/Cairo");
        printTimeWithZoneId("Australia/Sydney");
    }

    public LocalDate getExpireDate() {
        System.out.println(" product purchase date ");
        LocalDate purchaseDate = getADate();
        System.out.println("warranted period ");
        Period warrantedPeriod = getWarrantedPeriod();

        LocalDate expireDate = purchaseDate.plus(warrantedPeriod);
        System.out.println(" expire on the date of " + expireDate);
        return expireDate;
    }

    public void durationForDateAndToday() {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("year => ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("month => ");
            int month = Integer.parseInt(scanner.nextLine());
            System.out.print("day => ");
            int day = Integer.parseInt(scanner.nextLine());

            LocalDate anotherDate = LocalDate.of(year, month, day);
            System.out.println(anotherDate);

            Period duration = Period.between(anotherDate, today);
            int years = duration.getYears();
            int months = duration.getMonths();
            int days = duration.getDays();
            System.out.println("diff years => " + years + " diff months => " + months + " diff days => " + days);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void durationForTwoDates() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("year => ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("month => ");
            int month = Integer.parseInt(scanner.nextLine());
            System.out.print("day => ");
            int day = Integer.parseInt(scanner.nextLine());

            LocalDate anotherDate = LocalDate.of(year, month, day);
            System.out.println(anotherDate);

            System.out.print("yearII => ");
            int yearII = Integer.parseInt(scanner.nextLine());
            System.out.print("monthII => ");
            int monthII = Integer.parseInt(scanner.nextLine());
            System.out.print("dayII => ");
            int dayII = Integer.parseInt(scanner.nextLine());


            LocalDate anotherDateII = LocalDate.of(yearII, monthII, dayII);
            System.out.println(anotherDateII);

            if (anotherDate.isAfter(anotherDateII)) {
                LocalDate tmp = anotherDate;
                anotherDate = anotherDateII;
                anotherDateII = tmp;
            }
            Period duration = Period.between(anotherDate, anotherDateII);
            int years = duration.getYears();
            int months = duration.getMonths();
            int days = duration.getDays();
            System.out.println("diff years => " + years + " diff months => " + months + " diff days => " + days);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public int durationForToday(LocalDate date) {
        LocalDate today = LocalDate.now();
        System.out.println(today);


        if (today.isAfter(date)) {
            LocalDate tmp = today;
            today = date;
            date = tmp;
        }
        Period duration = Period.between(today, date);
        int years = duration.getYears();
        int months = duration.getMonths();
        int days = duration.getDays();
        System.out.println(" years => " + years + "  months => " + months + "  days => " + days);
        return years;

    }


    public LocalDate getADate() {
        LocalDate date = null;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("year => ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("month => ");
            int month = Integer.parseInt(scanner.nextLine());
            System.out.print("day => ");
            int day = Integer.parseInt(scanner.nextLine());

            LocalDate anotherDate = LocalDate.of(year, month, day);
            System.out.println(anotherDate);
            date = anotherDate;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return date;
    }

    private Period getWarrantedPeriod() {
        Period period = null;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Warranted year => ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Warranted month => ");
            int month = Integer.parseInt(scanner.nextLine());

            period = Period.ofYears(year).plusMonths(month);
            System.out.println(period);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return period;
    }

    public void printTimeWithZoneId(String timeZoneId) {
        LocalDateTime localNow = LocalDateTime.now(TimeZone.getTimeZone(timeZoneId).toZoneId());
        System.out.println(localNow);
        // Prints current time of given zone without zone information : 2016-04-28T15:41:17.611
        ZonedDateTime zoneNow = ZonedDateTime.now(TimeZone.getTimeZone(timeZoneId).toZoneId());
        System.out.println(zoneNow);
        // Prints current time of given zone with zone information : 2016-04-28T15:41:17.627+02:00[Europe/Madrid]
    }

}
