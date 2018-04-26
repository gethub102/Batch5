package com.wenbin.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class DeserializedDemo {
    public static void main(String[] args) {
        System.out.println("Deserialization ing");

        Player player;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("player.data")))
        {

            player = (Player) objectInputStream.readObject();

            System.out.println("palyer coin is " + player.coins);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
