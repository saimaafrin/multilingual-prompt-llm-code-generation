import java.util.HashMap;
import java.util.Map;

public class CharUtils {

    private static final Map<Character, String> CACHE = new HashMap<>();

    static {
        // Pre-cache ASCII characters (0-127)
        for (int i = 0; i < 128; i++) {
            CACHE.put((char) i, String.valueOf((char) i));
        }
    }

    /**
     * <p>Convierte el carácter en una cadena que contiene un solo carácter.</p>
     * <p>Para caracteres ASCII de 7 bits, utiliza una caché que devolverá el mismo objeto String cada vez.</p>
     * <pre>
     * CharUtils.toString(' ')  = " "
     * CharUtils.toString('A')  = "A"
     * </pre>
     * @param ch  el carácter a convertir
     * @return una cadena que contiene el carácter especificado
     */
    public static String toString(final char ch) {
        if (ch < 128) {
            return CACHE.get(ch);
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(toString(' '));  // Output: " "
        System.out.println(toString('A'));  // Output: "A"
        System.out.println(toString('ñ'));  // Output: "ñ"
    }
}