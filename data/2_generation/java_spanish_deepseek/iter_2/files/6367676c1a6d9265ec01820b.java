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

        // Convertir el conjunto de caracteres a eliminar en un Set para un acceso rápido
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
        String input = "Hola, este es un ejemplo.\n";
        String charsToDelete = "ae\n";
        String result = deleteAny(input, charsToDelete);
        System.out.println(result);  // Salida: Hol, st s un jmplo.
    }
}