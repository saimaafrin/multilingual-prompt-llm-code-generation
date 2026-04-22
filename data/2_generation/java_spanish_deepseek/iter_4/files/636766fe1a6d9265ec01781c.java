import java.util.HashMap;
import java.util.Map;

public class CharUtils {

    private static final Map<Character, Character> CACHE = new HashMap<>();

    static {
        // Pre-cache ASCII characters (0-127)
        for (int i = 0; i < 128; i++) {
            CACHE.put((char) i, (char) i);
        }
    }

    /**
     * <p>Convierte el carácter a un objeto "Character".</p>
     * <p>Para caracteres ASCII de 7 bits, utiliza una caché que devolverá el mismo objeto "Character" cada vez.</p>
     * <pre>
     * CharUtils.toCharacterObject(' ')  = ' '
     * CharUtils.toCharacterObject('A')  = 'A'
     * </pre>
     * @param ch  el carácter a convertir
     * @return un objeto "Character" del carácter especificado
     */
    public static Character toCharacterObject(final char ch) {
        if (ch < 128) {
            return CACHE.get(ch);
        }
        return ch;
    }

    public static void main(String[] args) {
        System.out.println(toCharacterObject(' '));  // Output: ' '
        System.out.println(toCharacterObject('A'));  // Output: 'A'
    }
}