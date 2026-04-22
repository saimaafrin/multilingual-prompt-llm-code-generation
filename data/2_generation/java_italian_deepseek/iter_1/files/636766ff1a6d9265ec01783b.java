public class StringUtils {

    /**
     * Ottiene una sottostringa dalla Stringa specificata evitando eccezioni.
     * 
     * @param str   La stringa da cui estrarre la sottostringa.
     * @param start L'indice di inizio della sottostringa.
     * @param end   L'indice di fine della sottostringa.
     * @return La sottostringa estratta, o una stringa vuota se gli indici sono fuori dai limiti.
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
        System.out.println(sub(testStr, -1, 5)); // Output: "Hello"
        System.out.println(sub(testStr, 7, 20)); // Output: "World!"
        System.out.println(sub(testStr, 10, 7)); // Output: ""
        System.out.println(sub(null, 0, 5));    // Output: ""
    }
}