package com.wenbin.lambda;

public class TestOddEven {
    public static void main(String[] args) {
        OddEven ret = (i) -> {
            if (i % 2 == 0) return "Even";
            else return "Odd";
        };
        System.out.println(
            ret.checkOddEve(4)
        );
    }
}
