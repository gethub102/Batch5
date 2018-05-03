package com.wenbin.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializedTransient {
    public static void main(String[] args) {

        try (FileOutputStream fileOutputStream = new FileOutputStream("playerII.data");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);)
        {
            objectOutputStream.writeObject(new PlayerII(2000, "Wenbin", "passwd"));
            objectOutputStream.flush();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
