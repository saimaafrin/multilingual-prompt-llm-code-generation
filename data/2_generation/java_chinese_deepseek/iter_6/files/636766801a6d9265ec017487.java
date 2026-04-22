import java.nio.charset.StandardCharsets;
import java.net.URLEncoder;

public class TemplateEncoder {
    public static String encodeTemplateNames(String s) {
        if (s == null) {
            return null;
        }
        
        StringBuilder encodedString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '}') {
                try {
                    encodedString.append(URLEncoder.encode(String.valueOf(c), StandardCharsets.UTF_8.toString()));
                } catch (Exception e) {
                    // Handle encoding exception if necessary
                    encodedString.append(c);
                }
            } else {
                encodedString.append(c);
            }
        }
        return encodedString.toString();
    }

    public static void main(String[] args) {
        String input = "This is a {template} with {parameters}.";
        String encoded = encodeTemplateNames(input);
        System.out.println(encoded);
    }
}