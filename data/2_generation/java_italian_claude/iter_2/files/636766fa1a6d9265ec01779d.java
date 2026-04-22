package org.apache.commons.lang3;

/**
 * Utility class for working with characters.
 */
public class CharUtils {

    /**
     * <p>Controlla se il carattere è un controllo ASCII a 7 bit.</p>
     * <pre>
     * CharUtils.isAsciiControl('a')  = false
     * CharUtils.isAsciiControl('A')  = false
     * CharUtils.isAsciiControl('3')  = false
     * CharUtils.isAsciiControl('-')  = false
     * CharUtils.isAsciiControl('\n') = true
     * CharUtils.isAsciiControl('&copy;') = false
     * </pre>
     * @param ch il carattere da controllare
     * @return true se è minore di 32 o uguale a 127
     */
    public static boolean isAsciiControl(final char ch) {
        return ch < 32 || ch == 127;
    }
}