public class HexConverter {
    
    /** 
     * @param b एक ASCII एन्कोडेड कैरेक्टर 0-9 a-f A-F
     * @return कैरेक्टर का बाइट मान 0-16।
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
        // Example usage
        System.out.println(convertHexDigit((byte) '0')); // Output: 0
        System.out.println(convertHexDigit((byte) '9')); // Output: 9
        System.out.println(convertHexDigit((byte) 'a')); // Output: 10
        System.out.println(convertHexDigit((byte) 'f')); // Output: 15
        System.out.println(convertHexDigit((byte) 'A')); // Output: 10
        System.out.println(convertHexDigit((byte) 'F')); // Output: 15
    }
}