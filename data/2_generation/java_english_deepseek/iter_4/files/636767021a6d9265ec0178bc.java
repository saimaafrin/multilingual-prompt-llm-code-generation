public class StringUtils {

    /**
     * Finds the first index within a String, handling <code>null</code>. This method uses {@link String#indexOf(String)}.
     *
     * @param str       the String to check, may be null
     * @param searchStr the String to search for, may be null
     * @return the first index of the search String within the original String, or -1 if not found or if either String is null
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }

    public static void main(String[] args) {
        // Example usage
        String str = "Hello, World!";
        String searchStr = "World";
        int index = indexOf(str, searchStr);
        System.out.println("Index of '" + searchStr + "' in '" + str + "' is: " + index);
    }
}