package com.wenbin.oops;

public class OverrideChildTestException extends OverrideException {
    @Override
    public void test() throws ArithmeticException, ClassNotFoundException {
        int a = 0;
        int b = 10;
        System.out.println("ret is " + (a / b));

        Class.forName("com.wenbin.oops.OverrideChildTestException");

    }

    public static void main(String[] args) throws ClassNotFoundException {
        OverrideException overrideException = new OverrideChildTestException();
        overrideException.test();
    }
}
