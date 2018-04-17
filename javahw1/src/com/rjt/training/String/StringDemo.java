package com.rjt.training.String;

import java.util.*;

public class StringDemo {
    public static void main(String[] args) {
        StringDemo demo = new StringDemo();
        demo.convertString();

        PositiveString positiveString = new PositiveString();

        String postr = "good";
        System.out.println(postr + " positive string => " + positiveString.positiveString(postr));
    }

    public void convertString() {
        String str = convertStringHandler();
        System.out.println("convert String to => " + str);
    }

    public String convertStringHandler() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("input a string");
            String originalString = scanner.nextLine();
            convertUsage();

            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    System.out.println("input another string for adding");
                    String additionalString = scanner.nextLine();
                    return originalString + additionalString;
                case 2:
                    return replaceOddWithTag(originalString, "#");
                case 3:
                    return removeDuplicates(originalString);
                case 4:
                    return oddToUperCase(originalString);
                default:
                    System.out.println("\n\ninput is not proper, read the usage below: ");
                    convertUsage();

            }
        }
        catch (InputMismatchException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return "";
    }

    private String oddToUperCase(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (i % 2 == 0) {
               sb.append(String.valueOf(c).toUpperCase());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();

    }

    private String removeDuplicates(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!set.contains(c)) {
                list.add(c);
                set.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    private String replaceOddWithTag(String str, String tag) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (tag == null || tag.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                sb.append(tag);
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public void convertUsage() {
        System.out.println("convert string options: ");
        System.out.println("\tcommand 1 is to Add the String to itself");
        System.out.println("\tcommand 2 is to Replace odd positions with #");
        System.out.println("\tcommand 3 is to Remove duplicate characters in the String");
        System.out.println("\tcommand 4 is to Change odd characters to upper case");
        System.out.print("\tYour option is => ");
    }
}
