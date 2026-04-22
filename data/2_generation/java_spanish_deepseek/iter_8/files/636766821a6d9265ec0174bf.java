import java.util.*;

public class StringUtils {
    /**
     * Inverso de Introspector.decapitalize
     * Capitalizes the first letter of the given string.
     *
     * @param name the string to capitalize
     * @return the capitalized string
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