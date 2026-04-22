/**
 * Utility method for {@link #createNumber(String)}.
 * Returns <code>true</code> if s is <code>null</code> or if it consists entirely of zeros.
 * @param s the String to check
 * @return true if it is all zeros or <code>null</code>
 */
private static boolean isAllZeros(String s) {
    if (s == null) {
        return true;
    }
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != '0') {
            return false;
        }
    }
    return true;
}