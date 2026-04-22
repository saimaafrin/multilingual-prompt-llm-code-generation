package org.apache.commons.lang3;

/**
 * Utility class for working with characters
 */
public class CharUtils {

    /**
     * <p>Converts the character to a String that contains the one character.</p>
     * <p>For ASCII 7 bit characters, this uses a cache that will return the same 
     * String object each time.</p>
     * <pre>
     * CharUtils.toString(' ')  = " "
     * CharUtils.toString('A')  = "A"
     * </pre>
     * @param ch  the character to convert
     * @return a String containing the one specified character
     */
    public static String toString(final char ch) {
        if (ch < 128) {
            return String.valueOf(ch);
        }
        return new String(new char[] {ch});
    }
}