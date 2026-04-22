package org.apache.commons.lang3;

/**
 * Utility class for character operations.
 */
public class CharUtils {

    /**
     * Array per la cache dei caratteri ASCII.
     * Cache per caratteri da 0 a 127.
     */
    private static final String[] CHAR_STRING_CACHE = new String[128];

    // Inizializza la cache
    static {
        for (char c = 0; c < CHAR_STRING_CACHE.length; c++) {
            CHAR_STRING_CACHE[c] = String.valueOf(c);
        }
    }

    /** 
     * <p>Converte il carattere in una Stringa che contiene il singolo carattere.</p> 
     * <p>Per i caratteri ASCII a 7 bit, utilizza una cache che restituirà lo stesso oggetto String ogni volta.</p> 
     * <pre>
     * CharUtils.toString(' ')  = " "
     * CharUtils.toString('A')  = "A"
     * </pre>
     * @param ch  il carattere da convertire
     * @return una Stringa contenente il carattere specificato
     */
    public static String toString(final char ch) {
        if (ch < CHAR_STRING_CACHE.length) {
            return CHAR_STRING_CACHE[ch];
        }
        return String.valueOf(ch);
    }
}