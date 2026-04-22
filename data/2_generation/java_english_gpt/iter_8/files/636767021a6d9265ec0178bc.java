public class StringUtils {

    /** 
     * Finds the first index within a String, handling <code>null</code>. This method uses  {@link String#indexOf(String)}. 
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }

    public static void main(String[] args) {
        System.out.println(indexOf("Hello, World!", "World")); // Output: 7
        System.out.println(indexOf("Hello, World!", "Java"));  // Output: -1
        System.out.println(indexOf(null, "World"));             // Output: -1
        System.out.println(indexOf("Hello, World!", null));    // Output: -1
    }
}