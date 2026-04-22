public class StringUtils {

    /**
     * Ottiene una sottostringa dalla Stringa specificata evitando eccezioni.
     * Se la stringa è null, restituisce una stringa vuota.
     * Se start o end sono fuori dai limiti, li adatta ai limiti della stringa.
     *
     * @param str   La stringa da cui estrarre la sottostringa.
     * @param start L'indice di inizio (inclusivo).
     * @param end   L'indice di fine (esclusivo).
     * @return La sottostringa estratta, o una stringa vuota se str è null.
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return "";
        }

        int length = str.length();
        if (start < 0) {
            start = 0;
        }
        if (end > length) {
            end = length;
        }
        if (start >= end) {
            return "";
        }

        return str.substring(start, end);
    }

    public static void main(String[] args) {
        // Esempi di utilizzo
        System.out.println(sub("Hello, World!", 7, 12)); // Output: "World"
        System.out.println(sub("Hello, World!", -1, 5)); // Output: "Hello"
        System.out.println(sub("Hello, World!", 7, 20)); // Output: "World!"
        System.out.println(sub(null, 0, 5)); // Output: ""
        System.out.println(sub("Hello, World!", 10, 7)); // Output: ""
    }
}