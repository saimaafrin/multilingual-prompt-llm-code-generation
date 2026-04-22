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
     * Traduce un nombre de conjunto de caracteres estándar MIME al equivalente en Java.
     * @param charset El nombre estándar MIME.
     * @return El equivalente en Java para este nombre.
     */
    private static String javaCharset(String charset) {
        if (charset == null || charset.trim().isEmpty()) {
            return Charset.defaultCharset().name();
        }
        
        String normalizedCharset = charset.trim().toUpperCase();
        String javaCharset = MIME_TO_JAVA_CHARSET.get(normalizedCharset);
        
        if (javaCharset != null) {
            return javaCharset;
        }
        
        try {
            // Verify if the charset is supported by Java
            if (Charset.isSupported(charset)) {
                return Charset.forName(charset).name();
            }
        } catch (IllegalArgumentException e) {
            // If charset is not supported, return default
        }
        
        return Charset.defaultCharset().name();
    }
}