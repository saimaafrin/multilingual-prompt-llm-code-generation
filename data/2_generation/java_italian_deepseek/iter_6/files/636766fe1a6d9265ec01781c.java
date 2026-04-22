import java.util.HashMap;
import java.util.Map;

public class CharUtils {

    private static final Map<Character, Character> CHAR_CACHE = new HashMap<>();

    static {
        // Cache dei caratteri ASCII a 7 bit (0-127)
        for (int i = 0; i < 128; i++) {
            CHAR_CACHE.put((char) i, (char) i);
        }
    }

    /**
     * <p>Converte il carattere in un oggetto Character.</p>
     * <p>Per i caratteri ASCII a 7 bit, utilizza una cache che restituirà lo stesso oggetto Character ogni volta.</p>
     * <pre>
     * CharUtils.toCharacterObject(' ')  = ' '
     * CharUtils.toCharacterObject('A')  = 'A'
     * </pre>
     * @param ch  il carattere da convertire
     * @return un oggetto Character del carattere specificato
     */
    public static Character toCharacterObject(final char ch) {
        if (ch < 128) {
            return CHAR_CACHE.get(ch);
        }
        return ch;
    }

    public static void main(String[] args) {
        System.out.println(toCharacterObject(' '));  // Output: ' '
        System.out.println(toCharacterObject('A'));  // Output: 'A'
    }
}