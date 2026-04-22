import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    /**
     * Introspector.decapitalize 的反向操作
     */
    public static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return StringUtils.capitalize(name);
    }

    public static void main(String[] args) {
        System.out.println(capitalize("hello")); // Output: Hello
        System.out.println(capitalize("world")); // Output: World
        System.out.println(capitalize(""));      // Output: 
        System.out.println(capitalize(null));    // Output: null
    }
}