public class StringUtils {

    /**
     * Ottiene una sottostringa dalla Stringa specificata evitando eccezioni.
     * Se la stringa è null, restituisce una stringa vuota.
     * Se start è maggiore della lunghezza della stringa, restituisce una stringa vuota.
     * Se end è maggiore della lunghezza della stringa, restituisce la sottostringa da start alla fine della stringa.
     * Se start è maggiore di end, restituisce una stringa vuota.
     *
     * @param str   La stringa da cui estrarre la sottostringa.
     * @param start L'indice di inizio della sottostringa.
     * @param end   L'indice di fine della sottostringa.
     * @return La sottostringa estratta, o una stringa vuota se i parametri non sono validi.
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        if (start >= length || start > end) {
            return "";
        }
        if (end > length) {
            end = length;
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(sub("Hello, World!", 7, 12)); // "World"
        System.out.println(sub("Hello, World!", 0, 5));  // "Hello"
        System.out.println(sub("Hello, World!", 7, 20)); // "World!"
        System.out.println(sub("Hello, World!", 20, 25)); // ""
        System.out.println(sub(null, 0, 5)); // ""
        System.out.println(sub("Hello, World!", 5, 2)); // ""
    }
}