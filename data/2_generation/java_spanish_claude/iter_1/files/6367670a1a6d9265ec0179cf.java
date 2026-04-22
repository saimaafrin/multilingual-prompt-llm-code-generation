package org.apache.commons.lang3;

/**
 * Utility class for Character operations.
 */
public class CharUtils {

    /**
     * <p>Convierte el "Character" a un "char" manejando <code>null</code>.</p>
     * 
     * <pre>
     * CharUtils.toChar(null, 'X') = 'X'
     * CharUtils.toChar(' ', 'X')  = ' '
     * CharUtils.toChar('A', 'X')  = 'A'
     * </pre>
     *
     * @param ch  el carácter a convertir
     * @param defaultValue  el valor a usar si el carácter es null
     * @return el valor "char" del carácter o el valor por defecto si es null
     */
    public static char toChar(final Character ch, final char defaultValue) {
        if (ch == null) {
            return defaultValue;
        }
        return ch.charValue();
    }
}