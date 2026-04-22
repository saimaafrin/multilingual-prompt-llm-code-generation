package org.apache.commons.lang3;

public class StringUtils {
    /**
     * Gets a substring from the specified String avoiding exceptions.
     * 
     * @param str  the String to get the substring from, may be null
     * @param start  the position to start from, negative means count back from end
     * @param end  the position to end at (exclusive), negative means count back from end
     * @return substring from start position to end position, null if null String input
     */
    public static String substring(final String str, int start, int end) {
        if (str == null) {
            return null;
        }

        // handle negatives
        if (end < 0) {
            end = str.length() + end; // convert to positive
        }
        if (start < 0) {
            start = str.length() + start; // convert to positive
        }

        // check bounds
        if (end > str.length()) {
            end = str.length();
        }
        if (start > end) {
            return "";
        }
        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }
}