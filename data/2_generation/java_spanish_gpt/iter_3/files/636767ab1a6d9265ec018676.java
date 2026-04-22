public class HexDigitChecker {
    
    /** 
     * ¿Es este un dígito hexadecimal?
     */
    private static boolean esHex(final char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }

    public static void main(String[] args) {
        // Test the esHex function
        System.out.println(esHex('1')); // true
        System.out.println(esHex('a')); // true
        System.out.println(esHex('G')); // false
        System.out.println(esHex('F')); // true
        System.out.println(esHex('9')); // true
        System.out.println(esHex('z')); // false
    }
}