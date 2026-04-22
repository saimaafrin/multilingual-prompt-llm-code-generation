package org.apache.commons.lang3;

public class CharUtils {
    
    private static final Character[] CHAR_ARRAY = new Character[128];
    
    static {
        for (char c = 0; c < CHAR_ARRAY.length; c++) {
            CHAR_ARRAY[c] = new Character(c);
        }
    }
    
    public static Character toCharacterObject(char ch) {
        if (ch < CHAR_ARRAY.length) {
            return CHAR_ARRAY[ch];
        }
        return new Character(ch);
    }
}