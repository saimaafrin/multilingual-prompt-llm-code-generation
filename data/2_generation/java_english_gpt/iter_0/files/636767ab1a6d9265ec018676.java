public class HexDigitChecker {
    
    /** 
     * Is this a hex digit?
     */
    private static boolean isHex(final char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    public static void main(String[] args) {
        // Test the isHex function
        System.out.println(isHex('A')); // true
        System.out.println(isHex('g')); // false
        System.out.println(isHex('5')); // true
        System.out.println(isHex('f')); // true
        System.out.println(isHex('Z')); // false
    }
}