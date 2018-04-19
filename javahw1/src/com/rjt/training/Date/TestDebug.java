package com.rjt.training.Date;

public class TestDebug {
    public static void main(String[] args) {
        DateCalculation dateCalculation = new DateCalculation();
//        dateCalculation.testGetWarrantedPeriod();
        dateCalculation.getExpireDate();
        // implementations are below:
    }
}

/*
* public LocalDate getExpireDate() {
        System.out.println(" product purchase date ");
        LocalDate purchaseDate = getADate();
        System.out.println("warranted period ");
        Period warrantedPeriod = getWarrantedPeriod();

        LocalDate expireDate = purchaseDate.plus(warrantedPeriod);
        System.out.println(" expire on the date of " + expireDate);
        return expireDate;
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
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Warranted year => ");
            int year = Integer.parseInt(sc.nextLine());
            System.out.print("Warranted month => ");
            int month = Integer.parseInt(sc.nextLine());

            period = Period.ofYears(year).plusMonths(month);
            System.out.println(" year " + period.getYears() + " month: " + period.getMonths());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return period;
    }


    public void testGetWarrantedPeriod() {
        System.out.println(" product purchase date ");

        LocalDate purchaseDate = null;
        System.out.println("warranted period ");

        Period warrantedPeriod = null;
        try (Scanner sc = new Scanner(System.in)) {


            System.out.print("year => ");
            int year = Integer.parseInt(sc.nextLine());
            System.out.print("month => ");
            int month = Integer.parseInt(sc.nextLine());
            System.out.print("day => ");
            int day = Integer.parseInt(sc.nextLine());

            purchaseDate = LocalDate.of(year, month, day);

            System.out.print("Warranted year => ");
            year = Integer.parseInt(sc.nextLine());
            System.out.print("Warranted month => ");
            month = Integer.parseInt(sc.nextLine());

            warrantedPeriod = Period.ofYears(year).plusMonths(month);
            System.out.println(" year " + warrantedPeriod.getYears() + " month: " + warrantedPeriod.getMonths());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        LocalDate expireDate = purchaseDate.plus(warrantedPeriod);
        System.out.println(" expire on the date of " + expireDate);
    }


*
*
* */