package com.wenbin.io;

import java.io.File;
import java.io.IOException;

public class MakeAFile {
    public static void main(String[] args) {
        File myFile = new File("test.txt");
        try {
            boolean iscreateFile = myFile.createNewFile();
            System.out.println("is create: " + iscreateFile);
            System.out.println(myFile.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
