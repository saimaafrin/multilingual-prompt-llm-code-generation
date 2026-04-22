public class StringUtils {

    /**
     * 查找字符串中的最后一个索引，能够处理 <code>null</code>。此方法使用 {@link String#lastIndexOf(String)}。
     *
     * @param str 要搜索的字符串，可以为 <code>null</code>
     * @param searchStr 要查找的子字符串，可以为 <code>null</code>
     * @return 子字符串最后一次出现的索引，如果未找到或输入为 <code>null</code>，则返回 -1
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }

    public static void main(String[] args) {
        // 测试示例
        String str = "Hello, world! Hello, Java!";
        String searchStr = "Hello";
        int index = lastIndexOf(str, searchStr);
        System.out.println("Last index of \"" + searchStr + "\": " + index); // 输出: Last index of "Hello": 13
    }
}