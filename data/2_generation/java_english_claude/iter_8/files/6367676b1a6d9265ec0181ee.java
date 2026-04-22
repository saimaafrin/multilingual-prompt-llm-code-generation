package org.example;

public class StringUtils {
    /**
     * Trim trailing whitespace from the given String.
     * @param str the String to check
     * @return the trimmed String
     * @see java.lang.Character#isWhitespace
     */
    public static String trimTrailingWhitespace(String str) {
        if (str == null) {
            return null;
        }
        
        int len = str.length();
        while (len > 0 && Character.isWhitespace(str.charAt(len - 1))) {
            len--;
        }
        return str.substring(0, len);
    }
}