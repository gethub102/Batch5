package com.wenbin.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyContents {
    public static void main(String[] args) {
        try ( FileReader fileReader = new FileReader("test.txt");
              FileWriter fileWriter = new FileWriter("f2.txt", true);) {

            int eof = -1;
            while ((eof = fileReader.read()) != -1) {
                fileWriter.write(eof);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
