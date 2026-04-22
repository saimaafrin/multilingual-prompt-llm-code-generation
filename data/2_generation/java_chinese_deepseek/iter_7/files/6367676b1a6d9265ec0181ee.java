public class StringUtils {

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

        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }

        return str.substring(0, length);
    }

    public static void main(String[] args) {
        String testString = "Hello World!   ";
        System.out.println("Original: '" + testString + "'");
        System.out.println("Trimmed: '" + trimTrailingWhitespace(testString) + "'");
    }
}