public class StringUtils {

    /**
     * Finds the first index within a String, handling <code>null</code>. This method uses  {@link String#indexOf(String)}.
     * 
     * @param str the String to check, may be null
     * @param searchStr the String to search for, may be null
     * @return the index of the first occurrence of the search String, or -1 if no match or if either String is null
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(indexOf("Hello World", "World")); // Output: 6
        System.out.println(indexOf("Hello World", "Java"));  // Output: -1
        System.out.println(indexOf(null, "World"));          // Output: -1
        System.out.println(indexOf("Hello World", null));     // Output: -1
    }
}