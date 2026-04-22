public class StringUtil {
    
    /** 
     * Trim leading whitespace from the given String.
     * @param str the String to check
     * @return the trimmed String
     * @see java.lang.Character#isWhitespace
     */
    public static String trimLeadingWhitespace(String str) {
        if (str == null) {
            return null;
        }
        int start = 0;
        while (start < str.length() && Character.isWhitespace(str.charAt(start))) {
            start++;
        }
        return str.substring(start);
    }

    public static void main(String[] args) {
        String testString = "   Hello, World!";
        String trimmedString = trimLeadingWhitespace(testString);
        System.out.println("'" + trimmedString + "'"); // Output: 'Hello, World!'
    }
}