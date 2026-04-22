package org.apache.commons.lang3;

/**
 * Utility class for working with characters.
 */
public class CharUtils {

    /**
     * Array of String values for characters with ASCII values 0-127.
     * Used for caching common single character String values.
     */
    private static final String[] CHAR_STRING_ARRAY = new String[128];

    /**
     * Initialize the ASCII character cache
     */
    static {
        for (int i = 0; i < CHAR_STRING_ARRAY.length; i++) {
            CHAR_STRING_ARRAY[i] = String.valueOf((char) i);
        }
    }

    /**
     * <p>Convierte el carácter en una cadena que contiene un solo carácter.</p>
     * <p>Para caracteres ASCII de 7 bits, utiliza una caché que devolverá el mismo 
     * objeto String cada vez.</p>
     * 
     * <pre>
     * CharUtils.toString(' ')  = " "
     * CharUtils.toString('A')  = "A"
     * </pre>
     *
     * @param ch  el carácter a convertir
     * @return una cadena que contiene el carácter especificado
     */
    public static String toString(final char ch) {
        if (ch < 128) {
            return CHAR_STRING_ARRAY[ch];
        }
        return String.valueOf(ch);
    }
}