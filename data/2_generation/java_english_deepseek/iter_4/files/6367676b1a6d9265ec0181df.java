public class StringUtils {

    /**
     * Returns {@code true} if the given string starts with the specified case-insensitive prefix, {@code false} otherwise.
     * @param str the String to check
     * @param prefix the prefix to look for
     * @return {@code true} if the given string starts with the specified case-insensitive prefix, {@code false} otherwise.
     * @see java.lang.String#startsWith
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        if (str == null || prefix == null) {
            return false;
        }
        if (str.length() < prefix.length()) {
            return false;
        }
        return str.regionMatches(true, 0, prefix, 0, prefix.length());
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(startsWithIgnoreCase("HelloWorld", "hello")); // true
        System.out.println(startsWithIgnoreCase("HelloWorld", "world")); // false
        System.out.println(startsWithIgnoreCase("HelloWorld", "HELLO")); // true
        System.out.println(startsWithIgnoreCase("HelloWorld", null)); // false
        System.out.println(startsWithIgnoreCase(null, "hello")); // false
    }
}