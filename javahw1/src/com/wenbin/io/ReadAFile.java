package com.wenbin.io;

import java.io.FileReader;
import java.io.IOException;

public class ReadAFile {


    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("f2.txt")) {
            int eof = -1;
            while ((eof = fileReader.read()) != -1) {
                System.out.print((char)eof);
            }
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }
}
