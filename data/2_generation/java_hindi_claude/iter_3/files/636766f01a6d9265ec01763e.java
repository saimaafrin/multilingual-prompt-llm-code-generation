import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class CharsetTranslator {
    
    /**
     * Translate a MIME standard character set name into the Java equivalent.
     * @param charset The MIME standard name.
     * @return The Java equivalent for this name.
     */
    public static String translateCharset(String charset) {
        if (charset == null || charset.trim().isEmpty()) {
            return "UTF-8"; // Default to UTF-8 if null or empty
        }

        // Create mapping of MIME charset names to Java charset names
        Map<String, String> charsetMap = new HashMap<>();
        charsetMap.put("iso-8859-1", "ISO-8859-1");
        charsetMap.put("iso_8859_1", "ISO-8859-1");
        charsetMap.put("iso8859_1", "ISO-8859-1");
        charsetMap.put("iso_8859-1", "ISO-8859-1");
        charsetMap.put("iso8859-1", "ISO-8859-1");
        charsetMap.put("latin1", "ISO-8859-1");
        charsetMap.put("utf-8", "UTF-8");
        charsetMap.put("utf8", "UTF-8");
        charsetMap.put("utf_8", "UTF-8");
        charsetMap.put("ascii", "US-ASCII");
        charsetMap.put("us-ascii", "US-ASCII");
        charsetMap.put("us_ascii", "US-ASCII");
        charsetMap.put("cp1252", "windows-1252");
        charsetMap.put("windows-1252", "windows-1252");
        charsetMap.put("win-1252", "windows-1252");

        String normalizedCharset = charset.toLowerCase().trim();
        
        // Check if charset exists in our mapping
        if (charsetMap.containsKey(normalizedCharset)) {
            return charsetMap.get(normalizedCharset);
        }
        
        // If not in mapping, verify if it's a supported charset
        try {
            Charset.forName(charset);
            return charset; // Return original if it's valid
        } catch (Exception e) {
            return "UTF-8"; // Default to UTF-8 if unsupported
        }
    }
}