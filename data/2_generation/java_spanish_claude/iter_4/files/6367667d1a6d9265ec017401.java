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
        StringBuilder escape = new StringBuilder(2);
        boolean inEscape = false;
        
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            
            if (inEscape) {
                escape.append(current);
                String escapedSequence = escape.toString();
                
                if (JAVA_ESCAPES.containsKey(escapedSequence)) {
                    result.append(JAVA_ESCAPES.get(escapedSequence));
                    escape.setLength(0);
                    inEscape = false;
                } else if (escape.length() == 2) {
                    // Si no es una secuencia de escape válida, mantener los caracteres originales
                    result.append(escapedSequence);
                    escape.setLength(0);
                    inEscape = false;
                }
            } else if (current == '\\') {
                inEscape = true;
                escape.append(current);
            } else {
                result.append(current);
            }
        }
        
        // Si queda algún escape sin procesar al final
        if (escape.length() > 0) {
            result.append(escape);
        }
        
        return result.toString();
    }
}