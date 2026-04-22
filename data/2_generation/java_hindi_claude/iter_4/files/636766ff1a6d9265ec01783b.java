public class StringUtils {
    /**
     * Gets a substring from the specified String avoiding exceptions.
     * If the start index is negative, it is treated as zero.
     * If the end index is negative, it is treated as zero.
     * If the start index is greater than end index, they are swapped.
     * If the start index is greater than length, returns empty string.
     * If the end index is greater than length, it is treated as length.
     *
     * @param str  the String to get the substring from, may be null
     * @param start  the position to start from, negative treated as zero
     * @param end  the position to end at (exclusive), negative treated as zero
     * @return substring from start position to end position,
     *         empty string if null String input
     */
    public static String substring(String str, int start, int end) {
        if (str == null) {
            return "";
        }

        // Handle negative start
        if (start < 0) {
            start = 0;
        }

        // Handle negative end
        if (end < 0) {
            end = 0;
        }

        // Swap if start is greater than end
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        // Check if start is greater than length
        if (start > str.length()) {
            return "";
        }

        // Handle end greater than length
        if (end > str.length()) {
            end = str.length();
        }

        return str.substring(start, end);
    }
}