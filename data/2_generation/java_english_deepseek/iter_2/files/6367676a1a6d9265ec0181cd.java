public class StringUtils {

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
        
        int len = str.length();
        int start = 0;
        
        while (start < len && Character.isWhitespace(str.charAt(start))) {
            start++;
        }
        
        return str.substring(start);
    }

    public static void main(String[] args) {
        String input = "   Hello, World!";
        String result = trimLeadingWhitespace(input);
        System.out.println("Original: \"" + input + "\"");
        System.out.println("Trimmed: \"" + result + "\"");
    }
}