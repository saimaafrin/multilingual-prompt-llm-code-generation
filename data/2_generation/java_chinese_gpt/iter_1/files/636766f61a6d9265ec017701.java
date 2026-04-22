public class StringUtil {
    /**
     * 查找字符串中的最后一个索引，能够处理 <code>null</code>。此方法使用 {@link String#lastIndexOf(String)}。
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }

    public static void main(String[] args) {
        System.out.println(lastIndexOf("hello world", "o")); // Output: 7
        System.out.println(lastIndexOf("hello world", "l")); // Output: 9
        System.out.println(lastIndexOf("hello world", "x")); // Output: -1
        System.out.println(lastIndexOf(null, "o")); // Output: -1
        System.out.println(lastIndexOf("hello world", null)); // Output: -1
    }
}