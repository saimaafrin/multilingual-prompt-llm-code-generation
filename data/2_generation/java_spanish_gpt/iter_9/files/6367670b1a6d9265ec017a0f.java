import java.util.List;

public class StringUtils {

    /** 
     * Verificación sin distinción entre mayúsculas y minúsculas: Comprueba si la cadena contiene algún carácter en el conjunto de cadenas dado. 
     */
    public static boolean containsAnyIgnoreCase(String str, List<String> searchStrArray) {
        if (str == null || searchStrArray == null) {
            return false;
        }
        String lowerStr = str.toLowerCase();
        for (String searchStr : searchStrArray) {
            if (searchStr != null && lowerStr.contains(searchStr.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        List<String> searchStrArray = List.of("abc", "def", "ghi");
        String str = "Abcdef";
        boolean result = containsAnyIgnoreCase(str, searchStrArray);
        System.out.println("Contains any: " + result); // Debería imprimir: Contains any: true
    }
}