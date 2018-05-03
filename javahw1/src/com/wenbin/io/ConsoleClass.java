package com.wenbin.io;

import java.io.Console;

public class ConsoleClass {
    public static void main(String[] args) {
        Console console = System.console();
        System.out.println("Enter username");
        String username = console.readLine();
        System.out.println("name is " + username);

        System.out.println("Enter password");
        char[] password = console.readPassword();
        String strpasswd = String.valueOf(password);

        System.out.println("password is " + strpasswd);
    }
}
