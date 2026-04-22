import java.nio.charset.StandardCharsets;

public class TemplateEncoder {
    public static String encodeTemplateNames(String s) {
        if (s == null) {
            return null;
        }
        
        StringBuilder encodedString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '}') {
                encodedString.append(percentEncode(c));
            } else {
                encodedString.append(c);
            }
        }
        return encodedString.toString();
    }

    private static String percentEncode(char c) {
        byte[] bytes = String.valueOf(c).getBytes(StandardCharsets.UTF_8);
        StringBuilder encoded = new StringBuilder();
        for (byte b : bytes) {
            encoded.append('%');
            encoded.append(String.format("%02X", b));
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        String input = "This is a {test} string with {template} parameters.";
        String encoded = encodeTemplateNames(input);
        System.out.println(encoded);
    }
}