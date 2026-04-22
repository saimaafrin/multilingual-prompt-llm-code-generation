import java.util.List;

public class StringUtils {

    /**
     * Case in-sensitive Checks if the String contains any character in the given set of string.
     * @param str The string to check
     * @param searchStrArray List of strings to search for
     * @return true if str contains any of the search strings (case insensitive), false otherwise
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
}