import java.util.HashMap;
import java.util.Map;

public class CharUtils {

    private static final Map<Character, Character> CHAR_CACHE = new HashMap<>();

    static {
        // Pre-cache ASCII 7-bit characters
        for (int i = 0; i < 128; i++) {
            CHAR_CACHE.put((char) i, (char) i);
        }
    }

    /**
     * <p>चरित्र को एक Character में परिवर्तित करता है।</p>
     * <p>ASCII 7 बिट चरित्रों के लिए, यह एक कैश का उपयोग करता है जो हर बार वही Character ऑब्जेक्ट लौटाता है।</p>
     * <pre>
     * CharUtils.toCharacterObject(' ')  = ' '
     * CharUtils.toCharacterObject('A')  = 'A'
     * </pre>
     *
     * @param ch वह चरित्र जिसे परिवर्तित करना है
     * @return निर्दिष्ट चरित्र का एक Character
     */
    public static Character toCharacterObject(final char ch) {
        if (ch < 128) {
            return CHAR_CACHE.get(ch);
        }
        return ch;
    }

    public static void main(String[] args) {
        System.out.println(toCharacterObject(' ')); // Output: ' '
        System.out.println(toCharacterObject('A')); // Output: 'A'
        System.out.println(toCharacterObject('€')); // Output: '€' (non-ASCII character)
    }
}