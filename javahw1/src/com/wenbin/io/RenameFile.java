package com.wenbin.io;

import java.io.File;
import java.io.IOException;

public class RenameFile {
    public static void main(String[] args) {
        File dir = new File("dir_for_test");
        File file = new File(dir,"test.txt");
        File file1 = new File(dir,"test2.txt");
        file.renameTo(file1);

        try {
            file.createNewFile();
            file1.createNewFile();

            file.renameTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
