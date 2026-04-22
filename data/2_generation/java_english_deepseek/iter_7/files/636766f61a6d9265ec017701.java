/**
 * Finds the last index within a String, handling <code>null</code>. This method uses  {@link String#lastIndexOf(String)}.
 * 
 * @param str The string to search in, may be null.
 * @param searchStr The string to search for, may be null.
 * @return The last index of the search string within the given string, or -1 if not found or if either string is null.
 */
public static int lastIndexOf(String str, String searchStr) {
    if (str == null || searchStr == null) {
        return -1;
    }
    return str.lastIndexOf(searchStr);
}