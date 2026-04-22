import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TemplateEncoder {
    /**
     * Encodes a string with template parameters names present, specifically the characters '{' and '}' will be percent-encoded.
     * @param s the string with zero or more template parameters names
     * @return the string with encoded template parameters names.
     */
    public static String encodeTemplateParameters(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        
        // Replace { with %7B and } with %7D
        return s.replace("{", "%7B").replace("}", "%7D");
    }
}