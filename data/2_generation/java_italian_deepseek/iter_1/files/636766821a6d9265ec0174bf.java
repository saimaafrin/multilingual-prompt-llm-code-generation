import java.beans.Introspector;

public class StringUtils {

    /**
     * Inverso di Introspector.decapitalize
     */
    public static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public static void main(String[] args) {
        String testName = "helloWorld";
        System.out.println(capitalize(testName));  // Output: HelloWorld
    }
}