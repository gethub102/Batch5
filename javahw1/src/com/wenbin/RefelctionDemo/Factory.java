package com.wenbin.RefelctionDemo;

class Square {}
class Circle {}
class Triangle {}

class CreateShap<T> {
    Class shap = null;

    public CreateShap(Class shap) {
        this.shap = shap;
    }

    public T createObject() {
        try {
            return (T) this.shap.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}


public class Factory {

    public static void main(String[] args) {
        CreateShap<Triangle> c = new CreateShap<>(Triangle.class);
        Triangle triangle = c.createObject();
    }

}
