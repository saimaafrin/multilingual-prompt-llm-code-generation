import java.beans.Introspector;
import java.lang.reflect.Method;

public class Capitalizer {

    /** 
     * Reverse of Introspector.decapitalize
     */
    public static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        if (Character.isUpperCase(name.charAt(0))) {
            return name; // Already capitalized
        }
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    public static void main(String[] args) {
        // Test the capitalize method
        System.out.println(capitalize("example")); // Output: Example
        System.out.println(capitalize("Example")); // Output: Example
        System.out.println(capitalize("")); // Output: 
        System.out.println(capitalize(null)); // Output: null
    }
}