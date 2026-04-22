package org.apache.commons.lang3;

/**
 * Utility class for character operations.
 */
public class CharUtils {

    /**
     * Array contenente le stringhe per i caratteri ASCII a 7 bit (0-127).
     */
    private static final String[] CHAR_STRING_ARRAY = new String[128];

    /**
     * Inizializza la cache delle stringhe per i caratteri ASCII.
     */
    static {
        for (char c = 0; c < CHAR_STRING_ARRAY.length; c++) {
            CHAR_STRING_ARRAY[c] = String.valueOf(c);
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
        if (ch < 128) {
            return CHAR_STRING_ARRAY[ch];
        }
        return String.valueOf(ch);
    }
}