public class HexDigitChecker {
    
    /** 
     * ¿Es este un dígito hexadecimal?
     */
    private static boolean esHex(final char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    public static void main(String[] args) {
        // Test the esHex function
        char testChar1 = 'A';
        char testChar2 = 'g';
        char testChar3 = '5';
        
        System.out.println(esHex(testChar1)); // true
        System.out.println(esHex(testChar2)); // false
        System.out.println(esHex(testChar3)); // true
    }
}