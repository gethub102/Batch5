package com.wenbin.io;

import java.io.Serializable;

public class LongCredential implements Serializable {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LongCredential(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public LongCredential() {
    }

    @Override
    public String toString() {
        return "UserName: " + this.name + "Password: " + this.password;
    }
}
