public class SubstringUtil {
    
    /** 
     * 从指定的字符串中获取子字符串，避免抛出异常。
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        if (end > str.length()) {
            end = str.length();
        }
        if (start > end) {
            return "";
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(sub("Hello, World!", 7, 12)); // 输出: World
        System.out.println(sub("Hello, World!", -1, 5)); // 输出: Hello
        System.out.println(sub("Hello, World!", 7, 20)); // 输出: World!
        System.out.println(sub(null, 0, 5)); // 输出: null
        System.out.println(sub("Hello", 3, 2)); // 输出: ""
    }
}