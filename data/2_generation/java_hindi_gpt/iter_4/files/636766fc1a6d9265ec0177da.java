public class ParameterSeparatorChecker {

    /** 
     * यह निर्धारित करें कि क्या एक पैरामीटर नाम वर्तमान स्थिति पर समाप्त होता है, अर्थात्, क्या दिया गया वर्ण एक विभाजक के रूप में योग्य है। 
     */
    private static boolean isParameterSeparator(final char c) {
        // Define the valid parameter separators
        char[] separators = {',', ';', '&', '|', ' '};

        // Check if the character is a valid separator
        for (char separator : separators) {
            if (c == separator) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the isParameterSeparator method
        System.out.println(isParameterSeparator(',')); // true
        System.out.println(isParameterSeparator(';')); // true
        System.out.println(isParameterSeparator('&')); // true
        System.out.println(isParameterSeparator('|')); // true
        System.out.println(isParameterSeparator(' ')); // true
        System.out.println(isParameterSeparator('a')); // false
    }
}