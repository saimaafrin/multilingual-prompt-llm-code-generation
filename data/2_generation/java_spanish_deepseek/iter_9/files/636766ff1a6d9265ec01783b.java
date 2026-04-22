public class StringUtils {

    /**
     * Obtiene una subcadena de la cadena especificada evitando excepciones.
     * 
     * @param str   La cadena de la cual se obtendrá la subcadena.
     * @param start El índice inicial (inclusive) de la subcadena.
     * @param end   El índice final (exclusive) de la subcadena.
     * @return La subcadena resultante, o una cadena vacía si los índices son inválidos.
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
        System.out.println(sub(testStr, 7, 20));  // Output: "World!"
        System.out.println(sub(testStr, 10, 7)); // Output: ""
        System.out.println(sub(null, 0, 5));     // Output: ""
    }
}