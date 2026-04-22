package org.apache.commons.lang3;

public class CharUtils {
    /**
     * <p>Converte il Character in un char gestendo <code>null</code>.</p>
     * <pre>
     * CharUtils.toChar(null, 'X') = 'X'
     * CharUtils.toChar(' ', 'X')  = ' '
     * CharUtils.toChar('A', 'X')  = 'A'
     * </pre>
     *
     * @param ch  il carattere da convertire
     * @param defaultValue  il valore da utilizzare se il Character è null
     * @return il valore char del Character o il valore predefinito se null
     */
    public static char toChar(final Character ch, final char defaultValue) {
        if (ch == null) {
            return defaultValue;
        }
        return ch.charValue();
    }
}