package org.apache.commons.lang3;

public class StringUtils {
    /**
     * <p>Check if a String ends with a specified suffix (optionally case insensitive).</p>
     * @see String#endsWith(String)
     * @param str  the String to check, may be null
     * @param suffix the suffix to find, may be null
     * @param ignoreCase inidicates whether the compare should ignore case(case insensitive) or not.
     * @return <code>true</code> if the String starts with the prefix or both <code>null</code>
     */
    private static boolean endsWith(final String str, final String suffix, final boolean ignoreCase) {
        if (str == null || suffix == null) {
            return str == null && suffix == null;
        }
        if (suffix.length() > str.length()) {
            return false;
        }
        
        if (ignoreCase) {
            String strLower = str.toLowerCase();
            String suffixLower = suffix.toLowerCase();
            return strLower.endsWith(suffixLower);
        } else {
            return str.endsWith(suffix);
        }
    }
}