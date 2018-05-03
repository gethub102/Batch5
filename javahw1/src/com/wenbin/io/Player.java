package com.wenbin.io;

import java.io.Serializable;

public class Player implements Serializable {
    int coins;
    String username;
    String password;

    public Player(int coins) {
        this.coins = coins;
    }

    public Player() {
    }
}
