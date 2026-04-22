import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        // Replace '{' with '%7B' and '}' with '%7D'
        String encodedString = s.replace("{", "%7B").replace("}", "%7D");

        return encodedString;
    }

    public static void main(String[] args) {
        String input = "Hello {name}, your code is {code}.";
        String encoded = encodeTemplateNames(input);
        System.out.println(encoded);  // Output: Hello %7Bname%7D, your code is %7Bcode%7D.
    }
}