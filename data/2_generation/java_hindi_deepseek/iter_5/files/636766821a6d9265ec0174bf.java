import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    /**
     * Introspector.decapitalize का उल्टा
     */
    public static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return StringUtils.capitalize(name);
    }

    public static void main(String[] args) {
        String name = "helloWorld";
        System.out.println(capitalize(name)); // Output: HelloWorld
    }
}