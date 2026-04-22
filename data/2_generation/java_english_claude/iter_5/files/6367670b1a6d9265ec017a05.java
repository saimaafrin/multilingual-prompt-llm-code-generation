package org.apache.commons.lang3;

/**
 * Utility class for working with characters.
 */
public class CharUtils {

    /**
     * Array of String values for characters with ASCII values 0-127.
     * Used as a cache to avoid creating new String objects for common characters.
     */
    private static final String[] CHAR_STRING_CACHE = new String[128];

    // Initialize the cache with String values for ASCII characters
    static {
        for (char c = 0; c < CHAR_STRING_CACHE.length; c++) {
            CHAR_STRING_CACHE[c] = String.valueOf(c);
        }
    }

    /** 
     * <p>Converts the character to a String that contains the one character.</p>
     * <p>For ASCII 7 bit characters, this uses a cache that will return the same 
     * String object each time.</p>
     *
     * <pre>
     * CharUtils.toString(' ')  = " "
     * CharUtils.toString('A')  = "A"
     * </pre>
     *
     * @param ch  the character to convert
     * @return a String containing the one specified character
     */
    public static String toString(final char ch) {
        if (ch < 128) {
            return CHAR_STRING_CACHE[ch];
        }
        return String.valueOf(ch);
    }
}