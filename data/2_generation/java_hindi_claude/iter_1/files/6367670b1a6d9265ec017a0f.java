import java.util.HashSet;
import java.util.Set;

public class StringUtils {
    /**
     * Case in-sensitive Checks if the String contains any character in the given set of string.
     * @param str The string to check
     * @param searchChars The set of characters to search for
     * @return true if str contains any character in searchChars, false otherwise
     */
    public static boolean containsAny(String str, String searchChars) {
        if (str == null || str.isEmpty() || searchChars == null || searchChars.isEmpty()) {
            return false;
        }
        
        // Convert both strings to lowercase for case-insensitive comparison
        String lowerStr = str.toLowerCase();
        String lowerSearchChars = searchChars.toLowerCase();
        
        // Convert search chars to a Set for O(1) lookup
        Set<Character> searchSet = new HashSet<>();
        for (char c : lowerSearchChars.toCharArray()) {
            searchSet.add(c);
        }
        
        // Check each character in the input string
        for (char c : lowerStr.toCharArray()) {
            if (searchSet.contains(c)) {
                return true;
            }
        }
        
        return false;
    }
}