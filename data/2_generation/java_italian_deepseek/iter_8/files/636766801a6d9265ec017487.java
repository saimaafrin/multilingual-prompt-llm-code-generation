import java.util.HashMap;
import java.util.Map;

public class TemplateEncoder {

    public static String encodeTemplateNames(String s) {
        if (s == null) {
            return null;
        }

        // Create a map to store the characters to be encoded and their corresponding encoded values
        Map<Character, String> encodingMap = new HashMap<>();
        encodingMap.put('{', "%7B");
        encodingMap.put('}', "%7D");

        StringBuilder encodedString = new StringBuilder();

        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {
            // If the character is in the encoding map, append its encoded value
            if (encodingMap.containsKey(c)) {
                encodedString.append(encodingMap.get(c));
            } else {
                // Otherwise, append the character as is
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