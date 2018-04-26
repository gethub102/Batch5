package com.wenbin.io;

import java.io.File;
import java.io.IOException;

public class CombineDirFile {



    public static void main(String[] args) {
        File dir = new File("test");
        File file = new File(dir, "Test_dir.txt");
        try {
            boolean ret = file.createNewFile();

            // delete file
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
