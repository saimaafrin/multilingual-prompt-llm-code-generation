package org.apache.commons.lang3;

public class StringUtils {
    /**
     * <p>Check if a String starts with a specified prefix (optionally case insensitive).</p>
     * @see String#startsWith(String)
     * @param str  the String to check, may be null
     * @param prefix the prefix to find, may be null
     * @param ignoreCase indicates whether the compare should ignore case(case insensitive) or not.
     * @return <code>true</code> if the String starts with the prefix or both <code>null</code>
     */
    public static boolean startsWith(final String str, final String prefix, final boolean ignoreCase) {
        if (str == null || prefix == null) {
            return str == null && prefix == null;
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        return ignoreCase ? 
            str.regionMatches(true, 0, prefix, 0, prefix.length()) :
            str.startsWith(prefix);
    }
}