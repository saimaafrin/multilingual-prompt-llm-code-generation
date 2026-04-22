import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TemplateEncoder {

    /**
     * एक स्ट्रिंग को एन्कोड करता है जिसमें टेम्पलेट पैरामीटर नाम मौजूद होते हैं, विशेष रूप से '{' और '}' अक्षरों को प्रतिशत-कोडित किया जाएगा।
     * @param s वह स्ट्रिंग जिसमें शून्य या अधिक टेम्पलेट पैरामीटर नाम हैं
     * @return एन्कोडेड टेम्पलेट पैरामीटर नामों के साथ स्ट्रिंग।
     */
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
                    // Handle encoding exception
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