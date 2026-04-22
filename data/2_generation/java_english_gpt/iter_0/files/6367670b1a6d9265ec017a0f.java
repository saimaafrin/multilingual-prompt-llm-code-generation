import java.util.List;

public class StringUtils {

    /** 
     * Case in-sensitive Checks if the String contains any character in the given set of string. 
     */
    public static boolean containsAnyIgnoreCase(String str, List<String> searchStrArray) {
        if (str == null || searchStrArray == null) {
            return false;
        }
        String lowerStr = str.toLowerCase();
        for (String searchStr : searchStrArray) {
            if (searchStr != null && lowerStr.contains(searchStr.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage
        List<String> searchStrArray = List.of("a", "b", "C");
        String str = "Hello World";
        boolean result = containsAnyIgnoreCase(str, searchStrArray);
        System.out.println(result); // Output: true
    }
}