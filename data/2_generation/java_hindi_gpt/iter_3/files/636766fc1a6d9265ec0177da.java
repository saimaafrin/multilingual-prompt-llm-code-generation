public class ParameterSeparatorChecker {

    /** 
     * यह निर्धारित करें कि क्या एक पैरामीटर नाम वर्तमान स्थिति पर समाप्त होता है, अर्थात्, क्या दिया गया वर्ण एक विभाजक के रूप में योग्य है। 
     */
    private static boolean isParameterSeparator(final char c) {
        // Define the valid parameter separators
        return c == ',' || c == ';' || c == '&' || c == '|';
    }

    public static void main(String[] args) {
        // Test the isParameterSeparator method
        char testChar1 = ',';
        char testChar2 = 'a';
        
        System.out.println(isParameterSeparator(testChar1)); // true
        System.out.println(isParameterSeparator(testChar2)); // false
    }
}