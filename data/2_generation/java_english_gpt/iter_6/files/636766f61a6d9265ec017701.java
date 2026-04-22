public class StringUtil {

    /** 
     * Finds the last index within a String, handling <code>null</code>. This method uses  {@link String#lastIndexOf(String)}. 
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(lastIndexOf("hello world", "o")); // Output: 7
        System.out.println(lastIndexOf("hello world", "l")); // Output: 9
        System.out.println(lastIndexOf("hello world", "x")); // Output: -1
        System.out.println(lastIndexOf(null, "o")); // Output: -1
        System.out.println(lastIndexOf("hello world", null)); // Output: -1
    }
}