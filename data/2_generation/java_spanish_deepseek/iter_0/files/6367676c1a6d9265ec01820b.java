import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    /**
     * Elimina cualquier carácter en una cadena dada.
     * @param inString la cadena original
     * @param charsToDelete un conjunto de caracteres a eliminar. Por ejemplo, "az\n" eliminará las 'a', 'z' y los saltos de línea.
     * @return la cadena resultante
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString;
        }

        // Crear un conjunto de caracteres a eliminar
        Set<Character> charsToRemove = new HashSet<>();
        for (char c : charsToDelete.toCharArray()) {
            charsToRemove.add(c);
        }

        // Construir la cadena resultante
        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (!charsToRemove.contains(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hola, mundo!\nEste es un ejemplo.";
        String charsToDelete = "aeiou\n";
        String result = deleteAny(input, charsToDelete);
        System.out.println(result);  // Salida: Hl, mnd!Est s n jmpl.
    }
}