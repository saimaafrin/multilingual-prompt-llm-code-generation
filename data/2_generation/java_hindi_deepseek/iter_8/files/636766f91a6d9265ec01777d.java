public class HexDigitConverter {
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
        byte digit1 = convertHexDigit((byte) '5'); // Example: '5' -> 5
        byte digit2 = convertHexDigit((byte) 'a'); // Example: 'a' -> 10
        byte digit3 = convertHexDigit((byte) 'F'); // Example: 'F' -> 15

        System.out.println("'5' -> " + digit1);
        System.out.println("'a' -> " + digit2);
        System.out.println("'F' -> " + digit3);
    }
}