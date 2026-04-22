public class SubstringUtil {

    /** 
     * Obtiene una subcadena de la cadena especificada evitando excepciones. 
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        if (end > str.length()) {
            end = str.length();
        }
        if (start > end) {
            return "";
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String result = sub("Hola Mundo", 0, 4);
        System.out.println(result); // Salida: Hola
    }
}