import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class CharsetConverter {
    
    private static final Map<String, String> MIME_TO_JAVA_CHARSET = new HashMap<>();
    
    static {
        MIME_TO_JAVA_CHARSET.put("ISO-8859-1", "ISO8859_1");
        MIME_TO_JAVA_CHARSET.put("ISO-8859-2", "ISO8859_2");
        MIME_TO_JAVA_CHARSET.put("ISO-8859-3", "ISO8859_3");
        MIME_TO_JAVA_CHARSET.put("ISO-8859-4", "ISO8859_4");
        MIME_TO_JAVA_CHARSET.put("ISO-8859-5", "ISO8859_5");
        MIME_TO_JAVA_CHARSET.put("ISO-8859-6", "ISO8859_6");
        MIME_TO_JAVA_CHARSET.put("ISO-8859-7", "ISO8859_7");
        MIME_TO_JAVA_CHARSET.put("ISO-8859-8", "ISO8859_8");
        MIME_TO_JAVA_CHARSET.put("ISO-8859-9", "ISO8859_9");
        MIME_TO_JAVA_CHARSET.put("UTF-8", "UTF8");
        MIME_TO_JAVA_CHARSET.put("US-ASCII", "ASCII");
        MIME_TO_JAVA_CHARSET.put("WINDOWS-1250", "Cp1250");
        MIME_TO_JAVA_CHARSET.put("WINDOWS-1251", "Cp1251");
        MIME_TO_JAVA_CHARSET.put("WINDOWS-1252", "Cp1252");
        MIME_TO_JAVA_CHARSET.put("WINDOWS-1253", "Cp1253");
        MIME_TO_JAVA_CHARSET.put("WINDOWS-1254", "Cp1254");
        MIME_TO_JAVA_CHARSET.put("WINDOWS-1257", "Cp1257");
        MIME_TO_JAVA_CHARSET.put("KOI8-R", "KOI8_R");
        MIME_TO_JAVA_CHARSET.put("UTF-16BE", "UnicodeBigUnmarked");
        MIME_TO_JAVA_CHARSET.put("UTF-16LE", "UnicodeLittleUnmarked");
        MIME_TO_JAVA_CHARSET.put("UTF-16", "Unicode");
    }

    private static String javaCharset(String charset) {
        if (charset == null) {
            return null;
        }
        
        String upperCharset = charset.toUpperCase();
        String javaCharset = MIME_TO_JAVA_CHARSET.get(upperCharset);
        
        if (javaCharset != null) {
            return javaCharset;
        }
        
        // If no mapping found, try if the charset is directly supported by Java
        try {
            if (Charset.isSupported(charset)) {
                return charset;
            }
        } catch (IllegalArgumentException e) {
            // Invalid charset name
        }
        
        // Return the original charset if no mapping found and not directly supported
        return charset;
    }
}