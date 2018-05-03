package com.wenbin.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriterReader {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        FileWriter fileWriter = null;
        try {
            file.createNewFile();
            fileWriter = new FileWriter(file);
            fileWriter.write("Welcome ...");
            fileWriter.flush(); // only on the write


            FileReader fileReader = new FileReader(file);
            int eof = -1;
            while ((eof = fileReader.read()) != -1) {
                System.out.print((char)eof);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
