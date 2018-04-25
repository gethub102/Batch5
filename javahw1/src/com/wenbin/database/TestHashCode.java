package com.wenbin.database;

public class TestHashCode {
    public static void main(String[] args) {
        TestHashCode testHashCode = new TestHashCode();
        TestHashCode testHashCode1 = new TestHashCode();
        testHashCode.equals(testHashCode1);
        if (testHashCode == testHashCode1) {

        }
    }

    @Override
    public int hashCode() {
        System.out.println("hash code");
        return super.hashCode();
    }
}
