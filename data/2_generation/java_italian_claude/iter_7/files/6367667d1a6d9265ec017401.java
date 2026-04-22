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
        JAVA_ESCAPES.put("\\'", "'");
        JAVA_ESCAPES.put("\\\"", "\"");
        JAVA_ESCAPES.put("\\\\", "\\");
    }

    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }
        
        StringBuilder result = new StringBuilder(str.length());
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch == '\\') {
                // Check if we have enough characters left for an escape sequence
                if (i + 1 < str.length()) {
                    // Get the escape sequence (backslash + next char)
                    String escape = str.substring(i, i + 2);
                    
                    // Check if it's a valid Java escape sequence
                    if (JAVA_ESCAPES.containsKey(escape)) {
                        result.append(JAVA_ESCAPES.get(escape));
                        i++; // Skip the next character since we've handled it
                        continue;
                    }
                    
                    // Handle Unicode escapes
                    if (escape.equals("\\u") && i + 5 < str.length()) {
                        String hex = str.substring(i + 2, i + 6);
                        try {
                            int unicode = Integer.parseInt(hex, 16);
                            result.append((char) unicode);
                            i += 5; // Skip the unicode sequence
                            continue;
                        } catch (NumberFormatException e) {
                            throw new Exception("Invalid Unicode escape sequence");
                        }
                    }
                }
            }
            
            result.append(ch);
        }
        
        return result.toString();
    }
}