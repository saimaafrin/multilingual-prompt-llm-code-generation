public class StringUtil {
    
    /** 
     * Returns  {@code true} if the given string starts with the specified case-insensitive prefix, {@code false} otherwise.
     * @param str the String to check
     * @param prefix the prefix to look for
     * @return {@code true} if the given string starts with the specified case-insensitive prefix, {@code false} otherwise.
     * @see java.lang.String#startsWith
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        if (str == null || prefix == null) {
            return false;
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        return str.substring(0, prefix.length()).equalsIgnoreCase(prefix);
    }

    public static void main(String[] args) {
        System.out.println(startsWithIgnoreCase("Hello World", "hello")); // true
        System.out.println(startsWithIgnoreCase("Hello World", "world")); // false
        System.out.println(startsWithIgnoreCase("Hello World", "Hello")); // true
        System.out.println(startsWithIgnoreCase(null, "prefix")); // false
        System.out.println(startsWithIgnoreCase("Hello World", null)); // false
    }
}