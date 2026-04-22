public class StringUtils {

    /** 
     * Encuentra el primer índice dentro de una cadena, manejando <code>null</code>. Este método utiliza {@link String#indexOf(String)}. 
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1; // Retorna -1 si la cadena o la subcadena son nulas
        }
        return str.indexOf(searchStr); // Retorna el índice de la subcadena
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String str = "Hola Mundo";
        String searchStr = "Mundo";
        int index = indexOf(str, searchStr);
        System.out.println("El índice de '" + searchStr + "' en '" + str + "' es: " + index);
    }
}