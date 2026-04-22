import java.beans.Introspector;

public class StringUtils {

    /**
     * Reverse of Introspector.decapitalize
     * 
     * @param name The string to capitalize
     * @return The capitalized string
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