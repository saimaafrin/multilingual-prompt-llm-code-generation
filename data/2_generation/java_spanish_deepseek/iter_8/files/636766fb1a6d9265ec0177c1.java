/**
 * Verifica si el carácter es una letra mayúscula alfabética ASCII de 7 bits.
 * 
 * @param ch el carácter a verificar
 * @return true si está entre 65 y 90 inclusive
 */
public static boolean isAsciiAlphaUpper(final char ch) {
    return ch >= 'A' && ch <= 'Z';
}