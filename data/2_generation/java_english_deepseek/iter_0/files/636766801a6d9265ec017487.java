import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
        
        // Replace '{' with '%7B' and '}' with '%7D'
        s = s.replace("{", "%7B");
        s = s.replace("}", "%7D");
        
        return s;
    }

    public static void main(String[] args) {
        String input = "This is a {template} string with {parameters}.";
        String encoded = encodeTemplateNames(input);
        System.out.println(encoded);  // Output: This is a %7Btemplate%7D string with %7Bparameters%7D.
    }
}