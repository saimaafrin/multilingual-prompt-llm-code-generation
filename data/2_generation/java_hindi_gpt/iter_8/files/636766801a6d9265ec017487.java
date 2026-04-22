import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
                    encodedString.append(URLEncoder.encode(String.valueOf(c), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    // This should never happen since UTF-8 is always supported
                    throw new RuntimeException(e);
                }
            } else {
                encodedString.append(c);
            }
        }
        return encodedString.toString();
    }

    public static void main(String[] args) {
        String input = "Hello {name}, welcome to {place}!";
        String encoded = encodeTemplateNames(input);
        System.out.println(encoded);
    }
}