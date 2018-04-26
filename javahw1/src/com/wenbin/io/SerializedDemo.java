package com.wenbin.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializedDemo {

    public static void main(String[] args) {
        System.out.println("Play is ing ");
        System.out.println("got 1000 coins");
        Player player = new Player(1000);

//         null;

        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("player.data")))
        {
            obj.writeObject(player);
            obj.flush();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
