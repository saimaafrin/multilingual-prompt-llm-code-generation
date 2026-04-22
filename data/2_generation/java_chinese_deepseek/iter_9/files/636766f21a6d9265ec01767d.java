public class ObjectToStringUtil {
    /**
     * 对象转字符串，当对象为空时返回空字符串，否则返回toString();
     */
    public static String toString(Object object) {
        return object == null ? "" : object.toString();
    }

    public static void main(String[] args) {
        // 测试用例
        System.out.println(toString(null)); // 输出: ""
        System.out.println(toString("Hello, World!")); // 输出: Hello, World!
        System.out.println(toString(123)); // 输出: 123
    }
}