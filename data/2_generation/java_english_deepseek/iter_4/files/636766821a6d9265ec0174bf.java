import java.beans.Introspector;

public class StringUtils {
    /**
     * Reverse of Introspector.decapitalize
     */
    public static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(capitalize("hello")); // Output: Hello
        System.out.println(capitalize("world")); // Output: World
        System.out.println(capitalize(""));      // Output: 
        System.out.println(capitalize(null));    // Output: null
    }
}