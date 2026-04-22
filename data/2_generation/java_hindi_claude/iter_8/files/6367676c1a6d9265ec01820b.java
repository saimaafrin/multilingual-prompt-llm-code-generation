import java.util.HashSet;
import java.util.Set;

public class StringUtils {
    
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString;
        }
        
        Set<Character> deleteChars = new HashSet<>();
        for (char c : charsToDelete.toCharArray()) {
            deleteChars.add(c);
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (!deleteChars.contains(c)) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}