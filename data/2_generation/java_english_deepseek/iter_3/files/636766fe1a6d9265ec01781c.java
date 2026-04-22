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
     * <p>Converts the character to a Character.</p> <p>For ASCII 7 bit characters, this uses a cache that will return the same Character object each time.</p> <pre> CharUtils.toCharacterObject(' ')  = ' ' CharUtils.toCharacterObject('A')  = 'A' </pre>
     * @param ch  the character to convert
     * @return a Character of the specified character
     */
    public static Character toCharacterObject(final char ch) {
        if (ch < 128) {
            return CHAR_CACHE.get(ch);
        }
        return ch;
    }
}