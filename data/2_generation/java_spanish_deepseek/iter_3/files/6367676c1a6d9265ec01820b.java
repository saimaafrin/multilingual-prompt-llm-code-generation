import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString;
        }

        // Convertir el conjunto de caracteres a eliminar en un Set para búsqueda rápida
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
        System.out.println(result);  // Salida: "Hl, mnd!Est s n jmpl."
    }
}