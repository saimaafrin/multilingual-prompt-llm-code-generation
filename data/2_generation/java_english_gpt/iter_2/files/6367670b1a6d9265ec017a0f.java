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
        List<String> searchStrings = List.of("a", "b", "c");
        String testString = "Hello World!";
        
        boolean result = containsAnyIgnoreCase(testString, searchStrings);
        System.out.println("Contains any: " + result); // Output: Contains any: true
    }
}