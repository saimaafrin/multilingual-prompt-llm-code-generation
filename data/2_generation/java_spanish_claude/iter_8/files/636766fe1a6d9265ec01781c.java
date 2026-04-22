package org.apache.commons.lang3;

/**
 * Utility class for Character operations.
 */
public class CharUtils {

    /**
     * The cache of characters. Size is limited to ASCII 7-bit characters (0-127).
     */
    private static final Character[] CHAR_CACHE = new Character[128];

    // Initialize the character cache
    static {
        for (char c = 0; c < CHAR_CACHE.length; c++) {
            CHAR_CACHE[c] = c;
        }
    }

    /**
     * <p>Convierte el carácter a un objeto "Character".</p>
     * <p>Para caracteres ASCII de 7 bits, utiliza una caché que devolverá el mismo 
     * objeto "Character" cada vez.</p>
     * 
     * <pre>
     * CharUtils.toCharacterObject(' ')  = ' '
     * CharUtils.toCharacterObject('A')  = 'A'
     * </pre>
     *
     * @param ch  el carácter a convertir
     * @return un objeto "Character" del carácter especificado
     */
    public static Character toCharacterObject(final char ch) {
        if (ch < CHAR_CACHE.length) {
            return CHAR_CACHE[ch];
        }
        return ch;
    }
}