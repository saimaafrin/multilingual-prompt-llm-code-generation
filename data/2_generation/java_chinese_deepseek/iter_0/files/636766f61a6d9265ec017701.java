public class StringUtils {

    /**
     * 查找字符串中的最后一个索引，能够处理 <code>null</code>。此方法使用 {@link String#lastIndexOf(String)}。
     *
     * @param str 要搜索的字符串，可以为 <code>null</code>
     * @param searchStr 要查找的字符串，可以为 <code>null</code>
     * @return 如果找到则返回最后一个索引，否则返回 -1。如果输入字符串为 <code>null</code>，则返回 -1。
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }

    public static void main(String[] args) {
        String str = "Hello, World!";
        String searchStr = "o";
        int index = lastIndexOf(str, searchStr);
        System.out.println("Last index of '" + searchStr + "' in '" + str + "' is: " + index);
    }
}