public class ObjectToStringUtil {

    /**
     * 对象转字符串，当对象为空时返回空字符串，否则返回toString();
     */
    public static String toString(Object object) {
        return object == null ? "" : object.toString();
    }

    public static void main(String[] args) {
        // 测试用例
        Object obj1 = null;
        Object obj2 = "Hello, World!";
        Object obj3 = 12345;

        System.out.println(toString(obj1)); // 输出: ""
        System.out.println(toString(obj2)); // 输出: "Hello, World!"
        System.out.println(toString(obj3)); // 输出: "12345"
    }
}