public class HexDigitChecker {

    /** 
     * Is this a hex digit?
     */
    private static boolean isHex(final char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isHex('a')); // true
        System.out.println(isHex('F')); // true
        System.out.println(isHex('5')); // true
        System.out.println(isHex('g')); // false
        System.out.println(isHex('Z')); // false
    }
}