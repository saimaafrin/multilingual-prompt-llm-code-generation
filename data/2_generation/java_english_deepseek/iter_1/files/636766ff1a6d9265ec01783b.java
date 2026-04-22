/**
 * Gets a substring from the specified String avoiding exceptions.
 * If the start or end indices are out of bounds, the method adjusts them to valid values.
 *
 * @param str   the input string
 * @param start the starting index (inclusive)
 * @param end   the ending index (exclusive)
 * @return the substring, or an empty string if the input string is null or the indices are invalid
 */
public static String sub(String str, int start, int end) {
    if (str == null) {
        return "";
    }
    int length = str.length();
    if (start < 0) {
        start = 0;
    }
    if (end > length) {
        end = length;
    }
    if (start >= end) {
        return "";
    }
    return str.substring(start, end);
}