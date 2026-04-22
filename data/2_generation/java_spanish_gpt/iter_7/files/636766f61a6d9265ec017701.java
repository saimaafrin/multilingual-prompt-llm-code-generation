public class StringUtil {
    
    /** 
     * Encuentra el último índice dentro de una cadena, manejando <code>null</code>. Este método utiliza {@link String#lastIndexOf(String)}. 
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(lastIndexOf("Hello World", "o")); // Salida: 7
        System.out.println(lastIndexOf("Hello World", "l")); // Salida: 9
        System.out.println(lastIndexOf("Hello World", "x")); // Salida: -1
        System.out.println(lastIndexOf(null, "o"));          // Salida: -1
        System.out.println(lastIndexOf("Hello World", null)); // Salida: -1
    }
}