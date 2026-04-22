import java.util.HashMap;
import java.util.Map;

public class CharUtils {

    private static final Map<Character, String> CHAR_CACHE = new HashMap<>();

    static {
        // Pre-cache ASCII characters (0-127)
        for (int i = 0; i < 128; i++) {
            CHAR_CACHE.put((char) i, String.valueOf((char) i));
        }
    }

    /**
     * <p>Converte il carattere in una Stringa che contiene il singolo carattere.</p>
     * <p>Per i caratteri ASCII a 7 bit, utilizza una cache che restituirà lo stesso oggetto String ogni volta.</p>
     * <pre> CharUtils.toString(' ')  = " " CharUtils.toString('A')  = "A" </pre>
     * @param ch  il carattere da convertire
     * @return una Stringa contenente il carattere specificato
     */
    public static String toString(final char ch) {
        if (ch < 128) {
            return CHAR_CACHE.get(ch);
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(toString(' '));  // Output: " "
        System.out.println(toString('A'));  // Output: "A"
        System.out.println(toString('€'));  // Output: "€" (non-ASCII character)
    }
}