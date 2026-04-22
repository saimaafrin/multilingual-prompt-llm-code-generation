public class StringUtils {
    /**
     * Gets a substring from the specified String avoiding exceptions.
     * If the start index is negative, it is treated as zero.
     * If the end index is larger than the length of the String, it is treated as the length of the String.
     * If start is larger than end, they are swapped.
     *
     * @param str  the String to get the substring from, may be null
     * @param start  the position to start from, negative treated as zero
     * @param end  the position to end at (exclusive), negative treated as zero
     * @return substring from start position to end position,
     *  null if null String input
     */
    public static String substring(final String str, int start, int end) {
        if (str == null) {
            return null;
        }

        // handle negatives
        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }

        // check length next
        if (end > str.length()) {
            end = str.length();
        }

        // if start is greater than end, swap them
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        // if start is greater than length, return ""
        if (start > str.length()) {
            return "";
        }

        return str.substring(start, end);
    }
}