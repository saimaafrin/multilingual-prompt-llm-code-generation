public class StringUtils {
    /**
     * 如果给定的字符串以指定的不区分大小写的前缀开头，则返回 {@code true}，否则返回 {@code false}。
     * @param str 要检查的字符串
     * @param prefix 要查找的前缀
     * @return 如果给定的字符串以指定的不区分大小写的前缀开头，则返回 {@code true}，否则返回 {@code false}。
     * @see java.lang.String#startsWith
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        if (str == null || prefix == null) {
            return false;
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        return str.regionMatches(true, 0, prefix, 0, prefix.length());
    }

    public static void main(String[] args) {
        System.out.println(startsWithIgnoreCase("HelloWorld", "hello")); // true
        System.out.println(startsWithIgnoreCase("HelloWorld", "world")); // false
        System.out.println(startsWithIgnoreCase("HelloWorld", "HELLO")); // true
        System.out.println(startsWithIgnoreCase("HelloWorld", null)); // false
        System.out.println(startsWithIgnoreCase(null, "hello")); // false
    }
}