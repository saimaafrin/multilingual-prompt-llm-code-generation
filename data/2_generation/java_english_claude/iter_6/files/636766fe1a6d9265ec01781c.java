package org.apache.commons.lang3;

/**
 * Utility class for working with characters.
 */
public class CharUtils {

    /**
     * <p>Converts the character to a Character.</p>
     * <p>For ASCII 7 bit characters, this uses a cache that will return the same 
     * Character object each time.</p>
     * <pre>
     * CharUtils.toCharacterObject(' ')  = ' '
     * CharUtils.toCharacterObject('A')  = 'A'
     * </pre>
     * 
     * @param ch  the character to convert
     * @return a Character of the specified character
     */
    public static Character toCharacterObject(final char ch) {
        if (ch < 128) {
            return Character.valueOf(ch);
        }
        return new Character(ch);
    }
}