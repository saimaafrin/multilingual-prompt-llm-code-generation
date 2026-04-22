public class StringUtil {
    /**
     * 去除给定字符串末尾的空白字符。
     * @param str 要检查的字符串
     * @return 去除空白字符后的字符串
     * @see java.lang.Character#isWhitespace
     */
    public static String trimTrailingWhitespace(String str) {
        if (str == null) {
            return null;
        }
        int end = str.length();
        while (end > 0 && Character.isWhitespace(str.charAt(end - 1))) {
            end--;
        }
        return str.substring(0, end);
    }

    public static void main(String[] args) {
        String testString = "Hello, World!   ";
        String trimmedString = trimTrailingWhitespace(testString);
        System.out.println("'" + trimmedString + "'"); // Output: 'Hello, World!'
    }
}