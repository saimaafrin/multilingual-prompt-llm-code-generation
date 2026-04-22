public class StringUtils {
    /**
     * Converts an object to its string representation. If the object is null, returns null.
     *
     * @param object the object to convert to a string
     * @return the string representation of the object, or null if the object is null
     */
    public static String toString(Object object) {
        return object == null ? null : object.toString();
    }

    public static void main(String[] args) {
        // Example usage
        Object obj1 = null;
        Object obj2 = "Hello, World!";
        
        System.out.println(toString(obj1)); // Output: null
        System.out.println(toString(obj2)); // Output: Hello, World!
    }
}