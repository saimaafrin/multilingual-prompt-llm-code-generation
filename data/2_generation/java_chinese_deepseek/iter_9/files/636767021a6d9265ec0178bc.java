public class StringUtils {

    /**
     * 在字符串中查找第一个索引，能处理 <code>null</code>。此方法使用 {@link String#indexOf(String)}。
     *
     * @param str 要搜索的字符串，可以为 <code>null</code>
     * @param searchStr 要查找的字符串，可以为 <code>null</code>
     * @return 如果找到则返回第一个匹配的索引，否则返回 -1。如果输入字符串为 <code>null</code>，则返回 -1。
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }

    public static void main(String[] args) {
        System.out.println(indexOf("Hello World", "World")); // 输出: 6
        System.out.println(indexOf("Hello World", "Java"));  // 输出: -1
        System.out.println(indexOf(null, "World"));         // 输出: -1
        System.out.println(indexOf("Hello World", null));    // 输出: -1
    }
}