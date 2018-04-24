package com.wenbin.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a demo for HashMap's key should be immutable.
 * This is example is to show that if key is immutable,
 * the state of this key could be changed, then its value
 * of this key which is stored in the map could not be access
 * using map.get(key)
 *
 * The same thing is that if the synchronized block used an
 * object whose state could be changed. Then this syn block
 * could lock the object forever.
 * */

public class HashMapImmutableKey {
    public static void main(String[] args) {
        Map map = new HashMap();
        Employer employer = new Employer("RJT");

        map.put(employer, 12);
        System.out.println("employer value is " + map.get(employer));

        employer.setName("Google");
        System.out.println("employer value is " + map.get(employer));
    }
}

class Employer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer(String name) {

        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}