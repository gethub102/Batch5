package com.wenbin.rjt;

public class Shape {
    public void draw() {
        System.out.print("shap ---");
    }
}

class Square extends Shape {
    public void draw() {
        System.out.print("shap in SS---");
    }
    public void test() {
        System.out.print("shap --- test");
    }
}
