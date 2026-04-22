public class HexConverter {
    /**
     * Converts a hexadecimal character (0-9, a-f, A-F) to its corresponding byte value.
     *
     * @param b A character encoded in ASCII from 0-9, a-f, or A-F
     * @return The byte value of the character from 0 to 15
     */
    public static byte convertHexDigit(byte b) {
        if (b >= '0' && b <= '9') {
            return (byte) (b - '0');
        } else if (b >= 'a' && b <= 'f') {
            return (byte) (b - 'a' + 10);
        } else if (b >= 'A' && b <= 'F') {
            return (byte) (b - 'A' + 10);
        } else {
            throw new IllegalArgumentException("Invalid hexadecimal character: " + (char) b);
        }
    }

    public static void main(String[] args) {
        // Example usage
        byte hexChar1 = 'A';
        byte hexChar2 = '7';
        byte hexChar3 = 'f';

        System.out.println(convertHexDigit(hexChar1)); // Output: 10
        System.out.println(convertHexDigit(hexChar2)); // Output: 7
        System.out.println(convertHexDigit(hexChar3)); // Output: 15
    }
}