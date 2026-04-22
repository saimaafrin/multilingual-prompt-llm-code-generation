public class StringUtils {
    /**
     * Gets a substring from the specified String avoiding exceptions.
     * If the start index is negative, it is treated as zero.
     * If the end index is greater than the length of the String, the end index
     * is treated as the length of the String.
     * If start is greater than end, they are swapped.
     * If the String is null, null is returned.
     *
     * @param str  the String to get the substring from, may be null
     * @param start  the position to start from, negative treated as zero
     * @param end  the position to end at (exclusive), greater than length treated as length
     * @return substring from start position to end position,
     *  null if null String input
     */
    public static String substring(String str, int start, int end) {
        if (str == null) {
            return null;
        }

        // handle negatives
        if (start < 0) {
            start = 0;
        }

        // handle length greater than string length
        if (end > str.length()) {
            end = str.length();
        }

        // swap if start is greater than end
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        // get substring
        return str.substring(start, end);
    }
}