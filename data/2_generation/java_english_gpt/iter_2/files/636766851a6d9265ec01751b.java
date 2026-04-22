public class HexDecoder {

    /** 
     * Helper to decode half of a hexadecimal number from a string.
     * @param c The ASCII character of the hexadecimal number to decode. Must be in the range  {@code [0-9a-fA-F]}.
     * @return The hexadecimal value represented in the ASCII character given, or  {@link Character#MAX_VALUE} if the character is invalid.
     */
    private static char decodeHexNibble(final char c) {
        if (c >= '0' && c <= '9') {
            return (char) (c - '0');
        } else if (c >= 'a' && c <= 'f') {
            return (char) (c - 'a' + 10);
        } else if (c >= 'A' && c <= 'F') {
            return (char) (c - 'A' + 10);
        } else {
            return Character.MAX_VALUE; // Invalid character
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(decodeHexNibble('0')); // Output: 0
        System.out.println(decodeHexNibble('9')); // Output: 9
        System.out.println(decodeHexNibble('a')); // Output: 10
        System.out.println(decodeHexNibble('f')); // Output: 15
        System.out.println(decodeHexNibble('A')); // Output: 10
        System.out.println(decodeHexNibble('F')); // Output: 15
        System.out.println(decodeHexNibble('g')); // Output: 65535 (Character.MAX_VALUE)
    }
}