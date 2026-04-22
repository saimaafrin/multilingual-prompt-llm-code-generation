/**
 * Finds the first index within a String, handling <code>null</code>. This method uses  {@link String#indexOf(String)}.
 * 
 * @param str The string to search in, may be null.
 * @param searchStr The string to search for, may be null.
 * @return The index of the first occurrence of the search string within the string, or -1 if either string is null or the search string is not found.
 */
public static int indexOf(String str, String searchStr) {
    if (str == null || searchStr == null) {
        return -1;
    }
    return str.indexOf(searchStr);
}