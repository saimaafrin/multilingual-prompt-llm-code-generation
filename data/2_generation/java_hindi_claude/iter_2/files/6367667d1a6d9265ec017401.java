import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    public static String unescapeJava(String str) {
        if (str == null) {
            return null;
        }
        
        StringBuilder result = new StringBuilder(str.length());
        Map<String, String> escapes = new HashMap<>();
        escapes.put("\\t", "\t");
        escapes.put("\\b", "\b");
        escapes.put("\\n", "\n");
        escapes.put("\\r", "\r");
        escapes.put("\\f", "\f");
        escapes.put("\\'", "'");
        escapes.put("\\\"", "\"");
        escapes.put("\\\\", "\\");
        
        boolean escaped = false;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            
            if (escaped) {
                String escape = "\\" + current;
                if (escapes.containsKey(escape)) {
                    result.append(escapes.get(escape));
                } else {
                    result.append(current);
                }
                escaped = false;
                continue;
            }
            
            if (current == '\\') {
                escaped = true;
                continue;
            }
            
            result.append(current);
        }
        
        // Handle trailing backslash if exists
        if (escaped) {
            result.append('\\');
        }
        
        return result.toString();
    }
}