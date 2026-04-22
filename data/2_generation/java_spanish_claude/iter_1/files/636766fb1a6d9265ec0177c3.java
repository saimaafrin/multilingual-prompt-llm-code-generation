package org.apache.commons.lang3;

public class CharUtils {
    /**
     * <p>Verifica si el carácter es ASCII de 7 bits.</p>
     * <pre>
     * CharUtils.isAscii('a')  = true
     * CharUtils.isAscii('A')  = true 
     * CharUtils.isAscii('3')  = true
     * CharUtils.isAscii('-')  = true
     * CharUtils.isAscii('\n') = true
     * CharUtils.isAscii('&copy;') = false
     * </pre>
     * @param ch el carácter a verificar
     * @return true si es menor que 128
     */
    public static boolean isAscii(final char ch) {
        return ch < 128;
    }
}