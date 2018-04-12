package com.rjt.training;

public class Manager03 {
    public static void main(String[] args) {
        int i = 0;
        int j = 1;
        int k = 0;
        try {
            try {
                k = divide(1, 0 );
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
            System.out.println("inner normally");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("outer finally");
        }
        System.out.println("End");
    }
    private static int divide (int i, int j) {
        return i / j;
    }
}
