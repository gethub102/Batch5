package com.wenbin.io;

import java.io.File;

public class FileExist {
    public static void main(String[] args) {
        File dir = new File("dir_for_test");
        File file = new File(dir,"test2.txt");
        System.out.println(file.exists());
    }
}
