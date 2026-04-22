package org.apache.commons.lang3;

/**
 * Character utilities.
 */
public class CharUtils {

    /**
     * <p>将 Character 转换为 char，并处理 <code>null</code> 的情况。</p>
     * <pre>
     * CharUtils.toChar(null, 'X') = 'X'
     * CharUtils.toChar(' ', 'X')  = ' '
     * CharUtils.toChar('A', 'X')  = 'A'
     * </pre>
     *
     * @param ch Character to convert
     * @param defaultValue default value to return if Character is null
     * @return char value of Character or defaultValue if null
     */
    public static char toChar(final Character ch, final char defaultValue) {
        if (ch == null) {
            return defaultValue;
        }
        return ch.charValue();
    }
}