import java.util.HashMap;
import java.util.Map;

public class CharUtils {

    // Cache for ASCII characters (0-127)
    private static final Character[] ASCII_CACHE = new Character[128];

    static {
        for (int i = 0; i < 128; i++) {
            ASCII_CACHE[i] = (char) i;
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
            return ASCII_CACHE[ch];
        }
        return ch;
    }

    public static void main(String[] args) {
        System.out.println(toCharacterObject(' '));  // Output: ' '
        System.out.println(toCharacterObject('A')); // Output: 'A'
    }
}