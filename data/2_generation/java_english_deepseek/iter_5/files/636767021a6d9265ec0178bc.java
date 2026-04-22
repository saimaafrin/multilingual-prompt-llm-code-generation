/**
 * Finds the first index within a String, handling <code>null</code>. This method uses {@link String#indexOf(String)}.
 * 
 * @param str The String to check, may be null.
 * @param searchStr The String to search for, may be null.
 * @return The first index of the search String within the original String, or -1 if not found or if either String is null.
 */
public static int indexOf(String str, String searchStr) {
    if (str == null || searchStr == null) {
        return -1;
    }
    return str.indexOf(searchStr);
}