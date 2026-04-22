public class StringUtils {

    /**
     * Ottiene una sottostringa dalla Stringa specificata evitando eccezioni.
     * Se la stringa è null, restituisce una stringa vuota.
     * Se start o end sono fuori dai limiti, vengono adattati ai limiti della stringa.
     *
     * @param str   La stringa da cui estrarre la sottostringa.
     * @param start L'indice di inizio (inclusivo).
     * @param end   L'indice di fine (esclusivo).
     * @return La sottostringa estratta, o una stringa vuota se la stringa è null.
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
        String testStr = "Hello, World!";
        System.out.println(sub(testStr, 7, 12)); // Output: "World"
        System.out.println(sub(testStr, -1, 5));  // Output: "Hello"
        System.out.println(sub(testStr, 7, 20)); // Output: "World!"
        System.out.println(sub(null, 0, 5));      // Output: ""
    }
}