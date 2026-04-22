public class Utils {
    /**
     * Object to String, when null object then null else return toString();
     */
    public static String toString(Object object) {
        return object == null ? null : object.toString();
    }

    public static void main(String[] args) {
        // Test cases
        Object obj1 = null;
        Object obj2 = "Hello, World!";
        Object obj3 = 12345;

        System.out.println(toString(obj1)); // Output: null
        System.out.println(toString(obj2)); // Output: Hello, World!
        System.out.println(toString(obj3)); // Output: 12345
    }
}