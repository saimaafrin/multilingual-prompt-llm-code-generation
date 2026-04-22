/**
 * Checks whether the character is ASCII 7 bit alphabetic upper case.
 * 
 * @param ch  the character to check
 * @return true if between 65 and 90 inclusive
 */
public static boolean isAsciiAlphaUpper(final char ch) {
    return ch >= 'A' && ch <= 'Z';
}