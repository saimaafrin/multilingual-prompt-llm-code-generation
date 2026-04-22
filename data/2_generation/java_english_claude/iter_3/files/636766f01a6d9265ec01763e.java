import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class CharsetConverter {
    private static final Map<String, String> MIME_TO_JAVA_CHARSET = new HashMap<>();
    
    static {
        MIME_TO_JAVA_CHARSET.put("ISO-8859-1", "ISO-8859-1");
        MIME_TO_JAVA_CHARSET.put("ISO8859_1", "ISO-8859-1");
        MIME_TO_JAVA_CHARSET.put("ISO-8859-2", "ISO-8859-2"); 
        MIME_TO_JAVA_CHARSET.put("ISO8859_2", "ISO-8859-2");
        MIME_TO_JAVA_CHARSET.put("UTF-8", "UTF-8");
        MIME_TO_JAVA_CHARSET.put("UTF8", "UTF-8");
        MIME_TO_JAVA_CHARSET.put("US-ASCII", "US-ASCII");
        MIME_TO_JAVA_CHARSET.put("ASCII", "US-ASCII");
        MIME_TO_JAVA_CHARSET.put("windows-1252", "windows-1252");
        MIME_TO_JAVA_CHARSET.put("CP1252", "windows-1252");
    }

    /**
     * Translate a MIME standard character set name into the Java equivalent.
     * @param charset The MIME standard name.
     * @return The Java equivalent for this name.
     */
    private static String javaCharset(String charset) {
        if (charset == null || charset.trim().isEmpty()) {
            return Charset.defaultCharset().name();
        }
        
        String upperCharset = charset.toUpperCase();
        String javaCharset = MIME_TO_JAVA_CHARSET.get(charset);
        
        if (javaCharset != null) {
            return javaCharset;
        }
        
        // If not found in map, check if it's a valid charset
        try {
            if (Charset.isSupported(charset)) {
                return Charset.forName(charset).name();
            }
        } catch (IllegalArgumentException e) {
            // Invalid charset, return default
            return Charset.defaultCharset().name();
        }
        
        return Charset.defaultCharset().name();
    }
}