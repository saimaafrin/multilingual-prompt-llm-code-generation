import java.beans.Introspector;

public class StringUtils {

    /**
     * Inverso di Introspector.decapitalize
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
        String testString = "helloWorld";
        System.out.println(capitalize(testString)); // Output: HelloWorld
    }
}