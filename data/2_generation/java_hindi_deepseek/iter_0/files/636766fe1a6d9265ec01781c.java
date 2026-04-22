import java.util.HashMap;
import java.util.Map;

public class CharUtils {

    private static final Map<Character, Character> CHAR_CACHE = new HashMap<>();

    /**
     * <p>चरित्र को एक Character में परिवर्तित करता है।</p>
     * <p>ASCII 7 बिट चरित्रों के लिए, यह एक कैश का उपयोग करता है जो हर बार वही Character ऑब्जेक्ट लौटाता है।</p>
     * <pre>
     * CharUtils.toCharacterObject(' ')  = ' '
     * CharUtils.toCharacterObject('A')  = 'A'
     * </pre>
     * @param ch  वह चरित्र जिसे परिवर्तित करना है
     * @return निर्दिष्ट चरित्र का एक Character
     */
    public static Character toCharacterObject(final char ch) {
        if (ch <= 127) { // ASCII 7-bit characters
            return CHAR_CACHE.computeIfAbsent(ch, k -> Character.valueOf(ch));
        }
        return Character.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(toCharacterObject(' ')); // Output: ' '
        System.out.println(toCharacterObject('A')); // Output: 'A'
    }
}