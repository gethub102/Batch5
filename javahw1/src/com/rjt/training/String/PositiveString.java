package com.rjt.training.String;

public class PositiveString {
    public boolean positiveString(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        str = str.toLowerCase();
        char prev = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char behind = str.charAt(i);
            if ((prev - behind) > 0) {
                return false;
            }
            prev = behind;
        }
        return false;
    }
}
