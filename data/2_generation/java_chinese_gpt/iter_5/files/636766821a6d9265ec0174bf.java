public class StringUtil {

    /**
     * Introspector.decapitalize 的反向操作
     * 
     * @param name the string to capitalize
     * @return the capitalized string
     */
    public static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    public static void main(String[] args) {
        // Test the capitalize method
        String testString = "hello";
        String capitalizedString = capitalize(testString);
        System.out.println(capitalizedString); // Output: Hello
    }
}