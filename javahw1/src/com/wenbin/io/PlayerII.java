package com.wenbin.io;

import java.io.Serializable;

public class PlayerII implements Serializable {
    int coins;
    String username;
    transient String password;

    public PlayerII(int coins, String username, String password) {
        this.coins = coins;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return this.coins + " : " + this.username + " : " + this.password;
    }

    public PlayerII(int coins) {
        this.coins = coins;
    }

    public PlayerII() {
    }
}
