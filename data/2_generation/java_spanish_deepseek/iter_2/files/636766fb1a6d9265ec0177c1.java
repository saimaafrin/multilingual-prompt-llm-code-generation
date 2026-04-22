/**
 * Verifica si el carácter es una letra mayúscula alfabética ASCII de 7 bits.
 * <pre>
 * CharUtils.isAsciiAlphaUpper('a')  = false
 * CharUtils.isAsciiAlphaUpper('A')  = true
 * CharUtils.isAsciiAlphaUpper('3')  = false
 * CharUtils.isAsciiAlphaUpper('-')  = false
 * CharUtils.isAsciiAlphaUpper('\n') = false
 * CharUtils.isAsciiAlphaUpper('&copy;') = false
 * </pre>
 * @param ch  el carácter a verificar
 * @return true si está entre 65 y 90 inclusive
 */
public static boolean isAsciiAlphaUpper(final char ch) {
    return ch >= 'A' && ch <= 'Z';
}