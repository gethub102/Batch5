package com.wenbin.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderDemo {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("f2.txt");
             BufferedReader br = new BufferedReader(fileReader);
        ) {
           int eof = -1;
           int count = 0;
           while ((eof = br.read()) != -1) {
               System.out.println(count++);
               System.out.print((char) eof);
           }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
