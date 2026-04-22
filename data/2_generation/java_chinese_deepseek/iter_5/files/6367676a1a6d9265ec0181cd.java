public class StringUtils {

    /**
     * 去除给定字符串的前导空白字符。
     * @param str 要检查的字符串
     * @return 去除空白后的字符串
     * @see java.lang.Character#isWhitespace
     */
    public static String trimLeadingWhitespace(String str) {
        if (str == null) {
            return null;
        }

        int length = str.length();
        int start = 0;

        // 找到第一个非空白字符的位置
        while (start < length && Character.isWhitespace(str.charAt(start))) {
            start++;
        }

        // 如果所有字符都是空白，返回空字符串
        if (start == length) {
            return "";
        }

        // 返回去除前导空白后的子字符串
        return str.substring(start);
    }

    public static void main(String[] args) {
        String input = "   Hello, World!";
        String result = trimLeadingWhitespace(input);
        System.out.println("'" + result + "'");  // 输出: 'Hello, World!'
    }
}