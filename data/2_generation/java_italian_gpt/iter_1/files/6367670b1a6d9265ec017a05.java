public class CharUtils {
    private static final String[] cache = new String[128];

    static {
        for (int i = 0; i < cache.length; i++) {
            cache[i] = String.valueOf((char) i);
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
        if (ch >= 0 && ch < 128) {
            return cache[ch];
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(CharUtils.toString(' ')); // Output: " "
        System.out.println(CharUtils.toString('A')); // Output: "A"
        System.out.println(CharUtils.toString('é')); // Output: "é"
    }
}