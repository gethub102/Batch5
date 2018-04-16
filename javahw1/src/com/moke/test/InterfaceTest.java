package com.moke.test;

public class InterfaceTest implements Car {
    @Override
    public void startEngine() {

    }

    public static void main(String[] args) {
        InterfaceTest interfaceTest = new InterfaceTest();
        Car car = (Car) interfaceTest;
        System.out.println(car.seatsNum);
    }


}

interface Car {
    int seatsNum = 4;
    void startEngine();
}
