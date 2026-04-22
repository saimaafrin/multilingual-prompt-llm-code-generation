/**
 * <p>Check if a String starts with a specified prefix (optionally case insensitive).</p>
 * @see String#startsWith(String)
 * @param str  the String to check, may be null
 * @param prefix the prefix to find, may be null
 * @param ignoreCase inidicates whether the compare should ignore case(case insensitive) or not.
 * @return <code>true</code> if the String starts with the prefix or both <code>null</code>
 */
private static boolean startsWith(final String str, final String prefix, final boolean ignoreCase) {
    if (str == null && prefix == null) {
        return true;
    }
    if (str == null || prefix == null) {
        return false;
    }
    if (ignoreCase) {
        return str.toLowerCase().startsWith(prefix.toLowerCase());
    } else {
        return str.startsWith(prefix);
    }
}