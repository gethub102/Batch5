package com.rjt.training;

public class Manager01 {
    public static void main(String[] args) {
        int i = 0;
        int j = 1;
        int k = 0;
//        int k = divide(j, i);
        try {
//            k  = divide(j, i);
            k = 0;
        }
        catch (ArithmeticException e) {
            e.printStackTrace();
        }
        finally {
            try {
                k = divide(j, i);
                System.out.println("Finally");
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("End");
    }
    private static int divide (int i, int j) {
        return i / j;
    }
}
