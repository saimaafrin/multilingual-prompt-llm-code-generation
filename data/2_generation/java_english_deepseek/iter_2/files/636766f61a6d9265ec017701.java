public class StringUtils {

    /**
     * Finds the last index within a String, handling <code>null</code>. This method uses  {@link String#lastIndexOf(String)}.
     * 
     * @param str the String to check, may be null
     * @param searchStr the String to search for, may be null
     * @return the last index of the search String, or -1 if no match or null input
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }

    public static void main(String[] args) {
        // Example usage
        String str = "Hello, world! Hello again!";
        String searchStr = "Hello";
        int index = lastIndexOf(str, searchStr);
        System.out.println("Last index of \"" + searchStr + "\": " + index); // Output: Last index of "Hello": 14
    }
}