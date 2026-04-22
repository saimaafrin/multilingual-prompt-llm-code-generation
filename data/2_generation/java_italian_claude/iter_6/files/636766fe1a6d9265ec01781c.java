package org.apache.commons.lang3;

/**
 * Utility class for Character operations
 */
public class CharUtils {

    /**
     * <p>Converte il carattere in un oggetto Character.</p>
     * <p>Per i caratteri ASCII a 7 bit, utilizza una cache che restituirà lo stesso oggetto Character ogni volta.</p>
     * <pre>
     * CharUtils.toCharacterObject(' ')  = ' '
     * CharUtils.toCharacterObject('A')  = 'A'
     * </pre>
     * @param ch  il carattere da convertire
     * @return un oggetto Character del carattere specificato
     */
    public static Character toCharacterObject(final char ch) {
        if (ch < 128) {
            return Character.valueOf(ch);
        }
        return new Character(ch);
    }
}