package com.wenbin.io;

import java.io.File;

public class MakeDirectory {
    public static void main(String[] args) {
        File myDir = new File("dir_for_test");
        boolean iscreated = myDir.mkdir();
        System.out.println(iscreated? "is created" : "not created");
    }
}
