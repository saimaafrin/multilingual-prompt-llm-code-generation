public class HexDecoder {
    /**
     * Helper to decode half of a hexadecimal number from a string.
     * @param c The ASCII character of the hexadecimal number to decode. Must be in the range {@code [0-9a-fA-F]}.
     * @return The hexadecimal value represented in the ASCII character given, or {@link Character#MAX_VALUE} if the character is invalid.
     */
    public static char decodeHexChar(char c) {
        if (c >= '0' && c <= '9') {
            return (char)(c - '0');
        }
        if (c >= 'a' && c <= 'f') {
            return (char)(c - 'a' + 10);
        }
        if (c >= 'A' && c <= 'F') {
            return (char)(c - 'A' + 10);
        }
        return Character.MAX_VALUE;
    }
}