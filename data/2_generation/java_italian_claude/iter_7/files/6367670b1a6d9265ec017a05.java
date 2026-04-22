package org.apache.commons.lang3;

/**
 * Utility class for character operations.
 */
public class CharUtils {

    /**
     * Array cache of commonly used characters converted to String.
     * We cache the first 128 ASCII characters since they're most common.
     */
    private static final String[] CHAR_STRING_CACHE = new String[128];

    // Initialize the cache
    static {
        for (int i = 0; i < CHAR_STRING_CACHE.length; i++) {
            CHAR_STRING_CACHE[i] = String.valueOf((char) i);
        }
    }

    /**
     * <p>Converte il carattere in una Stringa che contiene il singolo carattere.</p>
     * <p>Per i caratteri ASCII a 7 bit, utilizza una cache che restituirà lo stesso oggetto String ogni volta.</p>
     * <pre>
     * CharUtils.toString(' ')  = " "
     * CharUtils.toString('A')  = "A"
     * </pre>
     * 
     * @param ch il carattere da convertire
     * @return una Stringa contenente il carattere specificato
     */
    public static String toString(final char ch) {
        if (ch < CHAR_STRING_CACHE.length) {
            return CHAR_STRING_CACHE[ch];
        }
        return String.valueOf(ch);
    }
}