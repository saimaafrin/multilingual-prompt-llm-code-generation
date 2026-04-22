public class HexDecoder {
    /**
     * Helper to decode half of a hexadecimal number from a string.
     * @param c The ASCII character of the hexadecimal number to decode. Must be in the range {@code [0-9a-fA-F]}.
     * @return The hexadecimal value represented in the ASCII character given, or {@link Character#MAX_VALUE} if the character is invalid.
     */
    private static char decodeHexNibble(final char c) {
        // For 0-9
        if (c >= '0' && c <= '9') {
            return (char)(c - '0');
        }
        
        // For a-f
        if (c >= 'a' && c <= 'f') {
            return (char)(c - 'a' + 10);
        }
        
        // For A-F
        if (c >= 'A' && c <= 'F') {
            return (char)(c - 'A' + 10);
        }
        
        return Character.MAX_VALUE;
    }
}