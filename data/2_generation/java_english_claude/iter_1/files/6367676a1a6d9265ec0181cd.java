package org.example;

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
        int st = 0;
        
        while ((st < len) && Character.isWhitespace(str.charAt(st))) {
            st++;
        }
        
        return (st > 0) ? str.substring(st) : str;
    }
}