public class StringUtil {
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
        int index = 0;
        while (index < str.length() && Character.isWhitespace(str.charAt(index))) {
            index++;
        }
        return str.substring(index);
    }

    public static void main(String[] args) {
        String testString = "   Hello, World!";
        String result = trimLeadingWhitespace(testString);
        System.out.println(result); // Output: "Hello, World!"
    }
}