public class SubstringExample {
    /**
     * 从指定的字符串中获取子字符串，避免抛出异常。
     * @param str 原始字符串
     * @param start 子字符串的起始位置（包含）
     * @param end 子字符串的结束位置（不包含）
     * @return 子字符串，如果输入无效则返回空字符串
     */
    public static String sub(String str, int start, int end) {
        if (str == null || start < 0 || end > str.length() || start > end) {
            return "";
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        String testStr = "Hello, World!";
        System.out.println(sub(testStr, 7, 12)); // 输出 "World"
        System.out.println(sub(testStr, -1, 5));  // 输出 ""
        System.out.println(sub(testStr, 5, 20));  // 输出 ""
        System.out.println(sub(null, 0, 5));      // 输出 ""
    }
}