package com.wenbin.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeExternalization {
    public static void main(String[] args) {
        ObjectInputStream objectInputStream = null;
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("playerIII.data");
            objectInputStream = new ObjectInputStream(fileInputStream);
            PlayerIII playerIII = new PlayerIII();
            playerIII.readExternal(objectInputStream);

            System.out.println(playerIII);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
