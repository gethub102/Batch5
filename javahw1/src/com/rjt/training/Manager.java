package com.rjt.training;

public class Manager {
    public static void main(String[] args) {
        System.out.println("start");
        try {
            int i = Integer.parseInt(args[0]);
            int j = i / (i - 5);
            System.out.println(j);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled");
            e.printStackTrace();
        } catch (NumberFormatException ne) {
            System.out.println("NumberFormatException happened");
            ne.printStackTrace();
        }
        catch (ArithmeticException ae) {
            System.out.println("ArithmeticException happened and handle");
            ae.printStackTrace();
        }
        finally {
            System.out.println("This happens after try and catch always");
        }

        System.out.println("This happens after try and catch always!!!");
    }
}
