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
        System.out.println(indexOf("hello world", "world")); // Output: 6
        System.out.println(indexOf("hello world", "java"));  // Output: -1
        System.out.println(indexOf(null, "test"));           // Output: -1
        System.out.println(indexOf("test", null));           // Output: -1
    }
}