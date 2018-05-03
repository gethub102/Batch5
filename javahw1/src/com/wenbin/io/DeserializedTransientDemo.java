package com.wenbin.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializedTransientDemo {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("playerII.data");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            PlayerII playerII = (PlayerII) objectInputStream.readObject();
            System.out.println("Deserialized done");
            System.out.println(playerII);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
