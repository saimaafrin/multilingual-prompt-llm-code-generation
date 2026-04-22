public class HexChecker {
    
    /** 
     * क्या यह एक हेक्स अंक है?
     */
    private static boolean isHex(final char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }

    public static void main(String[] args) {
        // Test the isHex function
        char testChar1 = 'a';
        char testChar2 = 'G';
        char testChar3 = '5';

        System.out.println(testChar1 + " is hex: " + isHex(testChar1)); // true
        System.out.println(testChar2 + " is hex: " + isHex(testChar2)); // false
        System.out.println(testChar3 + " is hex: " + isHex(testChar3)); // true
    }
}