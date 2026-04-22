public class StringUtils {

    /**
     * 在字符串中查找第一个索引，能处理 <code>null</code>。此方法使用 {@link String#indexOf(String)}。
     * 
     * @param str 要搜索的字符串，可以为 <code>null</code>
     * @param searchStr 要查找的子字符串，可以为 <code>null</code>
     * @return 子字符串在字符串中第一次出现的索引，如果字符串或子字符串为 <code>null</code>，则返回 -1
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }

    public static void main(String[] args) {
        // 测试用例
        System.out.println(indexOf("Hello World", "World")); // 输出: 6
        System.out.println(indexOf("Hello World", "Java"));  // 输出: -1
        System.out.println(indexOf(null, "World"));          // 输出: -1
        System.out.println(indexOf("Hello World", null));     // 输出: -1
    }
}