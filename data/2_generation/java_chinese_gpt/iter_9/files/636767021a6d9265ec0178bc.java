public class StringSearch {
    
    /** 
     * 在字符串中查找第一个索引，能处理 <code>null</code>。此方法使用 {@link String#indexOf(String)}。
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }

    public static void main(String[] args) {
        // 测试代码
        System.out.println(indexOf("Hello, world!", "world")); // 输出: 7
        System.out.println(indexOf("Hello, world!", "Java"));  // 输出: -1
        System.out.println(indexOf(null, "test"));              // 输出: -1
        System.out.println(indexOf("test", null));              // 输出: -1
    }
}