import java.util.HashSet;
import java.util.Set;

public class StringUtils {
    /**
     * Delete any character in a given String.
     * @param inString the original String
     * @param charsToDelete a set of characters to delete.E.g. "az\n" will delete 'a's, 'z's and new lines.
     * @return the resulting String
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString;
        }
        
        // Convert charsToDelete to a Set for O(1) lookup
        Set<Character> deleteSet = new HashSet<>();
        for (char c : charsToDelete.toCharArray()) {
            deleteSet.add(c);
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (!deleteSet.contains(c)) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}