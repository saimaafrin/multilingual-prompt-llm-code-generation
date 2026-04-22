package org.apache.commons.lang3;

public class StringUtils {
    /**
     * Finds the last index within a String, handling <code>null</code>. This method uses {@link String#lastIndexOf(String)}.
     *
     * @param str       the String to check, may be null
     * @param searchStr the String to find, may be null
     * @return the last index of the search String,
     *         -1 if no match or <code>null</code> string input
     */
    public static int lastIndexOf(final String str, final String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }
}