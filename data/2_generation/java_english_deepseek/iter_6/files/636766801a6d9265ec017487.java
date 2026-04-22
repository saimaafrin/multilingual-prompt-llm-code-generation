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

        StringBuilder encodedString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '{') {
                encodedString.append("%7B");
            } else if (c == '}') {
                encodedString.append("%7D");
            } else {
                encodedString.append(c);
            }
        }

        return encodedString.toString();
    }

    public static void main(String[] args) {
        String input = "This is a {template} with {parameters}.";
        String encoded = encodeTemplateNames(input);
        System.out.println(encoded);  // Output: This is a %7Btemplate%7D with %7Bparameters%7D.
    }
}