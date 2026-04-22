package org.apache.commons.lang3;

/**
 * Utility class for working with characters.
 */
public class CharUtils {

    /**
     * Array of String values for characters 0-127 to enable caching of commonly used characters
     */
    private static final String[] CHAR_STRING_ARRAY = new String[128];

    /**
     * Initialize the character string cache
     */
    static {
        for (int i = 0; i < CHAR_STRING_ARRAY.length; i++) {
            CHAR_STRING_ARRAY[i] = String.valueOf((char) i);
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
            return CHAR_STRING_ARRAY[ch];
        }
        return String.valueOf(ch);
    }
}