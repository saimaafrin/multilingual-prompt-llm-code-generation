import java.util.List;

public class StringUtils {

    /**
     * Verificación sin distinción entre mayúsculas y minúsculas: Comprueba si la cadena contiene algún carácter en el conjunto de cadenas dado.
     * 
     * @param str La cadena en la que se buscará.
     * @param searchStrArray Lista de cadenas a buscar en la cadena principal.
     * @return true si la cadena contiene alguna de las cadenas de búsqueda, false en caso contrario.
     */
    public static boolean containsAnyIgnoreCase(String str, List<String> searchStrArray) {
        if (str == null || searchStrArray == null || searchStrArray.isEmpty()) {
            return false;
        }

        String lowerCaseStr = str.toLowerCase();
        for (String searchStr : searchStrArray) {
            if (searchStr != null && lowerCaseStr.contains(searchStr.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        List<String> searchStrings = List.of("hola", "mundo", "java");
        String text = "Bienvenido al Mundo de Java!";
        
        boolean result = containsAnyIgnoreCase(text, searchStrings);
        System.out.println("¿El texto contiene alguna de las cadenas? " + result);
    }
}