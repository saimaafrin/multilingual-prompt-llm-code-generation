import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateEncoder {
    /**
     * Encodes a string with template parameters names present, specifically the characters '{' and '}' will be percent-encoded.
     * @param s the string with zero or more template parameters names
     * @return the string with encoded template parameters names.
     */
    public static String encodeTemplateNames(String s) {
        if (s == null) {
            return null;
        }
        
        // Replace { with %7B and } with %7D
        String encoded = s.replaceAll("\\{", "%7B")
                         .replaceAll("\\}", "%7D");
                         
        return encoded;
    }
}