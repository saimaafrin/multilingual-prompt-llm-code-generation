public class StringUtils {

    /**
     * Gets a String's length or <code>0</code> if the String is <code>null</code>.
     * @param str a String or <code>null</code>
     * @return String length or <code>0</code> if the String is <code>null</code>.
     * @since 2.4
     */
    public static int length(final String str) {
        return str == null ? 0 : str.length();
    }

    public static void main(String[] args) {
        // Example usage
        String testString = "Hello, World!";
        String nullString = null;

        System.out.println(length(testString)); // Output: 13
        System.out.println(length(nullString)); // Output: 0
    }
}