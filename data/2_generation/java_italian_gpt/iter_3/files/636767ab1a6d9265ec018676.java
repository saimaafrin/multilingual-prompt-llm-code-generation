public class HexChecker {
    
    /** 
     * È una cifra esadecimale?
     */
    private static boolean isHex(final char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    public static void main(String[] args) {
        // Test the isHex function
        char testChar1 = 'A';
        char testChar2 = 'g';
        char testChar3 = '5';
        
        System.out.println(testChar1 + " is hex: " + isHex(testChar1)); // true
        System.out.println(testChar2 + " is hex: " + isHex(testChar2)); // false
        System.out.println(testChar3 + " is hex: " + isHex(testChar3)); // true
    }
}