package org.apache.commons.lang3;

public class CharUtils {
    
    private static final String[] CHAR_STRING_CACHE = new String[128];
    
    static {
        for (char c = 0; c < CHAR_STRING_CACHE.length; c++) {
            CHAR_STRING_CACHE[c] = String.valueOf(c);
        }
    }
    
    public static String toString(char ch) {
        if (ch < 128) {
            return CHAR_STRING_CACHE[ch];
        }
        return String.valueOf(ch);
    }
}