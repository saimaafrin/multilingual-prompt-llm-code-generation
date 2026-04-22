import java.util.HashSet;
import java.util.Set;

public class StringUtils {
    
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString;
        }
        
        // Convert charsToDelete to Set for O(1) lookup
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