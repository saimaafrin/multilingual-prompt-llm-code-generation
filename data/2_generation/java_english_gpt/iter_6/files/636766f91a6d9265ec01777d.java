public class HexConverter {
    
    /** 
     * @param b An ASCII encoded character 0-9 a-f A-F
     * @return The byte value of the character 0-16.
     */
    public static byte convertHexDigit(byte b) {
        if (b >= '0' && b <= '9') {
            return (byte) (b - '0');
        } else if (b >= 'a' && b <= 'f') {
            return (byte) (b - 'a' + 10);
        } else if (b >= 'A' && b <= 'F') {
            return (byte) (b - 'A' + 10);
        } else {
            throw new IllegalArgumentException("Invalid hex digit: " + (char) b);
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(convertHexDigit((byte) '0')); // 0
        System.out.println(convertHexDigit((byte) '9')); // 9
        System.out.println(convertHexDigit((byte) 'a')); // 10
        System.out.println(convertHexDigit((byte) 'f')); // 15
        System.out.println(convertHexDigit((byte) 'A')); // 10
        System.out.println(convertHexDigit((byte) 'F')); // 15
    }
}