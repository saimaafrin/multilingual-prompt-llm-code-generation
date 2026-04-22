import java.util.HashMap;
import java.util.Map;

public class CharUtils {

    private static final Map<Character, String> CHAR_CACHE = new HashMap<>();

    static {
        // Pre-populate the cache with ASCII characters
        for (int i = 0; i < 128; i++) {
            char c = (char) i;
            CHAR_CACHE.put(c, String.valueOf(c));
        }
    }

    /**
     * <p>एक वर्ण को एक स्ट्रिंग में परिवर्तित करता है जिसमें केवल वही वर्ण होता है।</p>
     * <p>ASCII 7 बिट वर्णों के लिए, यह एक कैश का उपयोग करता है जो हर बार वही स्ट्रिंग ऑब्जेक्ट लौटाता है।</p>
     * <pre>
     * CharUtils.toString(' ')  = " "
     * CharUtils.toString('A')  = "A"
     * </pre>
     * @param ch  वह वर्ण जिसे परिवर्तित करना है
     * @return एक स्ट्रिंग जो निर्दिष्ट वर्ण को समाहित करती है
     */
    public static String toString(final char ch) {
        if (ch < 128) {
            return CHAR_CACHE.get(ch);
        } else {
            return String.valueOf(ch);
        }
    }

    public static void main(String[] args) {
        System.out.println(toString(' '));  // Output: " "
        System.out.println(toString('A'));  // Output: "A"
        System.out.println(toString('€'));  // Output: "€" (non-ASCII character)
    }
}