public class ObjectToStringUtil {

    /**
     * 对象转字符串，当对象为空时返回空字符串，否则返回toString();
     */
    public static String toString(Object object) {
        return object == null ? "" : object.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(toString(null)); // Output: ""
        System.out.println(toString("Hello World")); // Output: "Hello World"
        System.out.println(toString(123)); // Output: "123"
    }
}