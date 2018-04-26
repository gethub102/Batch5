package com.wenbin.io;

import java.io.File;
import java.io.IOException;

public class CreateFileWithPath {
    public static void main(String[] args) {
        File file = new File("/Users/wenbinli/Desktop/test_demo.txt");

        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
