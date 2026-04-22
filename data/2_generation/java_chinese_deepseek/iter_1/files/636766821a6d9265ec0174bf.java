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
        System.out.println(capitalize("helloWorld")); // 输出: HelloWorld
        System.out.println(capitalize("HelloWorld")); // 输出: HelloWorld
        System.out.println(capitalize(""));           // 输出: 
        System.out.println(capitalize(null));         // 输出: null
    }
}