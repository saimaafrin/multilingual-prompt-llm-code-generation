public class StringUtils {

    /** 
     * Encuentra el primer índice dentro de una cadena, manejando <code>null</code>. Este método utiliza {@link String#indexOf(String)}. 
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(indexOf("Hola Mundo", "Mundo")); // Salida: 5
        System.out.println(indexOf("Hola Mundo", "Adiós")); // Salida: -1
        System.out.println(indexOf(null, "Mundo")); // Salida: -1
        System.out.println(indexOf("Hola Mundo", null)); // Salida: -1
    }
}