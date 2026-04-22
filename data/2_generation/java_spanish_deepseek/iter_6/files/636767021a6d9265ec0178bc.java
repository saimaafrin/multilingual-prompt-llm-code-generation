public class StringUtils {

    /**
     * Encuentra el primer índice dentro de una cadena, manejando <code>null</code>. Este método utiliza {@link String#indexOf(String)}.
     * 
     * @param str La cadena en la que se buscará, puede ser <code>null</code>.
     * @param searchStr La cadena que se buscará, puede ser <code>null</code>.
     * @return El índice de la primera ocurrencia de <code>searchStr</code> en <code>str</code>, o -1 si no se encuentra o si alguna de las cadenas es <code>null</code>.
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String str = "Hola, mundo!";
        String searchStr = "mundo";
        int index = indexOf(str, searchStr);
        System.out.println("Índice de '" + searchStr + "' en '" + str + "': " + index);
    }
}