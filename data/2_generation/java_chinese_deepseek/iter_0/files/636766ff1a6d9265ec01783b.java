public class StringUtils {
    /**
     * 从指定的字符串中获取子字符串，避免抛出异常。
     * @param str 原始字符串
     * @param start 起始索引（包含）
     * @param end 结束索引（不包含）
     * @return 子字符串，如果索引越界则返回空字符串
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        if (start < 0) {
            start = 0;
        }
        if (end > length) {
            end = length;
        }
        if (start >= end) {
            return "";
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        String str = "Hello, World!";
        System.out.println(sub(str, 7, 12)); // 输出 "World"
        System.out.println(sub(str, -1, 5)); // 输出 "Hello"
        System.out.println(sub(str, 7, 20)); // 输出 "World!"
        System.out.println(sub(null, 0, 5)); // 输出 ""
        System.out.println(sub(str, 10, 5)); // 输出 ""
    }
}