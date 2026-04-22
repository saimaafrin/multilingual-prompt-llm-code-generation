public class StringUtil {
    
    /** 
     * Introspector.decapitalize का उल्टा
     */
    public static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    public static void main(String[] args) {
        // Example usage
        String testName = "example";
        String capitalized = capitalize(testName);
        System.out.println(capitalized); // Output: Example
    }
}