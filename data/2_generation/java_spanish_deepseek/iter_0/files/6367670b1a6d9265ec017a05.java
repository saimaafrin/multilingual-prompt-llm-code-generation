public class CharUtils {

    private static final String[] CHAR_STRING_CACHE = new String[128];

    static {
        for (char c = 0; c < CHAR_STRING_CACHE.length; c++) {
            CHAR_STRING_CACHE[c] = String.valueOf(c);
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
        if (ch < CHAR_STRING_CACHE.length) {
            return CHAR_STRING_CACHE[ch];
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(toString(' '));  // Output: " "
        System.out.println(toString('A'));  // Output: "A"
        System.out.println(toString('€'));  // Output: "€" (non-ASCII character)
    }
}