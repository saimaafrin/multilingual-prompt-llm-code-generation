public class SubstringUtils {

    /**
     * Gets a substring from the specified String avoiding exceptions.
     * 
     * @param str   The original string.
     * @param start The starting index (inclusive).
     * @param end   The ending index (exclusive).
     * @return The substring, or an empty string if the indices are invalid.
     */
    public static String sub(String str, int start, int end) {
        if (str == null || start < 0 || end > str.length() || start > end) {
            return "";
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        String testStr = "Hello, World!";
        System.out.println(sub(testStr, 7, 12)); // Output: "World"
        System.out.println(sub(testStr, -1, 5));  // Output: ""
        System.out.println(sub(testStr, 5, 20));  // Output: ""
        System.out.println(sub(null, 0, 5));      // Output: ""
    }
}