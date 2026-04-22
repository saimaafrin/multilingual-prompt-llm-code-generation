import java.util.HashMap;
import java.util.Map;

public class StringEscapeUtils {

    private static final Map<String, String> JAVA_ESCAPES = new HashMap<>();
    
    static {
        JAVA_ESCAPES.put("\\t", "\t");
        JAVA_ESCAPES.put("\\b", "\b"); 
        JAVA_ESCAPES.put("\\n", "\n");
        JAVA_ESCAPES.put("\\r", "\r");
        JAVA_ESCAPES.put("\\f", "\f");
        JAVA_ESCAPES.put("\\\"", "\"");
        JAVA_ESCAPES.put("\\'", "'");
        JAVA_ESCAPES.put("\\\\", "\\");
    }

    /**
     * <p>Rimuove l'escape da qualsiasi letterale Java trovato nella <code>String</code>. Ad esempio, trasformerà una sequenza di <code>'\'</code> e <code>'n'</code> in un carattere di nuova linea, a meno che il <code>'\'</code> non sia preceduto da un altro <code>'\'</code>.</p>
     * @param str la <code>String</code> da desescapare, può essere null
     * @return una nuova <code>String</code> desescapata, <code>null</code> se l'input è una stringa null
     */
    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }
        
        StringBuilder result = new StringBuilder(str.length());
        StringBuilder escape = new StringBuilder(2);
        boolean inEscape = false;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (inEscape) {
                escape.append(ch);
                String escaped = escape.toString();
                
                if (JAVA_ESCAPES.containsKey(escaped)) {
                    result.append(JAVA_ESCAPES.get(escaped));
                    escape.setLength(0);
                    inEscape = false;
                } else if (escaped.length() == 2) {
                    // Invalid escape sequence
                    throw new Exception("Invalid escape sequence: " + escaped);
                }
            } else {
                if (ch == '\\') {
                    inEscape = true;
                    escape.append(ch);
                } else {
                    result.append(ch);
                }
            }
        }
        
        if (inEscape) {
            // String ends with backslash
            throw new Exception("Invalid escape sequence: string ends with backslash");
        }
        
        return result.toString();
    }
}