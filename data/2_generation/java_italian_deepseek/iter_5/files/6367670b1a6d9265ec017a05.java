public class CharUtils {

    private static final String[] CHAR_STRING_CACHE = new String[128];

    static {
        for (char c = 0; c < CHAR_STRING_CACHE.length; c++) {
            CHAR_STRING_CACHE[c] = String.valueOf(c);
        }
    }

    /**
     * Converte il carattere in una Stringa che contiene il singolo carattere.
     * Per i caratteri ASCII a 7 bit, utilizza una cache che restituirà lo stesso oggetto String ogni volta.
     * <pre>
     * CharUtils.toString(' ')  = " "
     * CharUtils.toString('A')  = "A"
     * </pre>
     * @param ch  il carattere da convertire
     * @return una Stringa contenente il carattere specificato
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