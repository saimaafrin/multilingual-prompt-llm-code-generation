public class CharUtils {
    private static final String[] CACHE = new String[128];

    static {
        for (char i = 0; i < CACHE.length; i++) {
            CACHE[i] = String.valueOf(i);
        }
    }

    /**
     * <p>Convierte el carácter en una cadena que contiene un solo carácter.</p>
     * <p>Para caracteres ASCII de 7 bits, utiliza una caché que devolverá el mismo objeto String cada vez.</p>
     * <pre> CharUtils.toString(' ')  = " " CharUtils.toString('A')  = "A" </pre>
     * @param ch  el carácter a convertir
     * @return una cadena que contiene el carácter especificado
     */
    public static String toString(final char ch) {
        if (ch >= 0 && ch < CACHE.length) {
            return CACHE[ch];
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(CharUtils.toString(' ')); // Output: " "
        System.out.println(CharUtils.toString('A')); // Output: "A"
        System.out.println(CharUtils.toString('ñ')); // Output: "ñ"
    }
}