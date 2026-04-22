public class SubstringMatcher {
    /**
     * 如果给定的字符串在指定索引处与给定的子字符串匹配，则返回 {@code true}，否则返回 {@code false}。
     * @param str 原始字符串（或 StringBuilder）
     * @param index 在原始字符串中开始匹配的索引
     * @param substring 要在给定索引处匹配的子字符串
     * @return 如果给定的字符串在指定索引处与给定的子字符串匹配，则返回 {@code true}，否则返回 {@code false}。
     */
    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        if (str == null || substring == null) {
            return false;
        }
        if (index < 0 || index + substring.length() > str.length()) {
            return false;
        }
        for (int i = 0; i < substring.length(); i++) {
            if (str.charAt(index + i) != substring.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(substringMatch("hello world", 6, "world")); // true
        System.out.println(substringMatch("hello world", 0, "hello")); // true
        System.out.println(substringMatch("hello world", 6, "hello")); // false
        System.out.println(substringMatch("hello world", 11, "world")); // false
        System.out.println(substringMatch(null, 0, "test")); // false
        System.out.println(substringMatch("test", -1, "test")); // false
    }
}