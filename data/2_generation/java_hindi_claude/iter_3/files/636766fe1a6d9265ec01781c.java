package org.apache.commons.lang3;

public class CharUtils {
    
    private static final Character[] CHAR_CACHE = new Character[128];
    
    static {
        for (char c = 0; c < CHAR_CACHE.length; c++) {
            CHAR_CACHE[c] = new Character(c);
        }
    }
    
    public static Character toCharacterObject(char ch) {
        if (ch < CHAR_CACHE.length) {
            return CHAR_CACHE[ch];
        }
        return new Character(ch);
    }
}