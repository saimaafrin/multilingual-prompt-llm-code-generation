import java.util.HashMap;
import java.util.Map;

public class TemplateEncoder {

    public static String encodeTemplateNames(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        // Create a map to store the special characters and their encoded values
        Map<Character, String> encodingMap = new HashMap<>();
        encodingMap.put('{', "%7B");
        encodingMap.put('}', "%7D");

        StringBuilder encodedString = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (encodingMap.containsKey(c)) {
                encodedString.append(encodingMap.get(c));
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