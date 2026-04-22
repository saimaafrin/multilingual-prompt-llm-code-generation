public class HexDigitConverter {

    /**
     * Converts a hexadecimal digit (ASCII character) to its corresponding byte value.
     * 
     * @param b A character encoded in ASCII from 0-9, a-f, A-F
     * @return The byte value of the character from 0 to 16.
     */
    public static byte convertHexDigit(byte b) {
        if (b >= '0' && b <= '9') {
            return (byte) (b - '0');
        } else if (b >= 'a' && b <= 'f') {
            return (byte) (b - 'a' + 10);
        } else if (b >= 'A' && b <= 'F') {
            return (byte) (b - 'A' + 10);
        } else {
            throw new IllegalArgumentException("Invalid hexadecimal digit: " + (char) b);
        }
    }

    public static void main(String[] args) {
        // Example usage
        byte digit1 = convertHexDigit((byte) 'A'); // Should return 10
        byte digit2 = convertHexDigit((byte) '7'); // Should return 7
        byte digit3 = convertHexDigit((byte) 'f'); // Should return 15

        System.out.println("A -> " + digit1);
        System.out.println("7 -> " + digit2);
        System.out.println("f -> " + digit3);
    }
}