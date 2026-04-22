import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    private static final Map<String, String> JAVA_ESCAPES;
    
    static {
        JAVA_ESCAPES = new HashMap<>();
        JAVA_ESCAPES.put("\\t", "\t");
        JAVA_ESCAPES.put("\\b", "\b");
        JAVA_ESCAPES.put("\\n", "\n");
        JAVA_ESCAPES.put("\\r", "\r");
        JAVA_ESCAPES.put("\\f", "\f");
        JAVA_ESCAPES.put("\\\\", "\\");
        JAVA_ESCAPES.put("\\'", "'");
        JAVA_ESCAPES.put("\\\"", "\"");
    }

    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }
        
        StringBuilder result = new StringBuilder(str.length());
        
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            
            if (currentChar == '\\' && i + 1 < str.length()) {
                // Check for escaped sequences
                String escape = str.substring(i, Math.min(i + 2, str.length()));
                
                // Handle unicode escapes
                if (escape.startsWith("\\u") && i + 5 < str.length()) {
                    String hex = str.substring(i + 2, i + 6);
                    try {
                        result.append((char) Integer.parseInt(hex, 16));
                        i += 5;
                        continue;
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid unicode escape sequence");
                    }
                }
                
                // Handle octal escapes
                if (Character.isDigit(str.charAt(i + 1))) {
                    int end = Math.min(i + 4, str.length());
                    int j = i + 1;
                    while (j < end && Character.isDigit(str.charAt(j))) {
                        j++;
                    }
                    String octal = str.substring(i + 1, j);
                    try {
                        result.append((char) Integer.parseInt(octal, 8));
                        i = j - 1;
                        continue;
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid octal escape sequence");
                    }
                }
                
                // Handle common escape sequences
                String replacement = JAVA_ESCAPES.get(escape);
                if (replacement != null) {
                    result.append(replacement);
                    i++;
                    continue;
                }
            }
            
            result.append(currentChar);
        }
        
        return result.toString();
    }
}