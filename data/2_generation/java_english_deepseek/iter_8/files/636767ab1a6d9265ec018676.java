/**
 * Checks if the given character is a valid hexadecimal digit.
 * 
 * @param c The character to check.
 * @return true if the character is a hexadecimal digit (0-9, a-f, A-F), false otherwise.
 */
private static boolean isHex(final char c) {
    return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
}