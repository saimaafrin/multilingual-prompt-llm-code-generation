/**
 * Gets a substring from the specified String avoiding exceptions.
 * If the start or end indices are out of bounds, the method adjusts them to the nearest valid index.
 *
 * @param str   The input string.
 * @param start The starting index (inclusive).
 * @param end   The ending index (exclusive).
 * @return The substring, or an empty string if the input string is null or the indices are invalid.
 */
public static String sub(String str, int start, int end) {
    if (str == null) {
        return "";
    }
    
    int length = str.length();
    
    // Adjust start index if it's out of bounds
    if (start < 0) {
        start = 0;
    } else if (start > length) {
        start = length;
    }
    
    // Adjust end index if it's out of bounds
    if (end < 0) {
        end = 0;
    } else if (end > length) {
        end = length;
    }
    
    // Ensure start is not greater than end
    if (start > end) {
        start = end;
    }
    
    return str.substring(start, end);
}