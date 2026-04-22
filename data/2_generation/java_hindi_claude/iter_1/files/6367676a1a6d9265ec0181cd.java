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
        
        while ((start < len) && Character.isWhitespace(str.charAt(start))) {
            start++;
        }
        
        return (start > 0) ? str.substring(start) : str;
    }
}